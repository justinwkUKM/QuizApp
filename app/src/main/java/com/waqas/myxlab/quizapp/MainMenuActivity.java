package com.waqas.myxlab.quizapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import xyz.hanks.library.bang.SmallBangView;

public class MainMenuActivity extends AppCompatActivity {

    Button bL1, bL2;
    SmallBangView smallBangView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bL1 = (Button) findViewById(R.id.buttonLevel1);
        bL2 = (Button) findViewById(R.id.buttonLevel2);
        smallBangView = (SmallBangView) findViewById(R.id.like_heart);

        smallBangView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (smallBangView.isSelected()) {
                    smallBangView.setSelected(false);
                } else {
                    smallBangView.setSelected(true);
                    smallBangView.likeAnimation(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            Toast.makeText(MainMenuActivity.this, "smallbang", Toast.LENGTH_SHORT).show();;
                        }
                    });
                }
            }

        });

        bL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(MainMenuActivity.this, QuizActivity.class);
                startActivity(i);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
