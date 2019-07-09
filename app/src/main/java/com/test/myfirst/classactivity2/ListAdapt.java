package com.test.myfirst.classactivity2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAdapt extends BaseAdapter {
    Context c;
    ArrayList<Pokemon> pok;
    LayoutInflater inflater;

    public ListAdapt(Context c, ArrayList<Pokemon> pok) {
        this.c = c;
        this.pok = pok;
    }

    @Override
    public int getCount() {
        return pok.size();
    }

    @Override
    public Object getItem(int position) {
        return pok.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
        {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.listpokemon,parent,false);
        }

        ImageView img = convertView.findViewById(R.id.img_pokemon);
        TextView txtnm = convertView.findViewById(R.id.txt_pokemon);


        Picasso.get().load(pok.get(position).getPimgurl()).into(img);
        txtnm.setText(pok.get(position).getPname());

        return convertView;
    }
}
