package com.melbinmartincityguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.melbinmartincityguide.Common.LoginSignup.RetailerStartUpScreen;
import com.melbinmartincityguide.HelperClasses.HomeAdapter.CategoriesAdapter;
import com.melbinmartincityguide.HelperClasses.HomeAdapter.CategoriesHelperClass;
import com.melbinmartincityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.melbinmartincityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.melbinmartincityguide.HelperClasses.HomeAdapter.MostViewedAdpater;
import com.melbinmartincityguide.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.melbinmartincityguide.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{
   static final float   END_SCALE=0.7f;
    RecyclerView featuredRecycler,mostViewedRecycler,categoriesRecycler;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    RecyclerView.Adapter adapter;


    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    LinearLayout contentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //hooks

        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.mostViewedRecyclerView);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        menuIcon=findViewById(R.id.menu_icon);
        contentView=findViewById(R.id.content_view);


        //menu

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);




        naviagtionDrawer();


        //call

        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();
    }
//Navigation drawer
    private void naviagtionDrawer() {

//Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);


        menuIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);
                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            if (item.getItemId() == R.id.all_categories) {
                Intent intent = new Intent(getApplicationContext(), AllCategories.class);
                startActivity(intent);

            }
            return true;

    }
    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        ArrayList<FeaturedHelperClass>featuredLocations=new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.tshirt,"RED TAPE Tshirt ","Men Typography Round Neck Pure Cotton Blue T-Shirt"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.tshirt2,"RED TAPE Tshirt","₹417"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.park_avenue,"METRO-FASHION","₹499"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.jeans,"Roadster Jeans","₹759"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.shoes,"HRX Shoes","₹1759"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.boys,"ATLANS TShirt","₹659"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.teamo,"TeAmo Girls Casuals","₹390"));

        adapter=new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }


    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.mcdonald_img, "McDonald's"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.city_2, "Edenrobe"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.city_1, "J."));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.mcdonald_img, "Walmart"));
        adapter = new MostViewedAdpater(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);
    }



    private void categoriesRecycler() {
        //All Gradients

        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffddf3f4, 0xffddf3f4});

        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass( gradient1,R.drawable.winkboy, "Boys"));
        categoriesHelperClasses.add(new CategoriesHelperClass( gradient1,R.drawable.pretty, "Girls"));
        categoriesHelperClasses.add(new CategoriesHelperClass( gradient1,R.drawable.women, "Women"));
        categoriesHelperClasses.add(new CategoriesHelperClass( gradient1,R.drawable.men, "Men"));
        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);
    }



    public void callReatailerScreens(View view){
        startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));
    }


}