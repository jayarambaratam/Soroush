package net.frakbot.glowpadbackport;

import net.frakbot.glowpadbackport.util.TimeInterpolator;

class Ease {
    private static final float DOMAIN = 1.0f;
    private static final float DURATION = 1.0f;
    private static final float START = 0.0f;

    class Cubic {
        public static final TimeInterpolator easeIn;
        public static final TimeInterpolator easeInOut;
        public static final TimeInterpolator easeOut;

        /* renamed from: net.frakbot.glowpadbackport.Ease.Cubic.1 */
        final class C26111 implements TimeInterpolator {
            C26111() {
            }

            public float getInterpolation(float f) {
                float f2 = f / Ease.DURATION;
                return (f2 * ((Ease.DURATION * f2) * f2)) + 0.0f;
            }
        }

        /* renamed from: net.frakbot.glowpadbackport.Ease.Cubic.2 */
        final class C26122 implements TimeInterpolator {
            C26122() {
            }

            public float getInterpolation(float f) {
                float f2 = (f / Ease.DURATION) - Ease.DURATION;
                return (((f2 * (f2 * f2)) + Ease.DURATION) * Ease.DURATION) + 0.0f;
            }
        }

        /* renamed from: net.frakbot.glowpadbackport.Ease.Cubic.3 */
        final class C26133 implements TimeInterpolator {
            C26133() {
            }

            public float getInterpolation(float f) {
                float f2 = f / 0.5f;
                if (f2 < Ease.DURATION) {
                    return (f2 * ((0.5f * f2) * f2)) + 0.0f;
                }
                f2 -= 2.0f;
                return (((f2 * (f2 * f2)) + 2.0f) * 0.5f) + 0.0f;
            }
        }

        static {
            easeIn = new C26111();
            easeOut = new C26122();
            easeInOut = new C26133();
        }

        Cubic() {
        }
    }

    class Linear {
        public static final TimeInterpolator easeNone;

        /* renamed from: net.frakbot.glowpadbackport.Ease.Linear.1 */
        final class C26141 implements TimeInterpolator {
            C26141() {
            }

            public float getInterpolation(float f) {
                return f;
            }
        }

        static {
            easeNone = new C26141();
        }

        Linear() {
        }
    }

    class Quad {
        public static final TimeInterpolator easeIn;
        public static final TimeInterpolator easeInOut;
        public static final TimeInterpolator easeOut;

        /* renamed from: net.frakbot.glowpadbackport.Ease.Quad.1 */
        final class C26151 implements TimeInterpolator {
            C26151() {
            }

            public float getInterpolation(float f) {
                float f2 = f / Ease.DURATION;
                return (f2 * (Ease.DURATION * f2)) + 0.0f;
            }
        }

        /* renamed from: net.frakbot.glowpadbackport.Ease.Quad.2 */
        final class C26162 implements TimeInterpolator {
            C26162() {
            }

            public float getInterpolation(float f) {
                float f2 = f / Ease.DURATION;
                return ((-1.0f * f2) * (f2 - 2.0f)) + 0.0f;
            }
        }

        /* renamed from: net.frakbot.glowpadbackport.Ease.Quad.3 */
        final class C26173 implements TimeInterpolator {
            C26173() {
            }

            public float getInterpolation(float f) {
                float f2 = f / 0.5f;
                if (f2 < Ease.DURATION) {
                    return (f2 * (0.5f * f2)) + 0.0f;
                }
                f2 -= Ease.DURATION;
                return (((f2 * (f2 - 2.0f)) - Ease.DURATION) * -0.5f) + 0.0f;
            }
        }

        static {
            easeIn = new C26151();
            easeOut = new C26162();
            easeInOut = new C26173();
        }

        Quad() {
        }
    }

    class Quart {
        public static final TimeInterpolator easeIn;
        public static final TimeInterpolator easeInOut;
        public static final TimeInterpolator easeOut;

        /* renamed from: net.frakbot.glowpadbackport.Ease.Quart.1 */
        final class C26181 implements TimeInterpolator {
            C26181() {
            }

            public float getInterpolation(float f) {
                float f2 = f / Ease.DURATION;
                return (f2 * (((Ease.DURATION * f2) * f2) * f2)) + 0.0f;
            }
        }

        /* renamed from: net.frakbot.glowpadbackport.Ease.Quart.2 */
        final class C26192 implements TimeInterpolator {
            C26192() {
            }

            public float getInterpolation(float f) {
                float f2 = (f / Ease.DURATION) - Ease.DURATION;
                return (-1.0f * ((f2 * ((f2 * f2) * f2)) - Ease.DURATION)) + 0.0f;
            }
        }

        /* renamed from: net.frakbot.glowpadbackport.Ease.Quart.3 */
        final class C26203 implements TimeInterpolator {
            C26203() {
            }

            public float getInterpolation(float f) {
                float f2 = f / 0.5f;
                if (f2 < Ease.DURATION) {
                    return (f2 * (((0.5f * f2) * f2) * f2)) + 0.0f;
                }
                f2 -= 2.0f;
                return (((f2 * ((f2 * f2) * f2)) - 2.0f) * -0.5f) + 0.0f;
            }
        }

        static {
            easeIn = new C26181();
            easeOut = new C26192();
            easeInOut = new C26203();
        }

        Quart() {
        }
    }

    class Quint {
        public static final TimeInterpolator easeIn;
        public static final TimeInterpolator easeInOut;
        public static final TimeInterpolator easeOut;

        /* renamed from: net.frakbot.glowpadbackport.Ease.Quint.1 */
        final class C26211 implements TimeInterpolator {
            C26211() {
            }

            public float getInterpolation(float f) {
                float f2 = f / Ease.DURATION;
                return (f2 * ((((Ease.DURATION * f2) * f2) * f2) * f2)) + 0.0f;
            }
        }

        /* renamed from: net.frakbot.glowpadbackport.Ease.Quint.2 */
        final class C26222 implements TimeInterpolator {
            C26222() {
            }

            public float getInterpolation(float f) {
                float f2 = (f / Ease.DURATION) - Ease.DURATION;
                return (((f2 * (((f2 * f2) * f2) * f2)) + Ease.DURATION) * Ease.DURATION) + 0.0f;
            }
        }

        /* renamed from: net.frakbot.glowpadbackport.Ease.Quint.3 */
        final class C26233 implements TimeInterpolator {
            C26233() {
            }

            public float getInterpolation(float f) {
                float f2 = f / 0.5f;
                if (f2 < Ease.DURATION) {
                    return (f2 * ((((0.5f * f2) * f2) * f2) * f2)) + 0.0f;
                }
                f2 -= 2.0f;
                return (((f2 * (((f2 * f2) * f2) * f2)) + 2.0f) * 0.5f) + 0.0f;
            }
        }

        static {
            easeIn = new C26211();
            easeOut = new C26222();
            easeInOut = new C26233();
        }

        Quint() {
        }
    }

    class Sine {
        public static final TimeInterpolator easeIn;
        public static final TimeInterpolator easeInOut;
        public static final TimeInterpolator easeOut;

        /* renamed from: net.frakbot.glowpadbackport.Ease.Sine.1 */
        final class C26241 implements TimeInterpolator {
            C26241() {
            }

            public float getInterpolation(float f) {
                return ((-1.0f * ((float) Math.cos(((double) (f / Ease.DURATION)) * 1.5707963267948966d))) + Ease.DURATION) + 0.0f;
            }
        }

        /* renamed from: net.frakbot.glowpadbackport.Ease.Sine.2 */
        final class C26252 implements TimeInterpolator {
            C26252() {
            }

            public float getInterpolation(float f) {
                return (((float) Math.sin(((double) (f / Ease.DURATION)) * 1.5707963267948966d)) * Ease.DURATION) + 0.0f;
            }
        }

        /* renamed from: net.frakbot.glowpadbackport.Ease.Sine.3 */
        final class C26263 implements TimeInterpolator {
            C26263() {
            }

            public float getInterpolation(float f) {
                return (-0.5f * (((float) Math.cos((3.141592653589793d * ((double) f)) / 1.0d)) - Ease.DURATION)) + 0.0f;
            }
        }

        static {
            easeIn = new C26241();
            easeOut = new C26252();
            easeInOut = new C26263();
        }

        Sine() {
        }
    }

    Ease() {
    }
}
