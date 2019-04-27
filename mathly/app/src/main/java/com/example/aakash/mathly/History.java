package com.example.aakash.mathly;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static com.example.aakash.mathly.MainActivity.HistoryList;

public class History extends AppCompatActivity {
    TextView txtv;
    String O;
    static final int READ_BLOCK_SIZE = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtv = (TextView) findViewById(R.id.hist);
        txtv.setTextIsSelectable(true);
        int LEN = HistoryList.size();
        int i = 0;
        while (i < LEN) {
            O = txtv.getText() + " " + HistoryList.get(i) + "\n" + HistoryList.get(i + 1) + "\n" + " " + HistoryList.get(i + 2) + "\n" + "\n";
            txtv.setText(O);
            i = i + 3;
        }
        try {
            FileInputStream fileIn=openFileInput("mathlyhistory.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);
            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;
            while ((charRead=InputRead.read(inputBuffer))>0) {
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s = s + readstring;
            }
            InputRead.close();
            txtv.setText(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileOutputStream fileout=openFileOutput("mathlyhistory.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(O);
            outputWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtv.setText("");
                HistoryList.clear();
                File dir = getFilesDir();
                File file = new File(dir, "mathlyhistory.txt");
                boolean deleted = file.delete();
            }
        });
    }
    public void histmake(String HIS , String HIS1){
        String DT;
        Date currentTime = Calendar.getInstance().getTime();
        DT = currentTime.toString();
        HistoryList.add(DT);
        HistoryList.add(HIS1);
        HistoryList.add(HIS);
    }
}
