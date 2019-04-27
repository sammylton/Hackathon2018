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

public class modularmultinverse extends AppCompatActivity {
    TextView Resul;
    Button Button_enter;
    EditText M1;
    EditText M2;
    long A,S;
    String U;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modularmultinverse);
        M1 = (EditText) findViewById(R.id.Number51);
        M2 = (EditText) findViewById(R.id.Number52);
        Resul = (TextView) findViewById(R.id.textView51);
        Resul.setTextIsSelectable(true);
        Resul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager cm = (ClipboardManager) modularmultinverse.this.getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(Resul.getText());
                Toast.makeText(modularmultinverse.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        Resul.setMovementMethod(new ScrollingMovementMethod());
        Button_enter = (Button) findViewById(R.id.button51);
        Button_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    A = Long.parseLong(M1.getText().toString());
                    S = Long.parseLong(M2.getText().toString());
                    U = Long.toString(modInverse(A,S));
                    Resul.setText(U);
                }
                catch(NumberFormatException e)
                {   U = "Error";
                    Resul.setText(U);
                }
                String inve0 = M1.getText().toString();
                String inve1 = M2.getText().toString();
                String INV = "ModularMultiInverse("+inve0+","+inve1+")";
                History his5 = new History();
                his5.histmake(U,INV);
                Toast.makeText(modularmultinverse.this, "Done",Toast.LENGTH_LONG).show();
            }
        });
    }
    private static long modInverse(long a, long m){
        a = a % m;
        for (long x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return 1;
    }
}
