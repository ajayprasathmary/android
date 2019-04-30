package com.compunetconnections.academy;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

public class Pdf2 extends AppCompatActivity {
    PDFView pdfView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        pdfView=findViewById(R.id.pdfview);
        ActionBar actionBar =getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("CLAT 2010");
        actionBar.setDisplayHomeAsUpEnabled(true);

        new Retrivepdf().execute("https://static-collegedunia.com/public/college_data/images/entrance/sample_paper/1477559785CLAT%202010.pdf");

    }
    class Retrivepdf extends AsyncTask<String,Void,InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream input=null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                if(httpConn.getResponseCode() == 200)
                {
                    input =new BufferedInputStream(httpConn.getInputStream());
                }
            }
            catch (IOException e)
            {
                return null;

            }
            return input;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();

        }
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
