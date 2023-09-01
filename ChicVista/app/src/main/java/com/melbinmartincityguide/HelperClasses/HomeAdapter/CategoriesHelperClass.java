package com.melbinmartincityguide.HelperClasses.HomeAdapter;

import android.graphics.drawable.GradientDrawable;

public class CategoriesHelperClass {
    private GradientDrawable gradient;
    private int image;
    private String title;

    public CategoriesHelperClass(GradientDrawable gradient,int image, String title) {
        this.image = image;
        this.title = title;
        this.gradient=gradient;
    }

    public GradientDrawable getGradient() {
        return gradient;
    }

    public int getImage() {
        return image;
    }

    public String gettitle() {
        return title;
    }
}
