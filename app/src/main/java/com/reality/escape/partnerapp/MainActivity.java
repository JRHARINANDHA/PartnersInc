package com.reality.escape.partnerapp;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    ObjectAnimator animator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.loader);
        progressBar.setProgress(0);
        progressBar.setVisibility(View.GONE);

        animator = ObjectAnimator.ofInt(progressBar,"progress",0,100);
        animator.setDuration(3000);
        animator.setInterpolator(new LinearInterpolator());
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if(LogIn.skip == 1){
                    Intent intent = new Intent(MainActivity.this,Content.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                }

                Intent intent = new Intent(MainActivity.this,LogIn.class);
                startActivity(intent);
                MainActivity.this.finish();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.start();
    }



}
