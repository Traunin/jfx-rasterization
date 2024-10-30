package com.github.shimeoki.jfx.rasterization;

import javafx.scene.paint.Color;

public interface Colorf {

    // rgb

    public float red();

    public float green();

    public float blue();

    // alpha / opacity

    public float alpha();

    public float opacity();

    // conversion

    public Color jfxColor();
}
