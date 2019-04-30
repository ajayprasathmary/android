package com.compunetconnections.academy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        getSupportActionBar().setTitle("Details");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String dataString = "content";


        Bundle extras = getIntent().getExtras();


        if(extras != null)

        {
            dataString= extras.getString("content");
        }

        TextView tvData = (TextView) findViewById(R.id.content);


        tvData.setText(dataString);
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
