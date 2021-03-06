package org.bouncycastle.jcajce.provider.symmetric.util;

import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class BCPBEKey implements PBEKey {
    String algorithm;
    int digest;
    int ivSize;
    int keySize;
    ASN1ObjectIdentifier oid;
    CipherParameters param;
    PBEKeySpec pbeKeySpec;
    boolean tryWrong;
    int type;

    public BCPBEKey(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, int i2, int i3, int i4, PBEKeySpec pBEKeySpec, CipherParameters cipherParameters) {
        this.tryWrong = false;
        this.algorithm = str;
        this.oid = aSN1ObjectIdentifier;
        this.type = i;
        this.digest = i2;
        this.keySize = i3;
        this.ivSize = i4;
        this.pbeKeySpec = pBEKeySpec;
        this.param = cipherParameters;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    int getDigest() {
        return this.digest;
    }

    public byte[] getEncoded() {
        if (this.param == null) {
            return this.type == 2 ? PBEParametersGenerator.PKCS12PasswordToBytes(this.pbeKeySpec.getPassword()) : this.type == 5 ? PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(this.pbeKeySpec.getPassword()) : PBEParametersGenerator.PKCS5PasswordToBytes(this.pbeKeySpec.getPassword());
        } else {
            return (this.param instanceof ParametersWithIV ? (KeyParameter) ((ParametersWithIV) this.param).getParameters() : (KeyParameter) this.param).getKey();
        }
    }

    public String getFormat() {
        return "RAW";
    }

    public int getIterationCount() {
        return this.pbeKeySpec.getIterationCount();
    }

    public int getIvSize() {
        return this.ivSize;
    }

    int getKeySize() {
        return this.keySize;
    }

    public ASN1ObjectIdentifier getOID() {
        return this.oid;
    }

    public CipherParameters getParam() {
        return this.param;
    }

    public char[] getPassword() {
        return this.pbeKeySpec.getPassword();
    }

    public byte[] getSalt() {
        return this.pbeKeySpec.getSalt();
    }

    int getType() {
        return this.type;
    }

    public void setTryWrongPKCS12Zero(boolean z) {
        this.tryWrong = z;
    }

    boolean shouldTryWrongPKCS12() {
        return this.tryWrong;
    }
}
