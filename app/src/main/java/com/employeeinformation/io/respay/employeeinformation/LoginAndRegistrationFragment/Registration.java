package com.employeeinformation.io.respay.employeeinformation.LoginAndRegistrationFragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.employeeinformation.io.respay.employeeinformation.All_Activity.LoginAndRegistration;
import com.employeeinformation.io.respay.employeeinformation.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Registration extends Fragment {
    @BindView(R.id.link_to_login)
    TextView linkToLogin;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewOfRegistration=inflater.inflate(R.layout.fragment_registration, container, false);
        ButterKnife.bind(this, viewOfRegistration);
        linkToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment  logIn= new LogIn();
                ((LoginAndRegistration)getActivity()).addFragment(logIn);
            }
        });
        return viewOfRegistration;
    }

}
