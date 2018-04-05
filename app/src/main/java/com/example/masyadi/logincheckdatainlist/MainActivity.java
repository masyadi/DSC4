package com.example.masyadi.logincheckdatainlist;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtEmail, txtPassword;
    Button btnLogin, btnRegister;
    List<UserModel> listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtEmail    = (EditText) findViewById(R.id.txt_email);
        txtPassword = (EditText) findViewById(R.id.txt_password);
        btnLogin    = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_register);

        listUser = new ArrayList<>();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email    = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();

                if(isCheckLogin(email, password)){
                    Toast.makeText(MainActivity.this, "Login sukses", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Email atau password salah!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //View contentDialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.view_content_dialog_register, null);
                final View contentDialog = getLayoutInflater().inflate(R.layout.view_content_dialog_register, null);

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setView(contentDialog);
                alertDialog.setTitle("Register");
                alertDialog.setCancelable(true);
                alertDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText txtEmailRegister       = (EditText) contentDialog.findViewById(R.id.txt_email);
                        EditText txtPasswordRegister1   = (EditText) contentDialog.findViewById(R.id.txt_password_1);
                        EditText txtPasswordRegister2   = (EditText) contentDialog.findViewById(R.id.txt_password_2);

                        String strEmail     = txtEmailRegister.getText().toString().trim();
                        String strPassword1 = txtPasswordRegister1.getText().toString().trim();
                        String strPassword2 = txtPasswordRegister2.getText().toString().trim();


                        if(!strPassword1.equals(strPassword2)){
                            Toast.makeText(MainActivity.this, "Password dan ulangi password tidak sama!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            listUser.add(new UserModel(strEmail, strPassword1));
                            dialog.dismiss();
                        }
                    }
                });
                alertDialog.setNegativeButton("cancel", null);
                alertDialog.create();
                alertDialog.show();

            }
        });
    }


    private boolean isCheckLogin(String email, String password){
        //looping with enhanced statement
        for(UserModel dataUser : listUser){
            if(email.equals(dataUser.getEmail()) && password.equals(dataUser.getPassword())){
                return true;
            }
            else {
                return false;
            }
        }

        return false;
    }
}
