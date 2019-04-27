package com.example.aakash.mathly;

import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class modularexpo extends AppCompatActivity {
    TextView Res;
    Button Button_Enter;
    EditText m1;
    EditText m2;
    EditText m3;
    long Q,W,E;
    String T;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modularexpo);
        m1 = (EditText) findViewById(R.id.Number41);
        m2 = (EditText) findViewById(R.id.Number42);
        m3 = (EditText) findViewById(R.id.Number43);
        Res = (TextView) findViewById(R.id.textView41);
        Res.setTextIsSelectable(true);
        Res.setMovementMethod(new ScrollingMovementMethod());
        Res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager cm = (ClipboardManager) modularexpo.this.getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(Res.getText());
                Toast.makeText(modularexpo.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        Button_Enter = (Button) findViewById(R.id.button41);
        Button_Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Q = Long.parseLong(m1.getText().toString());
                    W = Long.parseLong(m2.getText().toString());
                    E = Long.parseLong(m3.getText().toString());
                    T = Long.toString(power(Q,W,E));
                    Res.setText(T);
                }
                catch(NumberFormatException e)
                {   T = "Error";
                    Res.setText(T);
                }
                String inv0 = m1.getText().toString();
                String inv1 = m2.getText().toString();
                String inv2 = m1.getText().toString();
                String INV = "ModularExponentiation("+inv0+","+inv1+","+inv2+")";
                History his4 = new History();
                his4.histmake(T,"Modularexpo");
                Toast.makeText(modularexpo.this, "Done",Toast.LENGTH_LONG).show();
            }
        });
    }
        private static long power(long x, long y, long p) {
            long res = 1;
            x = x % p;
            while (y > 0){
                if((y & 1)==1) {
                    res = (res * x) % p;
                }
                y = y >> 1;
                x = (x * x) % p;
            }
            return res;
        }
}
