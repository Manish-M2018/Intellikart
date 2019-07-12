package com.example.qr_code_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class landing_page extends AppCompatActivity {

    Button continue_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        continue_button = (Button) findViewById(R.id.bcontinue);

        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(landing_page.this, MainActivity.class);
                startActivity(i);

            }
        });

    }
}
