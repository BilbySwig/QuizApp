package jaeginit.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class ResponseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        TextView text=(TextView)findViewById(R.id.scoreView);
        String scoreText=getIntent().getStringExtra(Intent.EXTRA_TEXT);
        text.setText(scoreText);
    }
}
