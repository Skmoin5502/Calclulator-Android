package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.calci.R.id.Addition;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSub, buttonMul, buttonDiv,buttonClear;
    EditText edittextn1, edittextn2;
    TextView textview;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(Addition);
        buttonSub = findViewById(R.id.Subtraction);
        buttonMul = findViewById(R.id.Multiplication);
        buttonDiv = findViewById(R.id.Division);
        buttonClear = findViewById(R.id.Clear);
        edittextn1 = findViewById(R.id.number1);
        edittextn2 = findViewById(R.id.number2);
        textview = findViewById(R.id.answer);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
    }

    public int getIntFromEditText(EditText editText) {
        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return Integer.parseInt(editText.getText().toString());
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View view) {
        num1 = getIntFromEditText(edittextn1);
        num2 = getIntFromEditText(edittextn2);

        int id = view.getId();
        if (id == R.id.Addition) {
            textview.setText("Answer = " + (num1 + num2));
        } else if (id == R.id.Subtraction) {
            textview.setText("Answer = " + (num1 - num2));
        } else if (id == R.id.Multiplication) {
            textview.setText("Answer = " + (num1 * num2));
        } else if (id == R.id.Division) {
            if (num2 != 0) {
                textview.setText("Answer = " + (num1 / num2));
            } else {
                textview.setText("Cannot divide by zero");
            }
        }
        else if (id == R.id.Clear) {
            edittextn1.setText("");
            edittextn2.setText("");
            textview.setText("");
     }

}



}