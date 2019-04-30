package com.compunetconnections.academy;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;

public class MyFirebaseInstanceIDservice extends FirebaseInstanceIdService
{

    private static final String TAG = "My Firebase ID service";

    @Override

    public void onTokenRefresh()


{
    String RefreshedToken= FirebaseInstanceId.getInstance().getToken();

    Log.d(TAG, "Refreshed token: " +RefreshedToken);


    SendRegistrationToServer(RefreshedToken);

}

    private void SendRegistrationToServer(String token)


    {

        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormEncodingBuilder()
                .add("token",token)
                .build();

        Request request = new Request.Builder()
                .url("http://advocate.compunet.in/Academy/task2/regdata.php")
                .build();

        try

        {
            client.newCall(request).execute();
        }

        catch (IOException e)

        {
            e.printStackTrace();
        }


    }

}