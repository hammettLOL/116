package com.labs.maverick.a116.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.labs.maverick.a116.R;

public class VerifyActivity extends AppCompatActivity {

    Button mconfirmarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        mconfirmarButton = findViewById(R.id.confirmarcodigoButton);
        mconfirmarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(VerifyActivity.this, AddContactActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}
