package com.employeeinformation.io.respay.employeeinformation.LoginAndRegistrationFragment;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.employeeinformation.io.respay.employeeinformation.All_Activity.LoginAndRegistration;
import com.employeeinformation.io.respay.employeeinformation.ApiClient;
import com.employeeinformation.io.respay.employeeinformation.Employee;
import com.employeeinformation.io.respay.employeeinformation.INetWorkService;
import com.employeeinformation.io.respay.employeeinformation.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Registration extends Fragment {
    @BindView(R.id.link_to_login)
    TextView linkToLogin;
    @BindView(R.id.btnRegister)
    Button registration;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.type)
    EditText type;
    @BindView(R.id.id)
    EditText id;
    @BindView(R.id.address)
    EditText address;
    @BindView(R.id.date_of_joining)
    EditText date_of_joining;
    @BindView(R.id.reg_password)
    EditText password;
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
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                INetWorkService service = ApiClient.getClient().create(INetWorkService.class);
                Employee employee = new Employee();
                employee.setName(name.getText().toString());
                employee.setType(type.getText().toString());
                employee.setId(id.getText().toString());
                employee.setAddress(address.getText().toString());
                employee.setDate_of_joining(date_of_joining.getText().toString());
                employee.setPassword(password.getText().toString());
                Call<Employee> call = service.insertData(employee.getName(),employee.getType(),employee.getId(),employee.getAddress(),employee.getDate_of_joining(),employee.getPassword());
                call.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        Toast.makeText(getActivity(), "response"+response.body().getStatus(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {
                        Log.i("Hello",""+t);
                        Toast.makeText(getActivity(), "Throwable"+t, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        return viewOfRegistration;
    }

}
