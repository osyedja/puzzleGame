package com.example.snapgroup7.osyedpuzzleproject;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {


    GridView GridViewNu;
    TextView tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9,tx10,tx11,tx12,tx13,tx14,tx15,tx16;
    LinearLayout ly;
    TextView[][] txArr;
    private final int TEXTVIEW_ID[][] = {{R.id.tx1, R.id.tx2, R.id.tx3, R.id.tx4},
    {R.id.tx5, R.id.tx6, R.id.tx7, R.id.tx8},
    {R.id.tx9 ,R.id.tx10, R.id.tx11, R.id.tx12},
    {R.id.tx13, R.id.tx14, R.id.tx15, R.id.tx16}};


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txArr = new TextView[4][4];

        for (int i =0;i<4;i++)
            for (int j=0;j<4;j++){
            txArr[i][j] = (TextView) findViewById(TEXTVIEW_ID[i][j]);
            }

        ly = (LinearLayout)findViewById(R.id.ll1);





        int[] ar = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        shuffleArray(ar);
        for (int i = 0;i<ar.length;i++){
            Log.i("hey", String.valueOf(ar[i]));
        }

        int count = 0;
        for (int i =0;i<4;i++)
            for (int j=0;j<4;j++){
                Log.i("count",String.valueOf(ar[count]));
                txArr[i][j].setText(ar[count]);
                count++;
                if(txArr[i][j].getText().equals("-1")){
                    txArr[i][j].setVisibility(View.GONE);
                }

            }




    }


    private void insertToGame(int[]ar){

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void shuffleArray(int[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public void move(View view) {
        if(view.getTag().equals("12")){
            String temp = tx12.getText().toString();
            tx12.setText(tx16.getText());
            tx16.setText(temp);
        }
        else{
            Toast.makeText(this,"nooo",Toast.LENGTH_SHORT).show();
        }
    }
}
