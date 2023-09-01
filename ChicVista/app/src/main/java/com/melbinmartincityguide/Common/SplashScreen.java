package com.melbinmartincityguide.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.melbinmartincityguide.R;
import com.melbinmartincityguide.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {
 private static int SPLASH_TIMER =3000;
    ImageView backgroundImage;
    TextView poweredByLine;
    Animation sideAnim,bottomAnim;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
        poweredByLine=findViewById(R.id.powered_by_line);
        backgroundImage=findViewById(R.id.backgound_image);

//animate top
        sideAnim= AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        backgroundImage.setAnimation(sideAnim);
        poweredByLine.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingScreen=getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFisrtTime=onBoardingScreen.getBoolean("firsttime",true);
                if(isFisrtTime)
                {
                    SharedPreferences.Editor editor=onBoardingScreen.edit();
                    editor.putBoolean("firsttime",false);
                    editor.commit();

                    Intent intent=new Intent(getApplicationContext(), OnBoarding.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Intent intent=new Intent(getApplicationContext(), UserDashboard.class);
                    startActivity(intent);
                    finish();
                }

            }
        },SPLASH_TIMER);

    }
}