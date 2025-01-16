package com.example.calculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        Button sumar = findViewById(R.id.sumar);
        resultado = findViewById(R.id.resultado);

        sumar.setOnClickListener(v -> {
            String num1Str = num1.getText().toString();
            String num2Str = num2.getText().toString();
            if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
                try {
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);
                    double suma = num1 + num2;
                    if (suma % 1 == 0) {
                        resultado.setText(getString(R.string.resultado, String.valueOf((int) suma)));
                    } else {
                        resultado.setText(getString(R.string.resultado, String.valueOf(suma)));
                    }
                } catch (NumberFormatException e) {
                    resultado.setText(getString(R.string.resultado_error));
                }
            } else {
                resultado.setText(getString(R.string.resultado_error));
            }
        });
    }
}
