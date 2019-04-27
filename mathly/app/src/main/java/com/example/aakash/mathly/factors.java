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
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class factors extends AppCompatActivity {
    TextView Result;
    Button button2_enter;
    EditText q;
    long w;
    String z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factors);
        q = (EditText) findViewById(R.id.Number1);
        Result = (TextView) findViewById(R.id.textView2);
        Result.setTextIsSelectable(true);
        final List<Long> MYLIST = new ArrayList<Long>();
        final List<String> MYLT = new ArrayList<String>();
        button2_enter = (Button) findViewById(R.id.button2);
        Result.setMovementMethod(new ScrollingMovementMethod());
        Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager cm = (ClipboardManager) factors.this.getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(Result.getText());
                Toast.makeText(factors.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        button2_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result.setText("");
                MYLIST.clear();
                MYLT.clear();
                try{
                    w = Long.parseLong(q.getText().toString());
                    List<Long> MYLIST1 = new ArrayList<Long>();
                    MYLIST1 = findfactors(w , MYLIST);
                    List<String> MYLIT1 = new ArrayList<String>();
                    MYLIT1 = prfact(w , MYLT);
                    int i=0;
                    int u = MYLIST1.size();
                    int j=0;
                    int vj = MYLIT1.size();
                    z = Result.getText() + "Number of Factors: " + u + "\n";
                    while(i < u-1){
                        z = z + MYLIST1.get(i) + " , ";
                        i=i+1;
                    }
                    z = z + MYLIST1.get(i);
                    z = z + "\n" + "Prime Factorisation:" + "\n";
                    while(j < vj-1){
                        z = z + MYLIT1.get(j) + " , ";
                        j=j+1;
                    }
                    z = z + MYLIT1.get(j);
                    Result.setText(z);
                }
                catch(NumberFormatException e)
                {   z = "Error";
                    Result.setText(z);
                }
                String in1 = q.getText().toString();
                String INV0 = "Factors of "+ in1;
                History his3 = new History();
                his3.histmake(z,INV0);
                Toast.makeText(factors.this, "Done",Toast.LENGTH_LONG).show();
            }
        });
    }
    private static List<Long> findfactors( long x , List<Long> myList){
        long l = (long) Math.pow(x,0.5);
        for(long i = 1; i < l; ++i) {
            if (x % i == 0) {
                myList.add(i);
                myList.add(x/i);
            }
        }
        if (x%l==0){
            myList.add(l);
        }
        Collections.sort(myList);
        return myList;
    }
    private static List<String> prfact(long x2 , List<String> myList2){
        //long l = (long) Math.pow(x2,0.5);
        double s = x2 ;
        int j = 2;
        int k,a;
        while (s!=1.0) {
            k=0;
            while(s%j==0){
                s = s/j;
                k=k+1;
            }
            if(k!=0) {
                myList2.add(Integer.toString(j) + "^(" + Integer.toString(k) + ")");
            }
            j=j+1;
        }
        return myList2;
    }
}
