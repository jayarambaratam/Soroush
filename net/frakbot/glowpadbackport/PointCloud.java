package net.frakbot.glowpadbackport;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.ArrayList;

public class PointCloud {
    private static int INNER_POINTS = 0;
    private static final float MAX_POINT_SIZE = 4.0f;
    private static final float MIN_POINT_SIZE = 2.0f;
    private static final float PI = 3.1415927f;
    private static final String TAG = "PointCloud";
    GlowManager glowManager;
    private float mCenterX;
    private float mCenterY;
    private Drawable mDrawable;
    private float mInnerRadius;
    private float mOuterRadius;
    private Paint mPaint;
    private ArrayList<Point> mPointCloud;
    private float mScale;
    WaveManager waveManager;

    public class GlowManager {
        private float alpha;
        private float radius;
        private float f8349x;
        private float f8350y;

        public GlowManager() {
            this.radius = 0.0f;
            this.alpha = 0.0f;
        }

        public float getAlpha() {
            return this.alpha;
        }

        public float getRadius() {
            return this.radius;
        }

        public float getX() {
            return this.f8349x;
        }

        public float getY() {
            return this.f8350y;
        }

        public void setAlpha(float f) {
            this.alpha = f;
        }

        public void setRadius(float f) {
            this.radius = f;
        }

        public void setX(float f) {
            this.f8349x = f;
        }

        public void setY(float f) {
            this.f8350y = f;
        }
    }

    class Point {
        float radius;
        float f8351x;
        float f8352y;

        public Point(float f, float f2, float f3) {
            this.f8351x = f;
            this.f8352y = f2;
            this.radius = f3;
        }
    }

    public class WaveManager {
        private float alpha;
        private float radius;
        private float width;

        public WaveManager() {
            this.radius = 50.0f;
            this.width = 200.0f;
            this.alpha = 0.0f;
        }

        public float getAlpha() {
            return this.alpha;
        }

        public float getRadius() {
            return this.radius;
        }

        public void setAlpha(float f) {
            this.alpha = f;
        }

        public void setRadius(float f) {
            this.radius = f;
        }
    }

    static {
        INNER_POINTS = 8;
    }

    public PointCloud(Drawable drawable) {
        this.mPointCloud = new ArrayList();
        this.mScale = 1.0f;
        this.waveManager = new WaveManager();
        this.glowManager = new GlowManager();
        this.mPaint = new Paint();
        this.mPaint.setFilterBitmap(true);
        this.mPaint.setColor(Color.rgb(255, 255, 255));
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mDrawable = drawable;
        if (this.mDrawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    private static float hypot(float f, float f2) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }

    private float interp(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    private static float max(float f, float f2) {
        return f > f2 ? f : f2;
    }

    public void draw(Canvas canvas) {
        ArrayList arrayList = this.mPointCloud;
        canvas.save(1);
        canvas.scale(this.mScale, this.mScale, this.mCenterX, this.mCenterY);
        for (int i = 0; i < arrayList.size(); i++) {
            Point point = (Point) arrayList.get(i);
            float interp = interp(MAX_POINT_SIZE, MIN_POINT_SIZE, point.radius / this.mOuterRadius);
            float f = point.f8351x + this.mCenterX;
            float f2 = point.f8352y + this.mCenterY;
            int alphaForPoint = getAlphaForPoint(point);
            if (alphaForPoint != 0) {
                if (this.mDrawable != null) {
                    canvas.save(1);
                    float intrinsicWidth = ((float) this.mDrawable.getIntrinsicWidth()) * 0.5f;
                    float intrinsicHeight = ((float) this.mDrawable.getIntrinsicHeight()) * 0.5f;
                    interp /= MAX_POINT_SIZE;
                    canvas.scale(interp, interp, f, f2);
                    canvas.translate(f - intrinsicWidth, f2 - intrinsicHeight);
                    this.mDrawable.setAlpha(alphaForPoint);
                    this.mDrawable.draw(canvas);
                    canvas.restore();
                } else {
                    this.mPaint.setAlpha(alphaForPoint);
                    canvas.drawCircle(f, f2, interp, this.mPaint);
                }
            }
        }
        canvas.restore();
    }

    public int getAlphaForPoint(Point point) {
        float f = 0.0f;
        float hypot = hypot(this.glowManager.f8349x - point.f8351x, this.glowManager.f8350y - point.f8352y);
        if (hypot < this.glowManager.radius) {
            hypot = (float) Math.cos((double) ((hypot * 0.7853982f) / this.glowManager.radius));
            hypot = max(0.0f, (float) Math.pow((double) hypot, 10.0d)) * this.glowManager.alpha;
        } else {
            hypot = 0.0f;
        }
        float hypot2 = hypot(point.f8351x, point.f8352y) - this.waveManager.radius;
        if (hypot2 < this.waveManager.width * 0.5f && hypot2 < 0.0f) {
            hypot2 = (float) Math.cos((double) ((hypot2 * 0.7853982f) / this.waveManager.width));
            f = max(0.0f, (float) Math.pow((double) hypot2, 20.0d)) * this.waveManager.alpha;
        }
        return (int) (max(hypot, f) * 255.0f);
    }

    int getPointsMultiplier() {
        return INNER_POINTS;
    }

    public float getScale() {
        return this.mScale;
    }

    public void makePointCloud(float f, float f2) {
        if (f == 0.0f) {
            Log.w(TAG, "Must specify an inner radius");
            return;
        }
        this.mOuterRadius = f2;
        this.mInnerRadius = f;
        this.mPointCloud.clear();
        float f3 = f2 - f;
        float f4 = (6.2831855f * f) / ((float) INNER_POINTS);
        int round = Math.round(f3 / f4);
        float f5 = f3 / ((float) round);
        for (int i = 0; i <= round; i++) {
            int i2 = (int) ((6.2831855f * f) / f4);
            float f6 = 1.5707964f;
            float f7 = 6.2831855f / ((float) i2);
            for (int i3 = 0; i3 < i2; i3++) {
                float cos = (float) (((double) f) * Math.cos((double) f6));
                float sin = (float) (((double) f) * Math.sin((double) f6));
                f6 += f7;
                this.mPointCloud.add(new Point(cos, sin, f));
            }
            f += f5;
        }
    }

    public void setCenter(float f, float f2) {
        this.mCenterX = f;
        this.mCenterY = f2;
    }

    void setPointsMultiplier(int i) {
        INNER_POINTS = i;
        makePointCloud(this.mInnerRadius, this.mOuterRadius);
    }

    public void setScale(float f) {
        this.mScale = f;
    }
}
