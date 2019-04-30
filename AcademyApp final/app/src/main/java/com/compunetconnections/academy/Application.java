package com.compunetconnections.academy;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application extends AppCompatActivity {


    private EditText firstname;
    private EditText lastname;
    private EditText course;
    private EditText address;
    private EditText city;
    private EditText state;
    private EditText country;
    private EditText pinCode;
    private EditText mobileNumber;
    private EditText gender_edittext;
    private ProgressDialog pdia;



    String Getfname ,Getsname,Getcourse,Getadd,Getcity,Getstate,Getcountry,Getpin,Getmbl,Getgen ;


    Button register ;


    String DataParseUrl = "http://advocate.compunet.in/Academy/task2/regdata.php" ;


    Boolean CheckEditText ;

    String RefreshedToken= FirebaseInstanceId.getInstance().getToken();


    private String gender;


   /*public boolean validateNumber(String Getmbl) {
        String Regex = "[^\\s]";
        String PhoneDigits = Getmbl.replaceAll(Regex, "");
      //  Toast.makeText(Application.this, "Invalid", Toast.LENGTH_SHORT).show();

        if (PhoneDigits.length()!=10)
        {

            Toast.makeText(Application.this, "Invalid phone", Toast.LENGTH_SHORT).show();
        }
        return true;
    }*/

   /* private boolean isvalidmob(String mob) {
        if (mob != null && mob.length() == 10) {
            return true;
        }
        return false;
    }

    private boolean isvalidpin(String pin) {
        if (pin != null && pin.length() == 5) {
            return false;
        }
        return true;
    }
*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        getSupportActionBar().setTitle("Registration Form");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        course = (EditText) findViewById(R.id.course);
        address = (EditText) findViewById(R.id.address);
        city = (EditText) findViewById(R.id.city);
        gender_edittext = (EditText) findViewById(R.id.gender_edittext);

        state = (EditText) findViewById(R.id.state);
        country = (EditText) findViewById(R.id.country);

        pinCode = (EditText) findViewById(R.id.pinCode);
        mobileNumber = (EditText) findViewById(R.id.mobileNumber);

        Spinner spinner = (Spinner) findViewById(R.id.gender);





        register = (Button)findViewById(R.id.submit) ;

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Male");
        categories.add("Female");
        categories.add("Transgender");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos,
                                       long id) {
                if (pos == 0) {
                    /*Toast.makeText(getApplicationContext(),"Male", Toast.LENGTH_LONG).show();*/
                    gender = "Male";
                    gender_edittext.setText(gender);

                }

                if (pos == 1)

                {
                    gender = "Female";
                    gender_edittext.setText(gender);
                }
                    if (pos ==2)
                 {
                    /*Toast.makeText(getApplicationContext(),"Female", Toast.LENGTH_LONG).show();*/
                    gender = "Transgender";
                    gender_edittext.setText(gender);
                }
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                GetCheckEditTextIsEmptyOrNot();

                if(CheckEditText){

                    SendDataToServer(Getfname,Getsname,Getcourse,Getgen,Getadd,Getcity,Getstate,Getcountry,Getpin,Getmbl);

                }
                else {


                /*    if (!isvalidpin(Getpin)) {
                        Toast.makeText(Application.this, "Enter a valid Pincode", Toast.LENGTH_SHORT).show();
                    }

                    if (!isvalidmob(Getmbl)) {
                        Toast.makeText(Application.this, "Invalid Mobile Number", Toast.LENGTH_SHORT).show();
                    }
*/


                    Toast.makeText(Application.this, "Please fill all form fields Correctly", Toast.LENGTH_LONG).show();

                }

            }
        });

       /* if (!isvalidmob(Getmbl)) {
*//*
            mobileNumber.setError("Invalid Password");
*//*
            Toast.makeText(Application.this, "mobile", Toast.LENGTH_SHORT).show();
        }*/

    }




    public void GetCheckEditTextIsEmptyOrNot(){

        Getfname = firstname.getText().toString();
        Getsname = lastname.getText().toString();
        Getcourse = course.getText().toString();

        Getgen = gender_edittext.getText().toString();
        Getadd = address.getText().toString();
        Getcity = city.getText().toString();
        Getstate = state.getText().toString();
        Getcountry = country.getText().toString();

        Getpin = pinCode.getText().toString();
        Getmbl = mobileNumber.getText().toString();





        if(TextUtils.isEmpty(Getfname) || TextUtils.isEmpty(Getsname) ||TextUtils.isEmpty(Getcourse) ||TextUtils.isEmpty(Getgen)||


                TextUtils.isEmpty(Getadd)|| TextUtils.isEmpty(Getcity)|| TextUtils.isEmpty(Getstate)||


                TextUtils.isEmpty(Getcountry) || TextUtils.isEmpty(Getpin) || TextUtils.isEmpty(Getmbl))
        {

            CheckEditText = false;

        }
        else {

            CheckEditText = true ;
        }

    }

    public void SendDataToServer(final String firstname, final String lastname,final String course, final String gender_edittext,final

    String address,final String city,final String state,final String country,final String pinCode,final String mobileNumber){


        class SendPostReqAsyncTask extends AsyncTask<String, Void, String>


        {

            @Override
            protected void onPreExecute()
            {
                pdia = ProgressDialog.show(Application.this, "Registering",
                        " please wait...", true);
            }


           // @SuppressWarnings("unchecked")
            @Override
            protected String doInBackground(String... params) {

                String fname = firstname ;
                String sname = lastname ;
                String cour = course ;

                String gen = gender_edittext;
                String add1 = address ;
                String city1 = city ;
                String state1 = state;
                String country1 = country ;
                String pinCode1 = pinCode ;
                String mobileNumber1 = mobileNumber;
                String token1=RefreshedToken;




                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("firstname", fname));
                nameValuePairs.add(new BasicNameValuePair("lastname", sname));
                nameValuePairs.add(new BasicNameValuePair("course", cour));

                nameValuePairs.add(new BasicNameValuePair("gender", gen));
                nameValuePairs.add(new BasicNameValuePair("address", add1));
                nameValuePairs.add(new BasicNameValuePair("city", city1));
                nameValuePairs.add(new BasicNameValuePair("state", state1));
                nameValuePairs.add(new BasicNameValuePair("country", country1));
                nameValuePairs.add(new BasicNameValuePair("pincode", pinCode1));
                nameValuePairs.add(new BasicNameValuePair("mobilenumber", mobileNumber1));
                nameValuePairs.add(new BasicNameValuePair("token", token1));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost("http://advocate.compunet.in/Academy/task2/regdata.php");

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }

                return "Data Submitted Successfully";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                pdia.dismiss();

                Toast.makeText(Application.this, "Data Submitted Successfully", Toast.LENGTH_LONG).show();



            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(firstname, lastname,course, gender_edittext,address,city,state,country,pinCode,mobileNumber);
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