package com.compunetconnections.academy;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PaperMain extends AppCompatActivity {
    ImageView view1,view2,view3,view4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar =getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Sample Papers");
        actionBar.setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);
        view1= findViewById(R.id.pdview1);
        view2=findViewById(R.id.pdview2);
        view3=findViewById(R.id.pdview3);
        view4=findViewById(R.id.pdview4);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaperMain.this, Pdf1.class));



            }
        });
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaperMain.this, Pdf2.class));



            }
        });
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaperMain.this, Pdf3.class));



            }
        });
        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaperMain.this, Pdf4.class));



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
