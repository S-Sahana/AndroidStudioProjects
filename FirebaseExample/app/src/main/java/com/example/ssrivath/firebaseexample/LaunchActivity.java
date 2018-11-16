package com.example.ssrivath.firebaseexample;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EdgeEffect;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LaunchActivity extends AppCompatActivity {
    private FirebaseAuth fbAuth;
    EditText userId;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        fbAuth = FirebaseAuth.getInstance();
    }

    private void registerUser(){
        fbAuth.createUserWithEmailAndPassword("user name","password")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isComplete()){

                        }
                        else {

                        }
                    }
                });
    }

}
