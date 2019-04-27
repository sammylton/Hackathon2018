package com.example.samee.ramanujan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.sqrt;

public class Check_Fibbonacci extends AppCompatActivity {
    TextView result;
    Button button_enter;
    EditText m;
    long h;
    String y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check__fibbonacci);
        m = (EditText) findViewById(R.id.editText1);
        result = (TextView) findViewById(R.id.textView1);
        button_enter = (Button) findViewById(R.id.answerFibonacci);
        button_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    h = Long.parseLong(m.getText().toString());
                    y = Boolean.toString(is_fibonacci(h));
                    result.setText(y);
                }catch(NumberFormatException e){
                    y = "Error";
                    result.setText(y);
                }
                /*History his = new History();
                his.histmake(y);*/
            }
        });
    }


    private static boolean is_fibonacci( long n){
        double phi = 0.5 + 0.5*sqrt(5.0);
        double a = phi*n;
        return n == 0 || Math.abs(Math.round(a) - a) < (1.0/n);
    }
}
