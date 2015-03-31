package com.jasperlu.filltoggle;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/**
 * Created by Jasper on 3/31/2015.
 */
public class ToggleSelector extends StateListDrawable {
    public ToggleSelector(Drawable checked, Drawable unchecked, Drawable pressed) {
        addState(new int[]{android.R.attr.state_checked, -android.R.attr.state_pressed}, checked);
        addState(new int[]{-android.R.attr.state_checked, -android.R.attr.state_pressed}, unchecked);
        addState(new int[]{android.R.attr.state_checked, android.R.attr.state_pressed}, pressed);
        addState(new int[]{-android.R.attr.state_checked, android.R.attr.state_pressed}, pressed);
    }
    public ToggleSelector(Drawable checked, Drawable unchecked) {
        addState(new int[]{android.R.attr.state_checked}, checked);
        addState(new int[]{}, unchecked);
    }
    public ToggleSelector(Drawable normal) {
        addState(new int[]{}, normal);
    }
}
