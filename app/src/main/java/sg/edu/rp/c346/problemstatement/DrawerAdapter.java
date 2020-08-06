package sg.edu.rp.c346.problemstatement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class DrawerAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<String> optionsList;


    public DrawerAdapter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        optionsList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) parent_context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);
        TextView tvName = rowView.findViewById(R.id.textViewTitle);
        ImageView iv = rowView.findViewById(R.id.imageView);

        String currentItem = optionsList.get(position);
        if(position == 0){
            iv.setImageResource(R.drawable.info);
        }else if(position == 1){
            iv.setImageResource(R.drawable.syringe);
        }else if(position == 2){
            iv.setImageResource(R.drawable.anniversary);
        }else if(position == 3){
            iv.setImageResource(R.drawable.aboutus);
        }
        tvName.setText(currentItem);
        return rowView;
    }
}
