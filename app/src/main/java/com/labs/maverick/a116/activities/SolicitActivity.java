package com.labs.maverick.a116.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.labs.maverick.a116.R;

public class SolicitActivity extends AppCompatActivity {

    private Button msolicitnowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicit);
        bindUI();
        msolicitnowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSolicitHelp();
            }
        });
    }

    public void bindUI(){
        msolicitnowButton = findViewById(R.id.solicitnowButton);
    }

    public void goToSolicitHelp(){
        startActivity(new Intent(SolicitActivity.this,SolicitHelpActivity.class));
    }
}
