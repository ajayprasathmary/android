package com.compunetconnections.academy;




import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class exam extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab2, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }
}

//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//
//
//
//import android.app.ProgressDialog;
//
//import android.content.SharedPreferences;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.os.AsyncTask;
//
//import android.os.StrictMode;
//import android.preference.PreferenceManager;
//import android.widget.SimpleAdapter;
//import android.widget.TextView;
//import android.widget.Toast;
//
//
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;
//
//import org.apache.http.util.EntityUtils;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class exam extends AppCompatActivity {
//
////    ListView listView,lv;
////
////    ArrayList<HashMap<String, String>> data;
////
////    private String[] batchArray,batchDetailArray,batchId,contentId;
////    ArrayList<NameValuePair> nameValuePairs;
//    ProgressDialog dialog = null;
//    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//    SharedPreferences prefs;
//    SharedPreferences.Editor editor;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_exam);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3F51B5")));
//        getSupportActionBar().setTitle("Exams");
//
//        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//        editor = prefs.edit();
//
//        //lv = (ListView) findViewById(R.id.listview_with_fab);
//
//       // new LogIn().execute("http://advocate.compunet.in/Academy/task2/examdisplay1.php");
//
//    }
//
//    private class LogIn extends AsyncTask<String, Void, String> {
//        @Override
//        protected  void onPreExecute()
//        {
//            dialog = ProgressDialog.show(exam.this, "",
//                    "Loading Exams...", true);
//        }
//        @Override
//        protected String doInBackground(String... params) {
//            String responseStr="";
//            try {
//                HttpClient httpclient = new DefaultHttpClient();
//                HttpPost httppost = new HttpPost(params[0]);
//                HttpResponse response = httpclient.execute(httppost);
//                responseStr = EntityUtils.toString(response.getEntity());
//            }
//
//            catch (Exception ex) {
//                ex.printStackTrace();
//                responseStr="networkerror";
//            }
//            return responseStr;
//        }
//
////        @Override
////        protected void onPostExecute(String result) {
////
////            String output = result;
////            try
////
////            {
////                JSONObject reader = new JSONObject(output);
////
////                JSONArray jsonArray = reader.getJSONArray("Exams");
////
////                String[] batchIdR = new String[jsonArray.length()];
////                String[] batchArrayR = new String[jsonArray.length()];
////                String[] batchDetailArrayR = new String[jsonArray.length()];
////                String[] contentR = new String[jsonArray.length()];
////
////                batchArray=new String[jsonArray.length()];
////                batchDetailArray=new String[jsonArray.length()];
////                batchId=new String[jsonArray.length()];
////                contentId=new String[jsonArray.length()];
////                for(int i=0; i < jsonArray.length(); i++)
////                {
////                    JSONObject jsonObject = jsonArray.getJSONObject(i);
////
////                    batchIdR[i]= jsonObject.getString("heading").toString();
////                    batchArrayR[i]= jsonObject.getString("detail").toString();
////                    batchDetailArrayR[i]= jsonObject.getString("date").toString();
////                    contentR[i]= jsonObject.getString("content").toString();
////
////
////                    batchArray[i]=batchArrayR[i];
////                    batchDetailArray[i]=batchDetailArrayR[i];
////                    batchId[i]=batchIdR[i];
////                    contentId[i]=contentR[i];
////
////                }
////                dialog.dismiss();
////            }
////
////            catch (JSONException e)
////
////            {
////                e.printStackTrace();
////            }
////
////            /*Toast.makeText(MainActivity.this, caseDetailArray[2].toString(), Toast.LENGTH_SHORT).show();*/
////
////            data = new ArrayList<HashMap<String, String>>();
////
////            for(int i=0;i<batchArray.length;i++){
////                HashMap<String,String> datum = new HashMap<String, String>();
////                datum.put("Batch", batchArray[i]);
////                datum.put("Upcoming_Batch_Detail", batchDetailArray[i]);
////                datum.put("Date", batchId[i]);
////                datum.put("content", contentId[i]);
////
////                data.add(datum);
////            }
////
////            SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), data, R.layout.list_item1, new String[] {"Batch", "Upcoming_Batch_Detail", "Date"}, new int[] {R.id.upcomingdetails_listview_case, R.id.upcomingdetails_listview_case_detail, R.id.date});
////            lv.setAdapter(adapter);
////
////            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////                @Override
////                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
////
////                {
//
//
//
//                   // Intent intent = new Intent(exam.this, detail.class);
///*
//
//                    SimpleAdapter adapter1 = new SimpleAdapter(getBaseContext(), data, R.layout.activity_detail, new String[] {"batch"}, new int[] {R.id.content});
//                    lv.setAdapter(adapter1);
//*/
//
////                    intent.putExtra("content",contentId[position]);
////                    startActivity(intent);
////
////                    Toast.makeText(exam.this, "Details of "+batchId[position] ,   Toast.LENGTH_SHORT ).show();
////                }
////
////
////            });
////
////
////
////        }
////
////
////    }
//
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        switch (item.getItemId()) {
////            case android.R.id.home:
////                finish();
////                return true;
////            default:
////                try {
////                    return super.onOptionsItemSelected(item);
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
////        }
////        return  true;
////
////    }
//
//}}
