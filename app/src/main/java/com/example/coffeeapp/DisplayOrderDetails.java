package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayOrderDetails extends AppCompatActivity {
    String name;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_order_details);
        //create an intent to catch the String and display
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        message = intent.getStringExtra("message");
        //getting the final output ready
        String output = "Name: "+name +"\n"+ message;
        //create an object of the TextView to display
        TextView displayTextView = (TextView)findViewById(R.id.displayText);
        //display the final output
        displayTextView.setText(output);


    }
    // a method that will open GMail
    public void openEmail (View view){
        // Use an intent (Common) to launch an email app.
        // Send the order summary in the email body.
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Coffee order for "+name);
        emailIntent.putExtra(Intent.EXTRA_TEXT,message);
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        }
    }
}
