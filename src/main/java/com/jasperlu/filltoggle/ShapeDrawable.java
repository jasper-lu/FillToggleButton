package com.jasperlu.filltoggle;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/**
 * Created by Jasper on 3/31/2015.
 */
public abstract class ShapeDrawable extends Drawable{
    public static final int RECT = 0;
    public static final int CIRCLE = 0;

    protected Paint mPaint;
    protected int fillColor;
    protected int borderColor;

    protected int mShape;

    public ShapeDrawable(int shape, int fillColor) {
        mPaint = new Paint();
        mShape = shape;
        this.fillColor = fillColor;
        this.borderColor = fillColor;
    }

    public ShapeDrawable(int shape, int fillColor, int borderColor) {
        mPaint = new Paint();
        mShape = shape;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }


    public void setBorderColor(int color) {
        borderColor = color;
        invalidateSelf();
    }

    public void setFillColor(int color) {
        fillColor = color;
        invalidateSelf();
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter cf) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
