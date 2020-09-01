package com.shailendra.intern.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.shailendra.intern.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shailendra (WackyCodes) on 01/09/2020 07:00
 * ( To Know more, Click : https://linktr.ee/wackycodes )
 */
public class ListAdaptor extends ArrayAdapter<ListModel> {
    private ArrayList<ListModel> dataSet;
    Context mContext;
    private int lastPosition = -1;

    public ListAdaptor(ArrayList <ListModel> data, Context context) {
        super(context, R.layout.list_item_layout, data);
        this.dataSet = data;
        this.mContext=context;

    }
    // View lookup cache
    private static class ViewHolder {
        TextView cat_text;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ListModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item_layout, parent, false);
            viewHolder.cat_text = (TextView) convertView.findViewById(R.id.category_text);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        // Return the completed view to render on screen
        return convertView;
    }

}
