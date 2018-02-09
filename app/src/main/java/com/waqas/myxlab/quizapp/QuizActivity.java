package com.waqas.myxlab.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import static com.waqas.myxlab.quizapp.R.id.radioGroup;

public class QuizActivity extends AppCompatActivity {

    List<Question> questionList;
    int score = 0;
    int quid = 0;
    Question currentQuestion;

    TextView question;
    RadioButton rda, rdb, rdc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DbHelper dbHandler = new DbHelper(this);
        questionList = dbHandler.getAllQuestions();
        Collections.shuffle(questionList);
        currentQuestion = questionList.get(quid);

        question = (TextView) findViewById(R.id.textViewQuestion);
        rda = (RadioButton) findViewById(R.id.radioButtonOptA);
        rdb = (RadioButton) findViewById(R.id.radioButtonOptB);
        rdc = (RadioButton) findViewById(R.id.radioButtonOptC);

        setQuestonView();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup grp = (RadioGroup) findViewById(radioGroup);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                if (currentQuestion.getAnswer().equals(answer.getText())){

                    score++;
                    Log.e("","Score "+ score);
                }

                if (quid<5){
                    currentQuestion = questionList.get(quid);
                    setQuestonView();
                }
                else {
                    Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score",score);
                    i.putExtras(b);
                    startActivity(i);

                }
            }
        });
    }

    private void setQuestonView() {

        question.setText(currentQuestion.getQuestion());
        rda.setText(currentQuestion.getOptionA());
        rdb.setText(currentQuestion.getOptionB());
        rdc.setText(currentQuestion.getOptionC());
        quid++;


    }






}
