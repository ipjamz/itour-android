package com.peterjamesbabiera.itour_android.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.peterjamesbabiera.itour_android.R;

/**
 * Created by peter on 2/12/18.
 */

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        mProgressBar = findViewById(R.id.pb_login);
        findViewById(R.id.btn_login).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login: {
                mProgressBar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

}
