package com.jasperlu.filltoggle;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ToggleButton;

/**
 * Created by Jasper on 3/31/2015.
 */
public class FillToggle extends ToggleButton {
    private int checkedFill, checkedBorder, uncheckedFill, uncheckedBorder, pressedFill, pressedBorder, onTextColor, offTextColor;
    private ToggleSelector backgroundSelector;
    private ToggleTextColor textColor;

    public FillToggle(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FillToggle);

        setColors(a);

        ShapeDrawable checked, unchecked, pressed;
        if (a.getString(R.styleable.FillToggle_shape) == "square") {
            checked = new RectDrawable (checkedFill, checkedBorder);
            unchecked = new RectDrawable (uncheckedFill, uncheckedBorder);
            pressed = new RectDrawable (pressedFill, pressedBorder);
        } else {
            checked = new CircleDrawable(checkedFill, checkedBorder);
            unchecked = new CircleDrawable(uncheckedFill, uncheckedBorder);
            pressed = new CircleDrawable(pressedFill, pressedBorder);
        }
        backgroundSelector = new ToggleSelector(checked, unchecked, pressed);

        setBackgroundDrawable(backgroundSelector);
        textColor = new ToggleTextColor(onTextColor, offTextColor);
        setTextColor(textColor);
    }

    private void setColors(TypedArray a) {
        int defaultRed = getResources().getColor(R.color.myRed);
        int defaultWhite = getResources().getColor(R.color.smokyWhite);
        int defaultGrey = getResources().getColor(R.color.grey);
        int defaultDarkGrey = getResources().getColor(R.color.darkGrey);

        uncheckedFill = a.getColor(R.styleable.FillToggle_unchecked_fill, defaultWhite);
        uncheckedBorder = a.getColor(R.styleable.FillToggle_unchecked_border, defaultGrey);
        checkedFill = a.getColor(R.styleable.FillToggle_checked_fill, defaultRed);
        checkedBorder = a.getColor(R.styleable.FillToggle_checked_border, checkedFill);
        pressedFill = a.getColor(R.styleable.FillToggle_pressed_fill, defaultGrey);
        pressedBorder = a.getColor(R.styleable.FillToggle_pressed_border, defaultDarkGrey);

        onTextColor = a.getColor(R.styleable.FillToggle_on_text_color, defaultWhite);
        offTextColor = a.getColor(R.styleable.FillToggle_off_text_color, defaultDarkGrey);
    }

    public FillToggle(Context context) {
        this(context, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
