package com.jasperlu.filltoggle;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/**
 * Created by Jasper on 3/31/2015.
 */
public class CircleDrawable extends ShapeDrawable {
    public CircleDrawable(int fillColor) {
        super(CIRCLE, fillColor);
    }

    public CircleDrawable(int fillColor, int borderColor) {
        super(CIRCLE, fillColor, borderColor);
    }

    @Override
    public void draw(Canvas canvas) {
        int cx = getBounds().width() / 2;
        int cy = getBounds().height() / 2;
        //base padding is 4
        int r = cx - 4;
        mPaint.setColor(fillColor);
        canvas.drawCircle(cx, cy, r, mPaint);

        mPaint.setAntiAlias(true);
        mPaint.setColor(borderColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        canvas.drawCircle(cx, cy, r, mPaint);

        mPaint.reset();
    }
}
