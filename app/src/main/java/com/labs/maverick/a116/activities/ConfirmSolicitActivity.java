package com.labs.maverick.a116.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.labs.maverick.a116.R;

public class ConfirmSolicitActivity extends AppCompatActivity {

    private Button madddetailsconfirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_solicit);
       bindUI();
        madddetailsconfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAddDetails();
            }
        });
    }

    public void bindUI(){
        madddetailsconfirmButton = findViewById(R.id.adddetailsconfirmButton);
    }
    public void goToAddDetails(){
        startActivity(new Intent(ConfirmSolicitActivity.this,AddDetailsActivity.class));
    }
}
