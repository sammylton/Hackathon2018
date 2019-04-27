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

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

public class BigFactorial extends AppCompatActivity {
    TextView ST;
    EditText ET;
    Button but1;
    String fac;
    int ET1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_factorial);
        ST = (TextView) findViewById(R.id.txtV);
        ET = (EditText) findViewById(R.id.etxtV);
        but1 = (Button) findViewById(R.id.Butt);
        ST.setMovementMethod(new ScrollingMovementMethod());
        ST.setTextIsSelectable(true);
        ST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager cm = (ClipboardManager) BigFactorial.this.getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(ST.getText());
                Toast.makeText(BigFactorial.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ET1 = Integer.parseInt(ET.getText().toString());
                    fac = factorial(ET1).toString();
                    ST.setText(fac);
                }catch(NumberFormatException e){
                    fac = "Error";
                    ST.setText(fac);
                }
                String i1 = ET.getText().toString();
                String IV0 = "BigFactorial of "+ i1;
                History hiso = new History();
                hiso.histmake(fac,IV0);
                Toast.makeText(BigFactorial.this, "Done",Toast.LENGTH_LONG).show();
            }
        });
    }
    private static BigInteger factorial(int N) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= N; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }
}
