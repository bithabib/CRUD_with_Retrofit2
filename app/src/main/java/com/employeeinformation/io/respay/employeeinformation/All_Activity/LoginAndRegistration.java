package com.employeeinformation.io.respay.employeeinformation.All_Activity;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.employeeinformation.io.respay.employeeinformation.LoginAndRegistrationFragment.LogIn;
import com.employeeinformation.io.respay.employeeinformation.R;

public class LoginAndRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_registration);
        addFragment(new LogIn());
    }
    public void addFragment(Fragment replaceFragment) {
        this.getFragmentManager().beginTransaction()
                .add(R.id.fragment_holder,replaceFragment)
                .addToBackStack(null)
                .commit();
    }
}
