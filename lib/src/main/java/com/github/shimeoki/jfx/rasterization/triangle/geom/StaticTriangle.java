package com.github.shimeoki.jfx.rasterization.triangle.geom;

import java.util.Objects;

import com.github.shimeoki.jfx.rasterization.geom.Pos2f;
import com.github.shimeoki.jfx.rasterization.geom.Vector2f;
import com.github.shimeoki.jfx.rasterization.geom.Point2f;
import com.github.shimeoki.jfx.rasterization.math.Floats;

public final class StaticTriangle implements Triangle {

    private final float x1;
    private final float y1;

    private final float x2;
    private final float y2;

    private final float x3;
    private final float y3;

    private final float dx13;
    private final float dy13;

    private final float dx23;
    private final float dy23;

    private final float d;

    public StaticTriangle(
            final Pos2f p1,
            final Pos2f p2,
            final Pos2f p3) {

        Objects.requireNonNull(p1);
        Objects.requireNonNull(p2);
        Objects.requireNonNull(p3);

        x1 = p1.x();
        y1 = p1.y();

        x2 = p2.x();
        y2 = p2.y();

        x3 = p3.x();
        y3 = p3.y();

        dx13 = x1 - x3;
        dy13 = y1 - y3;

        dx23 = x2 - x3;
        dy23 = y2 - y3;

        final float denominator = dy23 * dx13 - dx23 * dy13;
        if (Floats.equals(denominator, 0)) {
            d = 0;
        } else {
            d = 1 / denominator;
        }
    }

    @Override
    public Point2f v1() {
        return new Vector2f(x1, y1);
    }

    @Override
    public Point2f v2() {
        return new Vector2f(x2, y2);
    }

    @Override
    public Point2f v3() {
        return new Vector2f(x3, y3);
    }

    @Override
    public TriangleBarycentrics barycentrics(final Pos2f p) {
        // docs:
        // https://en.wikipedia.org/wiki/Barycentric_coordinate_system#Conversion_between_barycentric_and_Cartesian_coordinates

        if (d == 0) {
            return new NormalizedTriangleBarycentrics(1, 0, 0);
        }

        final float x = p.x();
        final float y = p.y();

        final float dx3 = x - x3;
        final float dy3 = y - y3;

        final float numerator1 = dy23 * dx3 - dx23 * dy3;
        final float numerator2 = -dy13 * dx3 + dx13 * dy3;
        final float numerator3 = (y1 - y2) * (x - x1) + (x2 - x1) * (y - y1);

        final float lambda1 = numerator1 * d;
        final float lambda2 = numerator2 * d;
        final float lambda3 = numerator3 * d;

        return new NormalizedTriangleBarycentrics(lambda1, lambda2, lambda3);
    }
}
