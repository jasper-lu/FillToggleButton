package com.jasperlu.filltoggle;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Jasper on 3/31/2015.
 */
public class RectDrawable extends ShapeDrawable{

    public RectDrawable(int fillColor) {
        super(RECT, fillColor);
    }

    public RectDrawable(int fillColor, int borderColor) {
        super(CIRCLE, fillColor, borderColor);
    }

    @Override
    public void draw(Canvas canvas) {
        int cx = getBounds().width() / 2;
        int cy = getBounds().height() / 2;
        //base padding is 4
        int r = cx - 4;
        mPaint.setColor(fillColor);
        canvas.drawRect(cx - r, cy - r, cx + r, cy + r, mPaint);

        mPaint.setAntiAlias(true);
        mPaint.setColor(borderColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        canvas.drawRect(cx - r, cy - r, cx + r, cy + r, mPaint);

        mPaint.reset();
    }
}
