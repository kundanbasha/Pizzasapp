package com.example.karunakar.pizzasapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 9/8/17.
 */

public class OrderAdapter extends ArrayAdapter<Order> implements View.OnClickListener {

    Context mcontext;
    List<Order> orders;

    public OrderAdapter(@NonNull Context context, @NonNull List<Order> objects) {
        super(context, R.layout.row, objects);
        this.mcontext=context;
        this.orders=objects;
    }

    private static class ViewHolder {
        TextView itemsn;
        TextView numofit;
        TextView custsnam;
        TextView custsph;
    }


    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Order expense=getItem(position);

        ViewHolder viewHolder;
        //final View res;

        if (convertView==null){

            viewHolder=new ViewHolder();
            LayoutInflater layoutInflater=LayoutInflater.from(getContext());
            convertView=layoutInflater.inflate(R.layout.row,parent,false);
            viewHolder.itemsn=(TextView)convertView.findViewById(R.id.nameofitem);
            viewHolder.numofit=(TextView)convertView.findViewById(R.id.numofitems);
            viewHolder.custsnam=(TextView)convertView.findViewById(R.id.nameofcust);
            viewHolder.custsph=(TextView)convertView.findViewById(R.id.phnnum);
            //res=convertView;
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)convertView.getTag();
           // res=convertView;
        }
        //lastpos=position;
        viewHolder.itemsn.setText(expense.getItemname());
        viewHolder.numofit.setText(expense.getNumofitems());
        viewHolder.custsnam.setText(expense.getCustname());
        viewHolder.custsph.setText(expense.getCustphn());
        return convertView;

        //return super.getView(position, convertView, parent);
    }
}
