package com.example.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    View view;
    private ConstraintLayout conlay;
    private Switch switch1;
    private EditText editTextTextPersonName7;
    private TextInputEditText text_input_;
    private EditText editTextTextPersonName2;
    private EditText editTextTextPersonName3;
    private Button button;
    private TextView textView7;
    private TextView textView9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switch1 = findViewById(R.id.switch1);
        editTextTextPersonName7 = findViewById(R.id.editTextTextPersonName7);
        text_input_ = findViewById(R.id.text_input_);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);
        button = findViewById(R.id.button);
        textView7 = findViewById(R.id.textView7);
        textView9 = findViewById(R.id.textView9);
        conlay=findViewById(R.id.conlay);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
//                    view = new View(MainActivity.this);
                    conlay.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.pink));
                }
                else{
                    conlay.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.light_blue));

                    }
                    }
     });


        button.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                double bmi;
                String a=text_input_.getText().toString();
                int age=Integer.parseInt(a);

                String s= editTextTextPersonName2.getText().toString();
                double hei=Double.parseDouble(s);
                double h=0.0001*hei*hei;

                String s1=editTextTextPersonName3.getText().toString();
                double wei=Double.parseDouble(s1);
                if(age==0)
                {Toast.makeText(MainActivity.this, "Please enter valid age", Toast.LENGTH_SHORT).show();}
                else
                {
                    bmi=wei/h ;

                    textView7.setText(""+bmi);
                    if(bmi<18.5)
                        textView9.setText("Underweight");
                    else if(bmi>=18.5 && bmi<=24.9)
                        textView9.setText("Normal Weight");
                    else if(bmi>=25 && bmi<=29.9)
                        textView9.setText("Overweight");
                    else
                        textView9.setText("Obese");}
            }
        });





    }
}
