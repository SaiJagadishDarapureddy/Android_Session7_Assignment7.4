package com.example.admin.sqldisplaydata;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DisplayAdapter extends BaseAdapter {
    private Context mContext;
    //list fields to be displayed
    private ArrayList<String> stafid;
    private ArrayList<String> nama;
    private ArrayList<String> jbt;


    public DisplayAdapter(Context c, ArrayList<String> stafid, ArrayList<String> nama, ArrayList<String> jbt) {
        this.mContext = c;
        //transfer content from database to temporary memory
        this.stafid = stafid;
        this.nama = nama;
        this.jbt = jbt;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return stafid.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int pos, View child, ViewGroup parent) {
        Holder mHolder;
        LayoutInflater layoutInflater;
        if (child == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.display_contact_raw, null);
            mHolder = new Holder();

            //link to TextView
            mHolder.txtstafid = (TextView) child.findViewById(R.id.keyid);
            mHolder.txtnama = (TextView) child.findViewById(R.id.textView);
            mHolder.txtjbt = (TextView) child.findViewById(R.id.textView2);
            child.setTag(mHolder);
        } else {
            mHolder = (Holder) child.getTag();
        }
        //transfer to TextView in screen
        mHolder.txtstafid.setText(stafid.get(pos));
        mHolder.txtnama.setText(nama.get(pos));
        mHolder.txtjbt.setText(jbt.get(pos));


        return child;
    }

    public class Holder {
        TextView txtstafid;
        TextView txtnama;
        TextView txtjbt;
    }

}

