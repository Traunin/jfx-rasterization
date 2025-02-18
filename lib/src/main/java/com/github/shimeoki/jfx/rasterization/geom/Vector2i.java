package com.github.shimeoki.jfx.rasterization.geom;

public final class Vector2i implements Point2i {

    private int x;
    private int y;

    public Vector2i(final int x, final int y) {
        setX(x);
        setY(y);
    }

    @Override
    public int x() {
        return x;
    }

    @Override
    public void setX(final int x) {
        this.x = x;
    }

    @Override
    public void addX(final int dx) {
        setX(x + dx);
    }

    @Override
    public int y() {
        return y;
    }

    @Override
    public void setY(final int y) {
        this.y = y;
    }

    @Override
    public void addY(final int dy) {
        setY(y + dy);
    }
}
