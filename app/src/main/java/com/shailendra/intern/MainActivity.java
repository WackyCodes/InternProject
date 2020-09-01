package com.shailendra.intern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private EditText emailText;
    private EditText passwordText;

    private Button loginButton;

    private TextView clickBtnl;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        // Assign...
        emailText = findViewById( R.id.email );
        passwordText = findViewById( R.id.password );
        loginButton = findViewById( R.id.login_btn );
        progressBar = findViewById( R.id.progressBar );

        loginButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidData( emailText, passwordText )){
                    progressBar.setVisibility( View.VISIBLE );
                    sendJsonPostRequest(emailText.getText().toString(), passwordText.getText().toString());
                }
            }
        } );

        clickBtnl = findViewById( R.id.click_here_tv );
        clickBtnl.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( MainActivity.this, HomeActivity.class ) );
            }
        } );

    }


    private boolean isValidData(EditText wReference, EditText passRef){
        String wEmail = wReference.getText().toString().trim();
        String emailRegex =
                "^[a-zA-Z0-9_+&*-]+(?:\\."+
                        "[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                        "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        boolean bool = pat.matcher(wEmail).matches();

        if (TextUtils.isEmpty( wEmail )) {
            wReference.setError( "Please Enter Email! " );
            return false;
        } else if (!bool){
            wReference.setError( "Please Enter Valid Email! " );
            return false;
        }
        if(TextUtils.isEmpty( passRef.getText().toString() )){
            passRef.setError( "Please Enter Valid Email! " );
            return false;
        }

        return true;
    }

    private void showToast(String msg){
        Toast.makeText( MainActivity.this, msg, Toast.LENGTH_SHORT ).show();
    }

    private void sendJsonPostRequest(String email, String password){
        String url ="https://reqres.in/api/login";

        JSONObject jsonParam = new JSONObject();

        try {
            // JSon Param
            jsonParam.put( "email", email );
            jsonParam.put( "password", password );
            //"token": "QpwL5tke4Pnpja7X4"
//        "email": "eve.holt@reqres.in",
//        "password": "cityslicka"
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                ( Request.Method.POST, url, jsonParam, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
//                        String errorCode = response.toString();
                        if (response.toString().length() != 0 && !response.toString().equals( "null" )){
                            showToast( "Successfully Login!" );
                            progressBar.setVisibility( View.GONE );
                            startActivity( new Intent( MainActivity.this, HomeActivity.class ) );
                            finish();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        showToast( "err : "+ error.getMessage() );
                        progressBar.setVisibility( View.GONE );
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add( jsonObjectRequest );

    }




}
