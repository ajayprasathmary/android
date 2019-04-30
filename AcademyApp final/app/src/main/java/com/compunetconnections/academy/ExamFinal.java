package com.compunetconnections.academy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.time.Instant;

public class ExamFinal extends AppCompatActivity  {
    LinearLayout lay_syllabus,lay_eligibility,lay_tips,lay_dates;
    TextView paper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3F51B5")));
        getSupportActionBar().setTitle("EXAMS");
        lay_syllabus=(LinearLayout)findViewById(R.id.btn_syllabus);
        lay_eligibility=(LinearLayout)findViewById(R.id.btn_eligibility);
        lay_tips=(LinearLayout)findViewById(R.id.btn_tips);
        lay_dates=(LinearLayout)findViewById(R.id.btn_dates);
        paper=(TextView) findViewById(R.id.spaper);
        lay_syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExamFinal.this, Syllabus.class));
            }
        });
        lay_eligibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExamFinal.this, Eligibility.class));
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExamFinal.this, PaperMain.class));
            }
        });
        lay_tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExamFinal.this, tips.class));
            }
        });
        lay_dates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExamFinal.this, Dates.class));
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}

