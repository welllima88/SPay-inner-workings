package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt;
import org.bouncycastle.x509.ExtendedPKIXParameters;

public class CrlOcspRef extends ASN1Object {
    private CrlListID crlids;
    private OcspListID ocspids;
    private OtherRevRefs otherRev;

    private CrlOcspRef(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            DERTaggedObject dERTaggedObject = (DERTaggedObject) objects.nextElement();
            switch (dERTaggedObject.getTagNo()) {
                case ECCurve.COORD_AFFINE /*0*/:
                    this.crlids = CrlListID.getInstance(dERTaggedObject.getObject());
                    break;
                case ExtendedPKIXParameters.CHAIN_VALIDITY_MODEL /*1*/:
                    this.ocspids = OcspListID.getInstance(dERTaggedObject.getObject());
                    break;
                case CipherSpiExt.DECRYPT_MODE /*2*/:
                    this.otherRev = OtherRevRefs.getInstance(dERTaggedObject.getObject());
                    break;
                default:
                    throw new IllegalArgumentException("illegal tag");
            }
        }
    }

    public CrlOcspRef(CrlListID crlListID, OcspListID ocspListID, OtherRevRefs otherRevRefs) {
        this.crlids = crlListID;
        this.ocspids = ocspListID;
        this.otherRev = otherRevRefs;
    }

    public static CrlOcspRef getInstance(Object obj) {
        return obj instanceof CrlOcspRef ? (CrlOcspRef) obj : obj != null ? new CrlOcspRef(ASN1Sequence.getInstance(obj)) : null;
    }

    public CrlListID getCrlids() {
        return this.crlids;
    }

    public OcspListID getOcspids() {
        return this.ocspids;
    }

    public OtherRevRefs getOtherRev() {
        return this.otherRev;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.crlids != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.crlids.toASN1Primitive()));
        }
        if (this.ocspids != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, this.ocspids.toASN1Primitive()));
        }
        if (this.otherRev != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, this.otherRev.toASN1Primitive()));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
