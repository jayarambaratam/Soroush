package org.linphone.core;

public final class VideoSize {
    public static final int CIF = 1;
    public static final int HVGA = 2;
    public static final int QCIF = 0;
    public static final int QVGA = 3;
    public int height;
    public int width;

    public VideoSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public static final VideoSize createStandard(int i, boolean z) {
        switch (i) {
            case QCIF /*0*/:
                return z ? new VideoSize(144, 176) : new VideoSize(176, 144);
            case CIF /*1*/:
                return z ? new VideoSize(288, 352) : new VideoSize(352, 288);
            case HVGA /*2*/:
                return z ? new VideoSize(320, 480) : new VideoSize(480, 320);
            case QVGA /*3*/:
                return z ? new VideoSize(240, 320) : new VideoSize(320, 240);
            default:
                return new VideoSize();
        }
    }

    public VideoSize createInverted() {
        return new VideoSize(this.height, this.width);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        VideoSize videoSize = (VideoSize) obj;
        return this.height != videoSize.height ? false : this.width == videoSize.width;
    }

    public int hashCode() {
        return ((this.height + 31) * 31) + this.width;
    }

    public boolean isPortrait() {
        return this.height >= this.width;
    }

    public boolean isValid() {
        return this.width > 0 && this.height > 0;
    }

    public String toString() {
        return "width = " + this.width + " height = " + this.height;
    }
}
