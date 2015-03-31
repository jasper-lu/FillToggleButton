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
    private int checkedFill;
    private int checkedBorder;
    private int uncheckedFill;
    private int uncheckedBorder;
    private int pressedFill;
    private int pressedBorder;
    private int onTextColor;
    private int offTextColor;

    private ToggleSelector backgroundSelector;
    private ToggleTextColor textColor;

    ShapeDrawable checked, unchecked, pressed;

    public FillToggle(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FillToggle);

        setColors(a);

        String shape = a.getString(R.styleable.FillToggle_shape);
        if (shape != null && shape.equals("rectangle"))
        {
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
        int defaultPureWhite = getResources().getColor(R.color.white);
        int defaultWhite = getResources().getColor(R.color.smokyWhite);

        int defaultGrey = getResources().getColor(R.color.grey);
        int defaultDarkGrey = getResources().getColor(R.color.darkGrey);

        uncheckedFill = a.getColor(R.styleable.FillToggle_unchecked_fill, defaultWhite);
        uncheckedBorder = a.getColor(R.styleable.FillToggle_unchecked_border, defaultGrey);
        checkedFill = a.getColor(R.styleable.FillToggle_checked_fill, defaultRed);
        checkedBorder = a.getColor(R.styleable.FillToggle_checked_border, checkedFill);
        pressedFill = a.getColor(R.styleable.FillToggle_pressed_fill, defaultGrey);
        pressedBorder = a.getColor(R.styleable.FillToggle_pressed_border, defaultDarkGrey);

        onTextColor = a.getColor(R.styleable.FillToggle_on_text_color, defaultPureWhite);
        offTextColor = a.getColor(R.styleable.FillToggle_off_text_color, defaultDarkGrey);
    }

    public FillToggle(Context context) {
        this(context, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    /** getters and setters... bleh **/

    public int getCheckedFill() {
        return checkedFill;
    }

    public void setCheckedFill(int checkedFill) {
        this.checkedFill = checkedFill;
        checked.setFillColor(checkedFill);
    }

    public int getCheckedBorder() {
        return checkedBorder;
    }

    public void setCheckedBorder(int checkedBorder) {
        this.checkedBorder = checkedBorder;
        checked.setBorderColor(checkedBorder);
    }

    public int getUncheckedFill() {
        return uncheckedFill;
    }

    public void setUncheckedFill(int uncheckedFill) {
        this.uncheckedFill = uncheckedFill;
        unchecked.setFillColor(uncheckedFill);
    }

    public int getUncheckedBorder() {
        return uncheckedBorder;
    }

    public void setUncheckedBorder(int uncheckedBorder) {
        this.uncheckedBorder = uncheckedBorder;
        unchecked.setBorderColor(uncheckedBorder);
    }

    public int getPressedFill() {
        return pressedFill;
    }

    public void setPressedFill(int pressedFill) {
        this.pressedFill = pressedFill;
        pressed.setFillColor(pressedFill);
    }

    public int getPressedBorder() {
        return pressedBorder;
    }

    public void setPressedBorder(int pressedBorder) {
        this.pressedBorder = pressedBorder;
        pressed.setBorderColor(pressedBorder);
    }

    public int getOffTextColor() {
        return offTextColor;
    }

    public void setOffTextColor(int offTextColor) {
        this.offTextColor = offTextColor;
        textColor = new ToggleTextColor(onTextColor, offTextColor);
    }

    public int getOnTextColor() {
        return onTextColor;
    }

    public void setOnTextColor(int onTextColor) {
        this.onTextColor = onTextColor;
        textColor = new ToggleTextColor(onTextColor, offTextColor);
    }
}
