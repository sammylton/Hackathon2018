package com.example.aakash.mathly;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class gcd extends AppCompatActivity {
    TextView result;
    Button button_enter;
    EditText m;
    EditText n;
    long h,g;
    String y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcd);
        m = (EditText) findViewById(R.id.editNumber1);
        n = (EditText) findViewById(R.id.editNumber2);
        result = (TextView) findViewById(R.id.textView);
        result.setMovementMethod(new ScrollingMovementMethod());
        result.setTextIsSelectable(true);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager cm = (ClipboardManager) gcd.this.getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(result.getText());
                Toast.makeText(gcd.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        button_enter = (Button) findViewById(R.id.button);
        button_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    h = Long.parseLong(m.getText().toString());
                    g = Long.parseLong(n.getText().toString());
                    y = Long.toString(findgcd(h,g));
                    result.setText(y);
                }
                catch(NumberFormatException e)
                {   y = "Error";
                    result.setText(y);
                }
                String gc = m.getText().toString();
                String gc2 = n.getText().toString();
                String GcD = "GCD("+gc+","+gc2+")" ;
                History his = new History();
                his.histmake(y,GcD);
                Toast.makeText(gcd.this, "Done",Toast.LENGTH_LONG).show();
            }
        });

    }
    private static long findgcd( long a, long b){
        if(a<b){
            long k =a;
            a = b;
            b = k;
        }
        long q = a;
        long s = a;
        long t = b;
        while (q > 0) {
            q = q % t;
            if (q == 0) {
                q = q + t;
                break;
            }
            s = t;
            t = q;
            q = s;
        }
        return q;
    }
}

