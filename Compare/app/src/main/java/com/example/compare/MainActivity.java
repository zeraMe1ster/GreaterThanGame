package com.example.compare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button btnFirst, btnSecond;
    TextView tvResult;
    public int r,m;
    public double randomDouble, randomDouble2;
    public int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFirst = findViewById(R.id.btnFirst);
        btnSecond = findViewById(R.id.btnSecond);
        tvResult = findViewById(R.id.tvResult);

        randomDouble = Math.random();
        randomDouble2 = Math.random();
        randomDouble = randomDouble * 10 + 1;
        randomDouble2 = randomDouble2 * 10 + 1;
        r = (int) randomDouble;
        m = (int) randomDouble2;

        btnFirst.setText(Integer.toString(r));
        btnSecond.setText(Integer.toString(m));

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                r = (int) randomDouble;

                btnFirst.setText(Integer.toString(r));

                if (result == 10 || result == -10) {
                    Intent intent = new Intent(MainActivity.this, CongratulationActivity.class);
                    startActivity(intent);
                } else if (Integer.parseInt(btnFirst.getText().toString()) == Integer.parseInt(btnSecond.getText().toString())) {
                    randomFunc();
                }
                else if (Integer.parseInt(btnFirst.getText().toString()) > Integer.parseInt(btnSecond.getText().toString())) {
                    Toast.makeText(MainActivity.this, "YOU ARE CORRECT", Toast.LENGTH_SHORT).show();
                    result++;
                    String strScore = Integer.toString(result);
                    tvResult.setText("Score: " + strScore);

                    randomFunc();
                }

                else {
                    Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    result--;
                    String strScore = Integer.toString(result);
                    tvResult.setText("Score: " +strScore);
                    randomFunc();
                }
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m = (int) randomDouble2;
                btnSecond.setText(Integer.toString(m));

                if (result == 10 || result == -10) {
                    Intent intent = new Intent(MainActivity.this, CongratulationActivity.class);
                    startActivity(intent);
                }
                else if (Integer.parseInt(btnSecond.getText().toString()) == Integer.parseInt(btnFirst.getText().toString())) {
                    randomFunc();
                }
                else if (Integer.parseInt(btnSecond.getText().toString()) > Integer.parseInt(btnFirst.getText().toString())){
                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    result++;
                    tvResult.setText(String.valueOf(result));
                    String strScore = Integer.toString(result);
                    tvResult.setText("Score: " +strScore);

                    randomFunc();

                }

                else {
                    Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    result--;
                    String strScore = Integer.toString(result);
                    tvResult.setText("Score: " +strScore);
                    randomFunc();
                }
            }
        });
    }

    public void randomFunc() {
            randomDouble =  Math.random();
            randomDouble2 = Math.random();
            randomDouble = randomDouble * 10 + 1;
            randomDouble2 = randomDouble2 * 10 + 1;
            r = (int) randomDouble;
            m = (int) randomDouble2;

            btnFirst.setText(Integer.toString(r));
            btnSecond.setText(Integer.toString(m));
    }
}
