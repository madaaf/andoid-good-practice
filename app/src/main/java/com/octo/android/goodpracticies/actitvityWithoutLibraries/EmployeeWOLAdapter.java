package com.octo.android.goodpracticies.actitvityWithoutLibraries;

import android.content.Context;

import com.octo.android.goodpracticies.BuildConfig;
import com.octo.android.goodpracticies.R;
import com.octo.android.goodpracticies.model.Employee;
import com.squareup.picasso.Picasso;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

/**
 * Created by madaaflak on 12/01/2016.
 */

public class EmployeeWOLAdapter extends ArrayAdapter<Employee>{
    private Context context;

    /*
        Use ViewHolder to store each of the component views inside the tag fields of the Layout
        Like this, we can immediately access them without the need to look them up repeatedly
     */
    static class ViewHolder {
        TextView firstName;
        TextView lastName;
        ImageView picture;
    }

    @Inject
    public EmployeeWOLAdapter(Context context) {
        super(context, R.layout.item);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item,parent,false);
            // populate the viewholder and store it inside the layout
            viewHolder = new ViewHolder();
            viewHolder.firstName = (TextView) convertView.findViewById(R.id.firstName);
            viewHolder.lastName = (TextView) convertView.findViewById(R.id.lastName);
            viewHolder.picture = (ImageView) convertView.findViewById(R.id.picture);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Employee item = getItem(position);
        viewHolder.firstName.setText(item.getFistName());
        viewHolder.lastName.setText(item.getLastName());
        Picasso.with(context).load(BuildConfig.rootUrl + item.getPicture()).fit().centerInside().into(viewHolder.picture);
        return convertView;
    }
}
