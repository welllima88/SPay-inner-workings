package android.hardware.camera2.impl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CaptureResultExtras implements Parcelable {
    public static final Creator<CaptureResultExtras> CREATOR = new Creator<CaptureResultExtras>() {
        public CaptureResultExtras createFromParcel(Parcel in) {
            return new CaptureResultExtras(in);
        }

        public CaptureResultExtras[] newArray(int size) {
            return new CaptureResultExtras[size];
        }
    };
    private int afTriggerId;
    private long frameNumber;
    private int partialResultCount;
    private int precaptureTriggerId;
    private int requestId;
    private int subsequenceId;

    private CaptureResultExtras(Parcel in) {
        readFromParcel(in);
    }

    public CaptureResultExtras(int requestId, int subsequenceId, int afTriggerId, int precaptureTriggerId, long frameNumber, int partialResultCount) {
        this.requestId = requestId;
        this.subsequenceId = subsequenceId;
        this.afTriggerId = afTriggerId;
        this.precaptureTriggerId = precaptureTriggerId;
        this.frameNumber = frameNumber;
        this.partialResultCount = partialResultCount;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.requestId);
        dest.writeInt(this.subsequenceId);
        dest.writeInt(this.afTriggerId);
        dest.writeInt(this.precaptureTriggerId);
        dest.writeLong(this.frameNumber);
        dest.writeInt(this.partialResultCount);
    }

    public void readFromParcel(Parcel in) {
        this.requestId = in.readInt();
        this.subsequenceId = in.readInt();
        this.afTriggerId = in.readInt();
        this.precaptureTriggerId = in.readInt();
        this.frameNumber = in.readLong();
        this.partialResultCount = in.readInt();
    }

    public int getRequestId() {
        return this.requestId;
    }

    public int getSubsequenceId() {
        return this.subsequenceId;
    }

    public int getAfTriggerId() {
        return this.afTriggerId;
    }

    public int getPrecaptureTriggerId() {
        return this.precaptureTriggerId;
    }

    public long getFrameNumber() {
        return this.frameNumber;
    }

    public int getPartialResultCount() {
        return this.partialResultCount;
    }
}
