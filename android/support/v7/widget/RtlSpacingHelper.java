package android.support.v7.widget;

class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mEnd;
    private int mExplicitLeft;
    private int mExplicitRight;
    private boolean mIsRelative;
    private boolean mIsRtl;
    private int mLeft;
    private int mRight;
    private int mStart;

    RtlSpacingHelper() {
        this.mLeft = 0;
        this.mRight = 0;
        this.mStart = UNDEFINED;
        this.mEnd = UNDEFINED;
        this.mExplicitLeft = 0;
        this.mExplicitRight = 0;
        this.mIsRtl = false;
        this.mIsRelative = false;
    }

    public int getEnd() {
        return this.mIsRtl ? this.mLeft : this.mRight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        return this.mIsRtl ? this.mRight : this.mLeft;
    }

    public void setAbsolute(int i, int i2) {
        this.mIsRelative = false;
        if (i != UNDEFINED) {
            this.mExplicitLeft = i;
            this.mLeft = i;
        }
        if (i2 != UNDEFINED) {
            this.mExplicitRight = i2;
            this.mRight = i2;
        }
    }

    public void setDirection(boolean z) {
        if (z != this.mIsRtl) {
            this.mIsRtl = z;
            if (!this.mIsRelative) {
                this.mLeft = this.mExplicitLeft;
                this.mRight = this.mExplicitRight;
            } else if (z) {
                this.mLeft = this.mEnd != UNDEFINED ? this.mEnd : this.mExplicitLeft;
                this.mRight = this.mStart != UNDEFINED ? this.mStart : this.mExplicitRight;
            } else {
                this.mLeft = this.mStart != UNDEFINED ? this.mStart : this.mExplicitLeft;
                this.mRight = this.mEnd != UNDEFINED ? this.mEnd : this.mExplicitRight;
            }
        }
    }

    public void setRelative(int i, int i2) {
        this.mStart = i;
        this.mEnd = i2;
        this.mIsRelative = true;
        if (this.mIsRtl) {
            if (i2 != UNDEFINED) {
                this.mLeft = i2;
            }
            if (i != UNDEFINED) {
                this.mRight = i;
                return;
            }
            return;
        }
        if (i != UNDEFINED) {
            this.mLeft = i;
        }
        if (i2 != UNDEFINED) {
            this.mRight = i2;
        }
    }
}
