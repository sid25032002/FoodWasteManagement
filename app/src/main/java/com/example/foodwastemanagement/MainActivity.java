package com.example.foodwastemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();

        Button btn=findViewById(R.id.button3);
        Button btn_submit=findViewById(R.id.button2);
        Button btn_admin=findViewById(R.id.button);

        EditText edtName = findViewById(R.id.edtName);
        EditText edtPhone = findViewById(R.id.edtPhone);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtPass = findViewById(R.id.edtPass);
        EditText edtAddress = findViewById(R.id.edtAddress);
        EditText edtQuantity = findViewById(R.id.edtQuantity);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(MainActivity.this,MapsActivity.class);
                startActivity(in);

            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                firebaseAuth.createUserWithEmailAndPassword(edtEmail.getText().toString(),edtPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){

                            String uid=task.getResult().getUser().getUid();

                            Users user=new Users( uid,edtName.getText().toString(),edtPhone.getText().toString(),edtEmail.getText().toString(),edtPass.getText().toString(),edtQuantity.getText().toString(),edtAddress.getText().toString());
                            firebaseDatabase.getReference().child("Users").child(uid).setValue(user);


                            Intent in=new Intent(MainActivity.this,MainActivity_submit.class);
                            startActivity(in);
                        }
                        else{

                            Toast.makeText(getApplicationContext(),task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });
        btn_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,Admin.class);
                startActivity(in);

            }
        });

}
}