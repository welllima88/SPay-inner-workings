package org.bouncycastle.util.encoders;

public class BufferedEncoder {
    protected byte[] buf;
    protected int bufOff;
    protected Translator translator;

    public BufferedEncoder(Translator translator, int i) {
        this.translator = translator;
        if (i % translator.getEncodedBlockSize() != 0) {
            throw new IllegalArgumentException("buffer size not multiple of input block size");
        }
        this.buf = new byte[i];
        this.bufOff = 0;
    }

    public int processByte(byte b, byte[] bArr, int i) {
        byte[] bArr2 = this.buf;
        int i2 = this.bufOff;
        this.bufOff = i2 + 1;
        bArr2[i2] = b;
        if (this.bufOff != this.buf.length) {
            return 0;
        }
        int encode = this.translator.encode(this.buf, 0, this.buf.length, bArr, i);
        this.bufOff = 0;
        return encode;
    }

    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = 0;
        if (i2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int length = this.buf.length - this.bufOff;
        if (i2 > length) {
            System.arraycopy(bArr, i, this.buf, this.bufOff, length);
            int encode = 0 + this.translator.encode(this.buf, 0, this.buf.length, bArr2, i3);
            this.bufOff = 0;
            int i5 = i2 - length;
            i4 = i + length;
            int length2 = i5 - (i5 % this.buf.length);
            i2 = i5 - length2;
            i = i4 + length2;
            i4 = this.translator.encode(bArr, i4, length2, bArr2, i3 + encode) + encode;
        }
        if (i2 != 0) {
            System.arraycopy(bArr, i, this.buf, this.bufOff, i2);
            this.bufOff += i2;
        }
        return i4;
    }
}
