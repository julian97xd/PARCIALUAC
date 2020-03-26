package com.julian.parcialJulian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.julian.parcialJulian.Contact;
import com.julian.parcialandroid.R;

import java.util.List;

public class adapter extends ArrayAdapter<Contact> {

    public adapter(Context context, List<Contact> objects) {
        super(context, 0, objects);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (null == convertView) {
            convertView = inflater.inflate(R.layout.card_item_person, parent, false);
        }

        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtPhone = convertView.findViewById(R.id.txtPhone);
        TextView txtGroup = convertView.findViewById(R.id.txtGroup);

        Contact contact = getItem(position);

        assert contact != null;
        txtName.setText(contact.getName());
        txtPhone.setText(contact.getPhone());
        txtGroup.setText(contact.getGroup());

        return convertView;
    }

}