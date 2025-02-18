package com.github.shimeoki.jfx.rasterization.math;

public final class Floats {

    public static final float EPSILON = 1E-5f;

    private Floats() {
    }

    public static boolean equals(final float v1, final float v2) {
        return Math.abs(v1 - v2) < EPSILON;
    }

    public static boolean moreThan(final float left, final float right) {
        return (left - right) > -EPSILON;
    }

    public static boolean lessThan(final float left, final float right) {
        return moreThan(right, left);
    }

    public static int compare(final float left, final float right) {
        if (equals(left, right)) {
            return 0;
        }

        if (left > right) {
            return 1;
        } else {
            return -1;
        }
    }

    public static float confined(
            final float low, final float x, final float high) {

        return Math.min(Math.max(low, x), high);
    }

    public static float min3(final float v1, final float v2, final float v3) {
        return Math.min(v1, Math.min(v2, v3));
    }

    public static float max3(final float v1, final float v2, final float v3) {
        return Math.max(v1, Math.max(v2, v3));
    }
}
