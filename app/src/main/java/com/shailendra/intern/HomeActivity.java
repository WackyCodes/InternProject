package com.shailendra.intern;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.shailendra.intern.home.ListAdaptor;
import com.shailendra.intern.home.ListModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private TextView myDriveText;
    private ImageButton backButton;

    private ListView homeListView;
    ArrayList <ListModel> dataModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );

        myDriveText = findViewById( R.id.my_drives );

        backButton = findViewById( R.id.back_image_button );

        homeListView = findViewById( R.id.home_list );

        dataModels= new ArrayList<>();
        dataModels.add( new ListModel( "SPIRITUAL Empowerment", "9,523", "05:00 AM | 07 DEC 2019" ) );
        dataModels.add( new ListModel( "SPIRITUAL Empowerment", "9,523", "05:00 AM | 07 DEC 2019" ) );
        dataModels.add( new ListModel( "SPIRITUAL Empowerment", "9,523", "05:00 AM | 07 DEC 2019" ) );
        dataModels.add( new ListModel( "SPIRITUAL Empowerment", "9,523", "05:00 AM | 07 DEC 2019" ) );
        dataModels.add( new ListModel( "SPIRITUAL Empowerment", "9,523", "05:00 AM | 07 DEC 2019" ) );

        ListAdaptor adapter = new ListAdaptor( dataModels, getApplicationContext() );
        homeListView.setAdapter( adapter );
//        adapter.notifyDataSetChanged();

        myDriveText.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( HomeActivity.this, ProfileActivity.class ) );
            }
        } );

        backButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        } );

    }

    @Override
    public void onBackPressed() {
        onBackDialog();
    }

    private void onBackDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Exit From App ?" );
        builder.setMessage( "" );
        builder.setPositiveButton( "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                finish();
            }
        } );

        builder.setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        } );

        builder.show();

    }

}
