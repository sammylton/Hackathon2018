package com.example.aakash.mathly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import static java.lang.Math.sqrt;

public class checkfibonacci extends AppCompatActivity {
    TextView reSult;
    Button butter;
    EditText mcf;
    long hcf;
    String ycf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkfibonacci);
        mcf = (EditText) findViewById(R.id.editText001);
        reSult = (TextView) findViewById(R.id.textView001);
        reSult.setTextIsSelectable(true);
        butter = (Button) findViewById(R.id.answerFibonacci);
        butter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    hcf = Long.parseLong(mcf.getText().toString());
                    ycf = Boolean.toString(is_fibonacci(hcf));
                    reSult.setText(ycf);
                }catch(NumberFormatException e){
                    ycf = "Error";
                    reSult.setText(ycf);
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