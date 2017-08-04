package com.labs.maverick.a116.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.labs.maverick.a116.R;

public class LoginActivity extends AppCompatActivity {
    private Button mloginButton;
    private EditText mnameloginEditText;
    private EditText nphoneloginEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindUI();
        mloginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mnameloginEditText.getText().toString();
                String phone = nphoneloginEditText.getText().toString();
                if(login(name,phone)) {
                    goToVerify();
                }
            }
        });

    }

    private void bindUI(){
        mloginButton = findViewById(R.id.loginButton);
        mnameloginEditText = findViewById(R.id.nameloginEditText);
        nphoneloginEditText = findViewById(R.id.phoneloginEditText);
    }

    private boolean login(String name,String phone){
        if(!isValidName(name)){
            Toast.makeText(this,"El nombre no es válido",Toast.LENGTH_SHORT).show();
            return false;
        }else if(!isValidPhone(phone)){
            Toast.makeText(this,"El número no es válido",Toast.LENGTH_SHORT).show();
            return false;
                }
                else {
                    return true;
                }
    }

    private boolean isValidName(String name){
        return !TextUtils.isEmpty(name);
    }

    private boolean isValidPhone(String phone){
        return !TextUtils.isEmpty(phone) && Patterns.PHONE.matcher(phone).matches();
    }

    private void goToVerify(){
        startActivity(new Intent(LoginActivity.this, VerifyActivity.class)
        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }
}
