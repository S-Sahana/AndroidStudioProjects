package com.example.ssrivath.firebaseexample;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView DisplayName;
    EditText ArtistName;
    EditText ArtistGenre;
    Button addArtist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayName = (TextView)findViewById(R.id.Artist);
        ArtistName = (EditText)findViewById(R.id.editTextArtistName);
        ArtistGenre = (EditText)findViewById(R.id.editTextGenre);
        addArtist = (Button)findViewById(R.id.buttonAddToList);
    }




    @Override
    public void onClick(View v) {

    }
}
