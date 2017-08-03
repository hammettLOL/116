package com.labs.maverick.a116.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.labs.maverick.a116.R;

public class AddDetailsActivity extends AppCompatActivity {

    private Button msolicitadddetailButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);
        msolicitadddetailButton = findViewById(R.id.solicitadddetailButton);

        msolicitadddetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
