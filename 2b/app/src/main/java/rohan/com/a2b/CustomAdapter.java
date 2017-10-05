package rohan.com.a2b;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rohan on 05-10-2017.
 */

public class CustomAdapter extends BaseAdapter{

    Context context;
    ArrayList<Model> feedList;
    public CustomAdapter(Context context, ArrayList<Model> data) {
        this.context = context;
        this.feedList = data;
    }

    @Override
    public int getCount() {
        return feedList.size();
    }

    @Override
    public Model getItem(int i) {
        return feedList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int pos, View view, ViewGroup viewGroup) {
        final Holder holder;
        Model data = MainActivity.data.get(pos);


        if(view == null)
        {
            holder = new Holder();

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_item_row,null);

            holder.checkBox = view.findViewById(R.id.check_box);
            holder.txtPrice = view.findViewById(R.id.txtPrice);
            holder.quant = view.findViewById(R.id.spinner);
        }else{
            holder = (Holder) view.getTag();
        }


        holder.checkBox.setText(data.getName());
        holder.txtPrice.setText(""+data.getPrice());
        holder.quant.setEnabled(false);

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(holder.checkBox.isChecked()){
                    holder.quant.setEnabled(true);
                    MainActivity.data.get(pos).setSelected(true);
                }
                if(!holder.checkBox.isChecked())
                {
                    holder.quant.setEnabled(false);
                    holder.quant.setSelection(0);
                    MainActivity.data.get(pos).setSelected(false);
                }
            }
        });
        holder.quant.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity.data.get(pos).setQuant(holder.quant.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                MainActivity.data.get(pos).setQuant(0);
            }
        });
        return view;
    }

    private class Holder{
        CheckBox checkBox;
        TextView txtPrice;
        Spinner quant;
    }
}
