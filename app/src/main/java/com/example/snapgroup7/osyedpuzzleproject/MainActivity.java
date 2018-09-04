package com.example.snapgroup7.osyedpuzzleproject;

import android.graphics.drawable.Drawable;
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





        int[] ar = { -1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 ,1 };
        shuffleArray(ar);
        for (int i = 0;i<ar.length;i++){
            Log.i("hey", String.valueOf(ar[i]));
        }

        int count = 0;
        for (int i =0;i<4;i++)
            for (int j=0;j<4;j++){
                Log.i("count",String.valueOf(count));
                txArr[i][j].setText(String.valueOf(ar[count]));
                count++;
                if(txArr[i][j].getText().equals("-1")){
                    String temp = txArr[3][3].getText().toString();
                    Log.i("innteger",String.valueOf(temp));
                    txArr[3][3].setText("");
                }

            }




    }


    private boolean checkTheGame(){

        for (int i =0;i<4;i++)
            for (int j=0;j<4;j++){
                if(txArr[i][j].getTag().toString() != txArr[i][j].getText().toString())
                    return false;
            }
        return true;
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

    public boolean checkUp(int i , int j){
        if(txArr[i-1][j].getText().equals(""))
            return true;
        return false;
    }

    public boolean checkDown(int i , int j){
        if(txArr[i+1][j].getText().equals(""))
            return true;
        return false;
    }

    public boolean checkRight(int i , int j){
        if(txArr[i][j+1].getText().equals(""))
            return true;
        return false;
    }

    public boolean checkLeft(int i , int j){
        if(txArr[i][j-1].getText().equals(""))
            return true;
        return false;
    }

    /////////////////////////////////////////////////////////////////////////////////



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void swap(int i , int j , int Si , int Sj){
        String temp = txArr[i][j].getText().toString();
        Drawable bTemp = txArr[i] [j].getBackground();
        txArr[i][j].setText("");
        txArr[i][j].setBackground(txArr[i + Si] [j + Sj].getBackground());
        txArr[i + Si] [j + Sj].setText(temp);
        txArr[i + Si] [j + Sj].setBackground(bTemp);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void move(View view) {
        if(view.getTag().equals("12")){
           int i =2;
           int j =3;
           if(checkLeft(i,j))
               swap(i,j,0,-1);
           if(checkUp(i,j))
               swap(i,j,-1,0);
            if(checkDown(i,j))
                swap(i,j,1,0);
        }
        if(view.getTag().equals("8")){
            int i =1;
            int j =3;
            if(checkLeft(i,j))
                swap(i,j,0,-1);
            if(checkUp(i,j))
                swap(i,j,-1,0);
            if(checkDown(i,j))
                swap(i,j,1,0);
        }
        if(view.getTag().equals("16")){
            int i =3;
            int j =3;
            if(checkLeft(i,j))
                swap(i,j,0,-1);
            if(checkUp(i,j))
                swap(i,j,-1,0);
        }
        if(view.getTag().equals("4")){
            int i =0;
            int j =3;
            if(checkLeft(i,j))
                swap(i,j,0,-1);
            if(checkDown(i,j))
                swap(i,j,1,0);
        }
        if(view.getTag().equals("3")){
            Log.i("target",txArr[0][2].getText().toString());
            int i =0;
            int j =2;
            if(checkLeft(i,j))
                swap(i,j,0,-1);
            if(checkDown(i,j))
                swap(i,j,1,0);
            if(checkRight(i,j))
                swap(i,j,0,1);
        }
        if(view.getTag().equals("2")){
            Log.i("target",txArr[0][2].getText().toString());
            int i =0;
            int j =1;
            if(checkLeft(i,j))
                swap(i,j,0,-1);
            if(checkDown(i,j))
                swap(i,j,1,0);
            if(checkRight(i,j))
                swap(i,j,0,1);
        }
        if(view.getTag().equals("1")){
            Log.i("target",txArr[0][2].getText().toString());
            int i =0;
            int j =0;
            if(checkDown(i,j))
                swap(i,j,1,0);
            if(checkRight(i,j))
                swap(i,j,0,1);
        }
        if(view.getTag().equals("5")){
            Log.i("target",txArr[0][2].getText().toString());
            int i =1;
            int j =0;
            if(checkDown(i,j))
                swap(i,j,1,0);
            if(checkRight(i,j))
                swap(i,j,0,1);
            if(checkUp(i,j))
                swap(i,j,-1,0);
        }
        if(view.getTag().equals("6")){
            Log.i("target",txArr[0][2].getText().toString());
            int i =1;
            int j =1;
            if(checkDown(i,j))
                swap(i,j,1,0);
            if(checkRight(i,j))
                swap(i,j,0,1);
            if(checkUp(i,j))
                swap(i,j,-1,0);
            if(checkLeft(i,j))
                swap(i,j,0,-1);
        }
        if(view.getTag().equals("7")){
            Log.i("target",txArr[0][2].getText().toString());
            int i =1;
            int j =2;
            if(checkDown(i,j))
                swap(i,j,1,0);
            if(checkRight(i,j))
                swap(i,j,0,1);
            if(checkUp(i,j))
                swap(i,j,-1,0);
            if(checkLeft(i,j))
                swap(i,j,0,-1);
        }
        if(view.getTag().equals("9")){
            Log.i("target",txArr[0][2].getText().toString());
            int i =2;
            int j =0;
            if(checkDown(i,j))
                swap(i,j,1,0);
            if(checkRight(i,j))
                swap(i,j,0,1);
            if(checkUp(i,j))
                swap(i,j,-1,0);
        }
        if(view.getTag().equals("10")){
            Log.i("target",txArr[0][2].getText().toString());
            int i =2;
            int j =1;
            if(checkDown(i,j))
                swap(i,j,1,0);
            if(checkRight(i,j))
                swap(i,j,0,1);
            if(checkUp(i,j))
                swap(i,j,-1,0);
            if(checkLeft(i,j))
                swap(i,j,0,-1);
        }
        if(view.getTag().equals("11")){
            Log.i("target",txArr[0][2].getText().toString());
            int i =2;
            int j =2;
            if(checkDown(i,j))
                swap(i,j,1,0);
            if(checkRight(i,j))
                swap(i,j,0,1);
            if(checkUp(i,j))
                swap(i,j,-1,0);
            if(checkLeft(i,j))
                swap(i,j,0,-1);
        }
        if(view.getTag().equals("13")){
            Log.i("target",txArr[0][2].getText().toString());
            int i =3;
            int j =0;
            if(checkRight(i,j))
                swap(i,j,0,1);
            if(checkUp(i,j))
                swap(i,j,-1,0);
        }
        if(view.getTag().equals("14")){
            Log.i("target",txArr[0][2].getText().toString());
            int i =3;
            int j =1;
            if(checkRight(i,j))
                swap(i,j,0,1);
            if(checkUp(i,j))
                swap(i,j,-1,0);
            if(checkLeft(i,j))
                swap(i,j,0,-1);
        }
        if(view.getTag().equals("15")){
            Log.i("target",txArr[0][2].getText().toString());
            int i =3;
            int j =2;
            if(checkRight(i,j))
                swap(i,j,0,1);
            if(checkUp(i,j))
                swap(i,j,-1,0);
            if(checkLeft(i,j))
                swap(i,j,0,-1);
        }

        if(checkTheGame())
            Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"next step",Toast.LENGTH_SHORT).show();


    }
}
