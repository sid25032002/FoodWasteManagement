package com.example.foodwastemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button btn=findViewById(R.id.button4);
        
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse("https://console.firebase.google.com/project/food-waste-management-bb8b0/database/food-waste-management-bb8b0-default-rtdb/data");
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });

        
    }
}