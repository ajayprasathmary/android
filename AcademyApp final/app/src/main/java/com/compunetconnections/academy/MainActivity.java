package com.compunetconnections.academy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import com.synnapps.carouselview.*;

public class MainActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.five};
    int[] sampleImages = {R.drawable.lawquote2,R.drawable.law2,R.drawable.law3 };
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    CarouselView carouselView;


   // TextView name, txtView;

    LinearLayout batches, exam, results, app, query,news;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo wifi = cm
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        android.net.NetworkInfo datac = cm
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifi != null & datac != null)
                && (wifi.isConnected() | datac.isConnected())) {
            //connection is avlilable
        } else {
            //no connection
            Toast toast = Toast.makeText(MainActivity.this, "No Internet Connection",
                    Toast.LENGTH_LONG);
            toast.show();

            // txtView.setText("hello check ur network connectivity");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF898B94")));

        getSupportActionBar().setSubtitle("Updates of Law Exams,Results,Daily tips...");

        batches = (LinearLayout) findViewById(R.id.btn_batches);

        exam = (LinearLayout) findViewById(R.id.btn_exam);

        results = (LinearLayout) findViewById(R.id.btn_list);

        app = (LinearLayout) findViewById(R.id.btn_app);

        query = (LinearLayout) findViewById(R.id.btn_query);
        news=(LinearLayout)findViewById(R.id.btn_news);

      //  name = (TextView) findViewById(R.id.name);
        carouselView = (CarouselView)findViewById(R.id.carouselview);

        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                //Toast.makeText(MainActivity.this, "Clicked item: "+ position+"welcome home", Toast.LENGTH_SHORT).show();
            }
        });


       // Typeface roboto = Typeface.createFromAsset(this.getAssets(),
         //       "OleoScript-Bold.ttf"); //use this.getAssets if you are calling from an Activity
        //name.setTypeface(roboto);

        /*init();*/

        batches.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, batches.class));
            }
        });

        results.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RankList.class));
            }
        });

        exam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExamFinal.class));
            }
        });

        app.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Application.class));
            }
        });

        query.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, queries.class));
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, News.class));
            }
        });

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };





}







