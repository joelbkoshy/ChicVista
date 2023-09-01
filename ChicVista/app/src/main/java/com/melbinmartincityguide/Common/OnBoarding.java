package com.melbinmartincityguide.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.text.Html;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import com.melbinmartincityguide.HelperClasses.SliderAdapter;
import com.melbinmartincityguide.R;
import android.view.View;
import android.content.Intent;
import com.melbinmartincityguide.User.UserDashboard;
public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    TextView[] dots;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    Button letsGetStarted;
    Animation animation;
    int currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);
//hoos
        viewPager = findViewById(R.id.slider);
        dotsLayout=findViewById(R.id.dots_layout);
        letsGetStarted=findViewById(R.id.get_started_btn);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        //add dots
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    public void skip(View view) {
        startActivity(new Intent(this, UserDashboard.class));
        finish();
    }

    public void next(View view) {
        viewPager.setCurrentItem(currentPos + 1);
    }
    private void addDots(int position) {

        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }

    }


    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPos=position;


            if (position == 0) {
                letsGetStarted.setVisibility(View.INVISIBLE);
            } else if (position == 1) {
                letsGetStarted.setVisibility(View.INVISIBLE);
            } else if (position == 2) {
                letsGetStarted.setVisibility(View.INVISIBLE);
            } else {
                animation = AnimationUtils.loadAnimation(OnBoarding.this, R.anim.bottom_anim);
                letsGetStarted.setAnimation(animation);
                letsGetStarted.setVisibility(View.VISIBLE);
            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    }

