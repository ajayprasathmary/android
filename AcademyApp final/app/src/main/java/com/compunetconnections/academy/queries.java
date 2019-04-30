package com.compunetconnections.academy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class queries extends AppCompatActivity {


    Button btnSend;
    EditText textTo;
    EditText textSubject;
    EditText textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queries);

        getSupportActionBar().setTitle("Queries");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        btnSend = (Button) findViewById(R.id.btn_send);
        textTo = (EditText) findViewById(R.id.to);
        textSubject = (EditText) findViewById(R.id.sub);
        textMessage = (EditText) findViewById(R.id.compose);

        btnSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               // String to = textTo.getText().toString();
                String subject = textSubject.getText().toString();
                String message = textMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "prasathajay6@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

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

