package android.transition;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import com.android.internal.R;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class TransitionInflater {
    private static final Class<?>[] sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
    private static final ArrayMap<String, Constructor> sConstructors = new ArrayMap();
    private Context mContext;

    private TransitionInflater(Context context) {
        this.mContext = context;
    }

    public static TransitionInflater from(Context context) {
        return new TransitionInflater(context);
    }

    public Transition inflateTransition(int resource) {
        InflateException ex;
        XmlResourceParser parser = this.mContext.getResources().getXml(resource);
        try {
            Transition createTransitionFromXml = createTransitionFromXml(parser, Xml.asAttributeSet(parser), null);
            parser.close();
            return createTransitionFromXml;
        } catch (XmlPullParserException e) {
            ex = new InflateException(e.getMessage());
            ex.initCause(e);
            throw ex;
        } catch (IOException e2) {
            ex = new InflateException(parser.getPositionDescription() + ": " + e2.getMessage());
            ex.initCause(e2);
            throw ex;
        } catch (Throwable th) {
            parser.close();
        }
    }

    public TransitionManager inflateTransitionManager(int resource, ViewGroup sceneRoot) {
        InflateException ex;
        XmlResourceParser parser = this.mContext.getResources().getXml(resource);
        try {
            TransitionManager createTransitionManagerFromXml = createTransitionManagerFromXml(parser, Xml.asAttributeSet(parser), sceneRoot);
            parser.close();
            return createTransitionManagerFromXml;
        } catch (XmlPullParserException e) {
            ex = new InflateException(e.getMessage());
            ex.initCause(e);
            throw ex;
        } catch (IOException e2) {
            ex = new InflateException(parser.getPositionDescription() + ": " + e2.getMessage());
            ex.initCause(e2);
            throw ex;
        } catch (Throwable th) {
            parser.close();
        }
    }

    private Transition createTransitionFromXml(XmlPullParser parser, AttributeSet attrs, Transition parent) throws XmlPullParserException, IOException {
        Transition transition = null;
        int depth = parser.getDepth();
        TransitionSet transitionSet = parent instanceof TransitionSet ? (TransitionSet) parent : null;
        while (true) {
            int type = parser.next();
            if ((type != 3 || parser.getDepth() > depth) && type != 1) {
                if (type == 2) {
                    String name = parser.getName();
                    if ("fade".equals(name)) {
                        transition = new Fade(this.mContext, attrs);
                    } else if ("changeBounds".equals(name)) {
                        transition = new ChangeBounds(this.mContext, attrs);
                    } else if ("slide".equals(name)) {
                        transition = new Slide(this.mContext, attrs);
                    } else if ("explode".equals(name)) {
                        transition = new Explode(this.mContext, attrs);
                    } else if ("changeImageTransform".equals(name)) {
                        transition = new ChangeImageTransform(this.mContext, attrs);
                    } else if ("changeTransform".equals(name)) {
                        transition = new ChangeTransform(this.mContext, attrs);
                    } else if ("changeClipBounds".equals(name)) {
                        transition = new ChangeClipBounds(this.mContext, attrs);
                    } else if ("autoTransition".equals(name)) {
                        transition = new AutoTransition(this.mContext, attrs);
                    } else if ("recolor".equals(name)) {
                        transition = new Recolor(this.mContext, attrs);
                    } else if ("changeScroll".equals(name)) {
                        transition = new ChangeScroll(this.mContext, attrs);
                    } else if ("transitionSet".equals(name)) {
                        transition = new TransitionSet(this.mContext, attrs);
                    } else if ("transition".equals(name)) {
                        transition = (Transition) createCustom(attrs, Transition.class, "transition");
                    } else if ("targets".equals(name)) {
                        getTargetIds(parser, attrs, parent);
                    } else if ("arcMotion".equals(name)) {
                        parent.setPathMotion(new ArcMotion(this.mContext, attrs));
                    } else if ("pathMotion".equals(name)) {
                        parent.setPathMotion((PathMotion) createCustom(attrs, PathMotion.class, "pathMotion"));
                    } else if ("patternPathMotion".equals(name)) {
                        parent.setPathMotion(new PatternPathMotion(this.mContext, attrs));
                    } else {
                        throw new RuntimeException("Unknown scene name: " + parser.getName());
                    }
                    if (transition == null) {
                        continue;
                    } else {
                        if (!parser.isEmptyElementTag()) {
                            createTransitionFromXml(parser, attrs, transition);
                        }
                        if (transitionSet != null) {
                            transitionSet.addTransition(transition);
                            transition = null;
                        } else if (parent != null) {
                            throw new InflateException("Could not add transition to another transition.");
                        }
                    }
                }
            }
        }
        return transition;
    }

    private Object createCustom(AttributeSet attrs, Class expectedType, String tag) {
        String className = attrs.getAttributeValue(null, "class");
        if (className == null) {
            throw new InflateException(tag + " tag must have a 'class' attribute");
        }
        try {
            Object newInstance;
            synchronized (sConstructors) {
                Constructor constructor = (Constructor) sConstructors.get(className);
                if (constructor == null) {
                    Class c = this.mContext.getClassLoader().loadClass(className).asSubclass(expectedType);
                    if (c != null) {
                        constructor = c.getConstructor(sConstructorSignature);
                        constructor.setAccessible(true);
                        sConstructors.put(className, constructor);
                    }
                }
                newInstance = constructor.newInstance(new Object[]{this.mContext, attrs});
            }
            return newInstance;
        } catch (InstantiationException e) {
            throw new InflateException("Could not instantiate " + expectedType + " class " + className, e);
        } catch (ClassNotFoundException e2) {
            throw new InflateException("Could not instantiate " + expectedType + " class " + className, e2);
        } catch (InvocationTargetException e3) {
            throw new InflateException("Could not instantiate " + expectedType + " class " + className, e3);
        } catch (NoSuchMethodException e4) {
            throw new InflateException("Could not instantiate " + expectedType + " class " + className, e4);
        } catch (IllegalAccessException e5) {
            throw new InflateException("Could not instantiate " + expectedType + " class " + className, e5);
        }
    }

    private void getTargetIds(XmlPullParser parser, AttributeSet attrs, Transition transition) throws XmlPullParserException, IOException {
        int depth = parser.getDepth();
        while (true) {
            int type = parser.next();
            if ((type == 3 && parser.getDepth() <= depth) || type == 1) {
                return;
            }
            if (type == 2) {
                if (parser.getName().equals("target")) {
                    TypedArray a = this.mContext.obtainStyledAttributes(attrs, R.styleable.TransitionTarget);
                    int id = a.getResourceId(1, 0);
                    if (id != 0) {
                        transition.addTarget(id);
                    } else {
                        id = a.getResourceId(2, 0);
                        if (id != 0) {
                            transition.excludeTarget(id, true);
                        } else {
                            String transitionName = a.getString(4);
                            if (transitionName != null) {
                                transition.addTarget(transitionName);
                            } else {
                                transitionName = a.getString(5);
                                if (transitionName != null) {
                                    transition.excludeTarget(transitionName, true);
                                } else {
                                    String className = a.getString(3);
                                    if (className != null) {
                                        try {
                                            transition.excludeTarget(Class.forName(className), true);
                                        } catch (ClassNotFoundException e) {
                                            throw new RuntimeException("Could not create " + className, e);
                                        }
                                    }
                                    className = a.getString(0);
                                    if (className != null) {
                                        transition.addTarget(Class.forName(className));
                                    }
                                }
                            }
                        }
                    }
                } else {
                    throw new RuntimeException("Unknown scene name: " + parser.getName());
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.transition.TransitionManager createTransitionManagerFromXml(org.xmlpull.v1.XmlPullParser r8, android.util.AttributeSet r9, android.view.ViewGroup r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        r7 = this;
        r0 = r8.getDepth();
        r2 = 0;
    L_0x0005:
        r3 = r8.next();
        r4 = 3;
        if (r3 != r4) goto L_0x0012;
    L_0x000c:
        r4 = r8.getDepth();
        if (r4 <= r0) goto L_0x0057;
    L_0x0012:
        r4 = 1;
        if (r3 == r4) goto L_0x0057;
    L_0x0015:
        r4 = 2;
        if (r3 != r4) goto L_0x0005;
    L_0x0018:
        r1 = r8.getName();
        r4 = "transitionManager";
        r4 = r1.equals(r4);
        if (r4 == 0) goto L_0x002b;
    L_0x0025:
        r2 = new android.transition.TransitionManager;
        r2.<init>();
        goto L_0x0005;
    L_0x002b:
        r4 = "transition";
        r4 = r1.equals(r4);
        if (r4 == 0) goto L_0x003a;
    L_0x0034:
        if (r2 == 0) goto L_0x003a;
    L_0x0036:
        r7.loadTransition(r9, r10, r2);
        goto L_0x0005;
    L_0x003a:
        r4 = new java.lang.RuntimeException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Unknown scene name: ";
        r5 = r5.append(r6);
        r6 = r8.getName();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0057:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.transition.TransitionInflater.createTransitionManagerFromXml(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.ViewGroup):android.transition.TransitionManager");
    }

    private void loadTransition(AttributeSet attrs, ViewGroup sceneRoot, TransitionManager transitionManager) throws NotFoundException {
        TypedArray a = this.mContext.obtainStyledAttributes(attrs, R.styleable.TransitionManager);
        int transitionId = a.getResourceId(2, -1);
        int fromId = a.getResourceId(0, -1);
        Scene fromScene = fromId < 0 ? null : Scene.getSceneForLayout(sceneRoot, fromId, this.mContext);
        int toId = a.getResourceId(1, -1);
        Scene toScene = toId < 0 ? null : Scene.getSceneForLayout(sceneRoot, toId, this.mContext);
        if (transitionId >= 0) {
            Transition transition = inflateTransition(transitionId);
            if (transition != null) {
                if (toScene == null) {
                    throw new RuntimeException("No toScene for transition ID " + transitionId);
                } else if (fromScene == null) {
                    transitionManager.setTransition(toScene, transition);
                } else {
                    transitionManager.setTransition(fromScene, toScene, transition);
                }
            }
        }
        a.recycle();
    }
}
