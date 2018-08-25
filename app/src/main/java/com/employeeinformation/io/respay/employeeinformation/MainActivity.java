package com.employeeinformation.io.respay.employeeinformation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText name,type, id,address,date_of_joining;
    Button save,get,delete,update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= (EditText) findViewById(R.id.name);
        type= (EditText) findViewById(R.id.type);
        id= (EditText) findViewById(R.id.id);
        address= (EditText) findViewById(R.id.address);
        date_of_joining= (EditText) findViewById(R.id.date_of_joining);
        save = (Button) findViewById(R.id.save);
        get = (Button) findViewById(R.id.get);
        delete = (Button) findViewById(R.id.delete);
        update= (Button) findViewById(R.id.update);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                INetWorkService service = ApiClient.getClient().create(INetWorkService.class);
                Employee employee = new Employee();
                employee.setName(name.getText().toString());
                employee.setType(type.getText().toString());
                employee.setId(id.getText().toString());
                employee.setAddress(address.getText().toString());
                employee.setDate_of_joining(date_of_joining.getText().toString());
                Call<Employee> call = service.insertData(employee.getName(),employee.getType(),employee.getId(),employee.getAddress(),employee.getDate_of_joining());
                call.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        Toast.makeText(MainActivity.this, "response"+response.body().getStatus(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {
                        Log.i("Hello",""+t);
                        Toast.makeText(MainActivity.this, "Throwable"+t, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                INetWorkService service = ApiClient.getClient().create(INetWorkService.class);
                Call<List<Employee>> call = service.getData();
                call.enqueue(new Callback<List<Employee>>() {
                    @Override
                    public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                        List<Employee>employeeInformations=response.body();

                        //Now do whatever you like to do with this list

                        for (int i = 0; i < employeeInformations.size(); i++) {

                            Toast.makeText(MainActivity.this, employeeInformations.get(i).getName(),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Employee>> call, Throwable t) {
                        Log.i("Hello",""+t);
                        Toast.makeText(MainActivity.this, "Throwable"+t, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                INetWorkService service = ApiClient.getClient().create(INetWorkService.class);
                Employee employee = new Employee();

                employee.setId(id.getText().toString());

                Call<Employee> call = service.deleteData(employee.getId());
                call.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        Toast.makeText(MainActivity.this, "response"+response.body().getStatus(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {
                        Log.i("Hello",""+t);
                        Toast.makeText(MainActivity.this, "Throwable"+t, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                INetWorkService service = ApiClient.getClient().create(INetWorkService.class);
                Employee employee = new Employee();
                employee.setName(name.getText().toString());
                employee.setType(type.getText().toString());
                employee.setId(id.getText().toString());
                employee.setAddress(address.getText().toString());
                employee.setDate_of_joining(date_of_joining.getText().toString());
                Call<Employee> call = service.updateData(employee.getName(),employee.getType(),employee.getId(),employee.getAddress(),employee.getDate_of_joining());
                call.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        Toast.makeText(MainActivity.this, "response"+response.body().getStatus(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {
                        Log.i("Hello",""+t);
                        Toast.makeText(MainActivity.this, "Throwable"+t, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

}

