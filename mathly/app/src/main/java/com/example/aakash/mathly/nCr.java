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

public class nCr extends AppCompatActivity {
    TextView resultC;
    Button button_enterC;
    EditText mC;
    EditText nC;
    long hC,gC;
    String yC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_cr);
        mC = (EditText) findViewById(R.id.n);
        nC = (EditText) findViewById(R.id.r);
        resultC = (TextView) findViewById(R.id.tview);
        resultC.setMovementMethod(new ScrollingMovementMethod());
        resultC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager cm = (ClipboardManager) nCr.this.getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(resultC.getText());
                Toast.makeText(nCr.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        resultC.setTextIsSelectable(true);
        button_enterC = (Button) findViewById(R.id.buut);
        button_enterC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    hC = Long.parseLong(mC.getText().toString());
                    gC = Long.parseLong(nC.getText().toString());
                    yC = Long.toString(NCR(hC,gC));
                    resultC.setText(yC);
                }
                catch(NumberFormatException e)
                {   yC = "Error";
                    resultC.setText(yC);
                }
                String C01 = mC.getText().toString();
                String C02 = nC.getText().toString();
                String C1 = C01+"C"+C02;
                History his = new History();
                his.histmake(yC,C1);
                Toast.makeText(nCr.this, "Done",Toast.LENGTH_LONG).show();
            }
        });
    }
    private static long NCR(long x, long y){
        double s = 1;
        long u;
        if(y <= x-y){
            u = y;
        }
        else{
            u = x-y;
        }
        for(long i = 1 ; i<= u ; i=i+1){
            s=s*((x-i+1)*1.0/i*1.0);
        }
        u = Math.round(s);
        return  u;
    }
}
