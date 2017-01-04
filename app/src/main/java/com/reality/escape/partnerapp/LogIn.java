package com.reality.escape.partnerapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by JR HARI NANDHA on 17-12-2016.
 */
public class LogIn extends AppCompatActivity {


    String name,email,birthday,gender,id;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    public static int skip;
    private Button register,signin;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);

        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LogIn.this,Content.class) ;
                startActivity(intent1);


            }
        });
        signin = (Button) findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LogIn.this, com.reality.escape.partnerapp.Signin.class) ;
                intent1.putExtra("Register",1);
                startActivity(intent1);

            }
        });
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.reality.escape.fbapi",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton)findViewById(R.id.login);
        loginButton.setReadPermissions(Arrays.asList(
                "public_profile", "email", "user_birthday", "user_friends"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            Context context = getApplicationContext();

            @Override
            public void onSuccess(LoginResult loginResult) {
                final AccessToken accessToken = loginResult.getAccessToken();

                GraphRequest graphRequest = GraphRequest.newMeRequest(accessToken,new GraphRequest.GraphJSONObjectCallback(){

                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        try {
                           // String email = object.getString("email");
                            Log.v("Main",response.toString());

                             birthday = object.getString("birthday");
                             name = object.getString("name");
                             email = object.getString("email");
                             gender = object.getString("gender");
                            id = object.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                        skip = 1;
                        Intent intent = new Intent(LogIn.this, com.reality.escape.partnerapp.Signin.class);
                        intent.putExtra("name",name);
                        intent.putExtra("email",email);
                        intent.putExtra("birthday",birthday);
                        intent.putExtra("gender",gender);
                        intent.putExtra("id",id);
                        intent.putExtra("Register",0);
                        startActivity(intent);


                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                graphRequest.setParameters(parameters);
                graphRequest.executeAsync();


            }

            @Override
            public void onCancel() {

                System.out.println("Cancelled");
            }

            @Override
            public void onError(FacebookException error) {
             Toast toast = Toast.makeText(context,"Signin failed. Please try again later",Toast.LENGTH_SHORT);
                toast.show();

            }


        });
    }

    @Override
    protected  void onActivityResult(int requestCode,int resultCode, Intent data){
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

}
