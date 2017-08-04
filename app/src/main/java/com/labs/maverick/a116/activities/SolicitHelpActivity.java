package com.labs.maverick.a116.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.labs.maverick.a116.R;

public class SolicitHelpActivity extends AppCompatActivity {

    private Button msolicithelpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicit_help);
        bindUI();
        msolicithelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToConfirmSolicit();
            }
        });
    }

    public void bindUI(){
        msolicithelpButton = findViewById(R.id.solicithelpButton);
    }
    public void goToConfirmSolicit(){
        startActivity(new Intent(SolicitHelpActivity.this,ConfirmSolicitActivity.class));
    }
}
