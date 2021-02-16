package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText eml, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        eml.getText() + " Добро пожаловать", Toast.LENGTH_LONG).show();

                eml = findViewById(R.id.eml);
                pass = findViewById(R.id.pass);
                btn = findViewById(R.id.btn);

                eml.addTextChangedListener(loginTextWatcher);
                pass.addTextChangedListener(loginTextWatcher);
            }

            private TextWatcher loginTextWatcher;

            {
                loginTextWatcher = new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        String emailInput = eml.getText().toString().trim();
                        String passwordInput = pass.getText().toString().trim();

                        btn.setEnabled(!emailInput.isEmpty() && !passwordInput.isEmpty());
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                };
            }
        });
    }
}



