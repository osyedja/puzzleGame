package com.example.snapgroup7.osyedpuzzleproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NumberAdapter extends BaseAdapter {

    ArrayList<Number>  numberList;
    Context context;

    public NumberAdapter(Context context, ArrayList<Number> numberList){
        this.context = context;
        this.numberList = numberList;
    }

    @Override
    public int getCount() {
        return numberList.size();
    }

    @Override
    public Object getItem(int i) {
        return numberList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.number,parent,false);

        TextView tv = (TextView)listItem.findViewById(R.id.numText);
        tv.setText(numberList.get(i).getNumberString());

        return tv;
    }
}