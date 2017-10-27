package jaeginit.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    //necessary variables for each question
    int[] answersCorrect = new int[4];
    String[] possibleAnswers3 = {"Deplorables", " Deplorables", "Deplorables ", " Deplorables ", "deplorables", " deplorables", "deplorables ", " deplorables "};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        int id = view.getId();
        // Check which radio button was clicked
        if (id == R.id.radioButton1) {
            if (checked) {
                answersCorrect[0] = 1;
            }
        } else if (id == R.id.radioButton2) {
            if (checked) {
                answersCorrect[0] = 0;
            }
        }
    }

    public void endQuiz(View view) {
        CheckBox[] checks = {(CheckBox) findViewById(R.id.check1), (CheckBox) findViewById(R.id.check2), (CheckBox) findViewById(R.id.check3), (CheckBox) findViewById(R.id.check4)};
        if (checks[0].isChecked() && checks[1].isChecked() && checks[2].isChecked() && !(checks[3].isChecked())) {
            answersCorrect[1] = 1;
        } else {
            answersCorrect[1] = 0;
        }
        EditText hillyView = (EditText) findViewById(R.id.editText);
        EditText trumpView = (EditText) findViewById(R.id.editText2);
        if (hillyView.getText().toString().equals("Deplorables")) {
            answersCorrect[2] = 1;
        }
        if (trumpView.getText().toString().equals("pussy")) {
            answersCorrect[3] = 1;
        }
        int numCorrect = answersCorrect[0] + answersCorrect[1] + answersCorrect[2] + answersCorrect[3];
        double score = (numCorrect / 4.0)*100;
        String scoreText=Double.toString(score)+"%";
        Intent myIntent = new Intent(view.getContext(), ResponseActivity.class);
        myIntent.putExtra(Intent.EXTRA_TEXT, scoreText);

        startActivity(myIntent);

    }


}
