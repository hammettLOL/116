package com.labs.maverick.a116.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.labs.maverick.a116.activities.LoginActivity;
import com.labs.maverick.a116.activities.MainActivity;
import com.labs.maverick.a116.model.User;

import java.util.List;
import java.util.ListResourceBundle;

public class SplashActivity extends AppCompatActivity {
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = User.first(User.class);
        if(user == null){
            gotoLogin();
        }else{
            User.deleteAll(User.class);
            gotoMain();
        }

    }

    public void gotoLogin(){
        startActivity(new Intent(this,LoginActivity.class));
    }
    public void gotoMain(){
        startActivity(new Intent(this,MainActivity.class));
    }
}
