package com.example.qr_code_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_authentication extends AppCompatActivity {

    Button login;
    EditText phone, psw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_authentication);

        phone = (EditText) findViewById(R.id.phone_no);
        psw = (EditText) findViewById(R.id.psw);
        login = (Button) findViewById(R.id.login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phone.getText().toString().equals("9591216202") && psw.getText().toString().equals("password")){
                    Intent i = new Intent(login_authentication.this, product_scan_page.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Incorrect login credentials", Toast.LENGTH_LONG).show();
                }
            }
        });


        }
}
