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
import java.util.ArrayList;
import java.util.List;

public class Prime extends AppCompatActivity {
    TextView resu;
    Button button_enter1;
    EditText n1;
    EditText n2;
    long H,G;
    String Y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);
        n1 = (EditText) findViewById(R.id.editNumber21);
        n2 = (EditText) findViewById(R.id.editNumber22);
        resu = (TextView) findViewById(R.id.textView31);
        resu.setTextIsSelectable(true);
        button_enter1 = (Button) findViewById(R.id.button31);
        resu.setMovementMethod(new ScrollingMovementMethod());
        resu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager cm = (ClipboardManager) Prime.this.getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(resu.getText());
                Toast.makeText(Prime.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        final List<Long> MYLISTs = new ArrayList<Long>();
        button_enter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resu.setText("");
                MYLISTs.clear();
                try{
                    H = Long.parseLong(n1.getText().toString());
                    G = Long.parseLong(n2.getText().toString());
                    List<Long> MYLIST2 = new ArrayList<Long>();
                    MYLIST2 = findprimes(H , G , MYLISTs);
                    int i=0;
                    int u = MYLIST2.size();
                    if(MYLIST2.get(i)==0){
                        Y = resu.getText() + "Number of Primes(s): 0" + "\n";
                    }else{
                        Y = resu.getText() + "Number of Primes(s): " + u + "\n";
                        while(i < u-1){
                            Y = Y + " " + MYLIST2.get(i) + ", ";
                            i=i+1;
                        }
                        Y = Y + " " + MYLIST2.get(i);
                    }
                    resu.setText(Y);
                }
                catch(NumberFormatException e)
                {   Y = "Error";
                    resu.setText(Y);
                }
                String Pr01 = n1.getText().toString();
                String Pr02 = n2.getText().toString();
                String Pr1 = "Primes from "+Pr01+" to "+Pr02;
                History his1 = new History();
                his1.histmake(Y,Pr1);
                Toast.makeText(Prime.this, "Done",Toast.LENGTH_LONG).show();
            }
        });
    }
    private static List<Long> findprimes(long x ,long y, List<Long> myList){
        long s;
        long b =0;
        if(x>y){
            s=x;
            x=y;
            y=s;
        }
        int c;
        for(long i = x; i <= y; i=i+1) {
            c=0;
            if(i%2!=0 & i!=1) {
                long l = (long) Math.pow(i, 0.5);
                for (long j = 3; j <= l; j=j+2) {
                    if (i % j == 0) {
                        c = 1;
                        break;
                    }
                }
                if (c == 0) {
                    myList.add(i);
                }
            }
            else if(i==2){
                myList.add(i);
            }
        }
        if(myList.size() == 0){
            myList.add(b);
        }
        return myList;
    }
}
