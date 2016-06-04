package com.octo.android.goodpracticies.actitvityWithLibraries;

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

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by madaaflak on 12/01/2016.
 */
public class EmployeeWLAdapter extends ArrayAdapter<Employee> {
    private Context context;

    static class ViewHolder {
        @Bind(R.id.firstName) TextView firstName;
        @Bind(R.id.lastName) TextView lastName;
        @Bind(R.id.picture)
        ImageView picture;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @Inject
    public EmployeeWLAdapter(Context context) {
        super(context, R.layout.item);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item,parent,false);
            viewHolder = new ViewHolder(convertView);

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
