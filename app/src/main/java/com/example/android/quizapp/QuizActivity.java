package com.example.android.quizapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by User on 26.6.2016..
 */
public class QuizActivity extends AppCompatActivity {

    private static final String CORRECT_ANSWER_FOR_QUESTION_ONE = "LACROSSE";
    private static final String CORRECT_ANSWER_FOR_QUESTION_THREE = "14";


    private boolean mRadioGroupOneSelectedValue = false;
    private boolean mRadioGroupTwoSelectedValue = false;

    private boolean mCheckBoxZero = false;
    private boolean mCheckBoxOne = false;


    private EditText mAnswerOne;
    private EditText mAnswerThree;


    private Button mSubmitButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz);

        mAnswerOne = (EditText) findViewById(R.id.answer_one);
        mAnswerThree = (EditText) findViewById(R.id.answer_three);
        mSubmitButton = (Button) findViewById(R.id.submitBotton);
    }

    // Method for handling radio elements group one
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        mRadioGroupOneSelectedValue = false;
        // Check which radio button was clicked
        switch (view.getId()) {

            case R.id.radio_india:
                if (checked)
                    mRadioGroupOneSelectedValue = true;
                break;


        }
    }

    // Method for handling radio elements group two
    public void onRadioButtonClickedTwo(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        mRadioGroupTwoSelectedValue = false;
        // Check which radio button was clicked
        switch (view.getId()) {

            case R.id.radio_selected_value:
                if (checked)
                    mRadioGroupTwoSelectedValue = true;
                break;


        }
    }

    // Method for handling checkbox elements
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        //boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_0:
                mCheckBoxZero = !mCheckBoxZero;
                break;
            case R.id.checkbox_1:
                mCheckBoxOne = !mCheckBoxOne;
                break;
        }
    }

    // handling click for submit button
    public void onSubmitClicked(View view) {

        boolean[] numberOfAnswers = new boolean[5];
        int counterOfGoodAnswers = 0;

        if (mAnswerOne.getText().toString().toUpperCase().equals(CORRECT_ANSWER_FOR_QUESTION_ONE)) {
            numberOfAnswers[0] = true;
        }
        if (mRadioGroupOneSelectedValue) {
            numberOfAnswers[1] = true;
        }
        if (mCheckBoxOne && mCheckBoxZero) {
            numberOfAnswers[2] = true;
        }
        if (mAnswerThree.getText().toString().equals(CORRECT_ANSWER_FOR_QUESTION_THREE)) {
            numberOfAnswers[3] = true;
        }
        if (mRadioGroupTwoSelectedValue) {
            numberOfAnswers[4] = true;
        }

        for (int i = 0; i < numberOfAnswers.length; i++) {
            if (numberOfAnswers[i]) {
                counterOfGoodAnswers++;
            }
        }

        Snackbar.make(mSubmitButton, "Correct answers : " +
                        counterOfGoodAnswers + "/" +
                        numberOfAnswers.length +
                        " " + "(" + (int) (((float) counterOfGoodAnswers / numberOfAnswers.length) * 100) + "%)",
                Snackbar.LENGTH_LONG).show();

    }


}
