package com.employeeinformation.io.respay.employeeinformation.LoginAndRegistrationFragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.employeeinformation.io.respay.employeeinformation.All_Activity.CrudOperation;
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
public class LogIn extends Fragment {
    @BindView(R.id.link_to_register)
    TextView linkToRegister;
    @BindView(R.id.btnLogin)
    Button logIn;
    @BindView(R.id.id)
    TextView id;
    @BindView(R.id.password)
    TextView password;
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
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                INetWorkService service = ApiClient.getClient().create(INetWorkService.class);
                Employee employee = new Employee();
                employee.setId(id.getText().toString());
                employee.setPassword(password.getText().toString());
                Call<Employee> call = service.login(employee.getId(),employee.getPassword());
                call.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        if(response.body().getStatus()==1){
                            Intent intent = new Intent(getActivity(), CrudOperation.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getActivity(), "Wrong password or id", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {
                        Log.i("Hello",""+t);
                        Toast.makeText(getActivity(), "Throwable"+t, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        return viewOfLogin;
    }

}
