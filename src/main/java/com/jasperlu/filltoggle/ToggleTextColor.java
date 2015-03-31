package com.jasperlu.filltoggle;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;

/**
 * Created by Jasper on 3/31/2015.
 */
public class ToggleTextColor extends ColorStateList {
    public ToggleTextColor(int onColor, int offColor) {
        super(new int[][]{
            new int[]{android.R.attr.state_checked}, //1
            new int[]{-android.R.attr.state_checked}, //2
        }, new int[] {
            onColor, offColor
        });
    }

    public ToggleTextColor(int color) {
        super(new int[][]{}, new int[]{color});
    }
}
