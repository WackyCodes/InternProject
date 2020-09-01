package com.shailendra.intern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ProfileActivity extends AppCompatActivity {

    public static final UserDataModel userDataModel = new UserDataModel(  );

    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_profile );

        backButton = findViewById( R.id.back_image_button );

        backButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        } );

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
