package com.example.karunakar.pizzasapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by root on 8/8/17.
 */

public class Items extends BaseAdapter {

    private Context mcontext;
    private final int[] itemid;
    private final String[] itemname;

    public Items(Context mcontext, int[] itemid, String[] itemname) {
        this.mcontext = mcontext;
        this.itemid = itemid;
        this.itemname = itemname;
    }


    @Override
    public int getCount() {
        return itemid.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View items;
        LayoutInflater layoutInflater=(LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            items=new View(mcontext);
            items=layoutInflater.inflate(R.layout.grid,null);
            TextView name=(TextView)items.findViewById(R.id.itemname);
            ImageView img=(ImageView)items.findViewById(R.id.itemimage);
            name.setText(itemname[position]);
            img.setImageResource(itemid[position]);
        }
        else{

            items=(View)convertView;
        }

        return items;
    }
}
