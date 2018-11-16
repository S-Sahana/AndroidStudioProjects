package com.example.ssrivath.firebaseexample;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LaunchActivity extends Activity implements View.OnClickListener{
    private FirebaseAuth fbAuth;
    EditText userId;
    EditText password;
    Button signIn;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        fbAuth = FirebaseAuth.getInstance();
        userId = (EditText) findViewById(R.id.editTextEmailID);
        password = (EditText) findViewById(R.id.editTextPassword);
        signIn = (Button) findViewById(R.id.buttonLogin);
        progressDialog = new ProgressDialog(this);
        signIn.setOnClickListener(this);
    }

    private void registerUser(){
        String emailId = userId.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if(TextUtils.isEmpty(emailId)){
            Toast.makeText(this,"Enter Email Id field",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this,"Enter password to set",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Registering please wait....");
        progressDialog.show();

        fbAuth.createUserWithEmailAndPassword(emailId,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isComplete()){
                               Toast.makeText(LaunchActivity.this,"Registration successful",Toast.LENGTH_SHORT).show();
                        }
                        else {
                               Toast.makeText(LaunchActivity.this,"Registration error",Toast.LENGTH_SHORT).show();

                    }
                        progressDialog.dismiss();
                    }
                });
    }
    @Override
    public void onClick(View view){
       registerUser();
    }

}
