package com.employeeinformation.io.respay.employeeinformation.LoginAndRegistrationFragment;

import android.app.Fragment;
import android.os.Bundle;
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
public class LogIn extends Fragment {
    @BindView(R.id.link_to_register)
    TextView linkToRegister;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewOfLogin=inflater.inflate(R.layout.fragment_log_in, container, false);
        ButterKnife.bind(this, viewOfLogin);
        linkToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment registration = new Registration();
                ((LoginAndRegistration)getActivity()).addFragment(registration);
            }
        });
        return viewOfLogin;
    }

}
