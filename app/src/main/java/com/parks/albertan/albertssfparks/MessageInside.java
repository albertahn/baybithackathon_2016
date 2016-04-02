package com.parks.albertan.albertssfparks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by albert on 7/21/14.
 */
public class MessageInside extends AppCompatActivity {

    View rootview;
    String inputText;
    Context context;
    String prevActivity;
    String otherguyname, zipcode,human_address,psamanager,email,number;
    Activity activity = this;


    /*
    *  i.putExtra("other_guy_index", "" + parkname);
                i.putExtra("otherguyname", parkname);

                i.putExtra("prevActivity", "MainActivity");

                i.putExtra("zipcode", zipcode);
                i.putExtra("human_address", human_address);
                i.putExtra("psamanager", psamanager);
                i.putExtra("email", email);
                i.putExtra("number", number);
    * */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;


//get id
        Intent intent = getIntent();
       // hasMessageID = intent.getStringExtra("hasMessageID");
        prevActivity = intent.getStringExtra("prevActivity");
        otherguyname = intent.getStringExtra("otherguyname");

        zipcode= intent.getStringExtra("zipcode");
        human_address = intent.getStringExtra("human_address");
        psamanager = intent.getStringExtra("psamanager");
        email = intent.getStringExtra("email");
        number = intent.getStringExtra("number");


        //the acitonbar title

        getSupportActionBar().setTitle(otherguyname);
        //getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.titlecolor));

        //get userid

            rootview = LayoutInflater.from(getApplicationContext()).inflate(R.layout.message_inside_____message_input_part, null);
            setContentView(rootview);



        //hide keyboard
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        TextView parknameText = (TextView) rootview.findViewById(R.id.parkname_here);
            TextView describepark =  (TextView)  rootview.findViewById(R.id.describe_park);


        parknameText.setText(otherguyname);

   //detailed description
        describepark.setText("Address: "+ human_address +"\n"
                            +"zipcode: "+zipcode  +"\n"
                            + " email: "+  email  +"\n"
                            + "number: "+ number +"\n"
                            + "psamanager: "+ psamanager


               );



        //set backbutton
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


    } //end crreate



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

               if(prevActivity==null){

                   Intent i = new Intent(this,
                           MainActivity.class);
                   startActivity(i);
               }else{
                     finish();
               }

                //NavUtils.navigateUpFromSameTask(this);
                return true;
            default:


                finish();
                return super.onOptionsItemSelected(item);
        }
    }//end





} //end activity
