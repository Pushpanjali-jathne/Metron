package com.metron.metrontestpj.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.metron.metrontestpj.R;
import com.metron.metrontestpj.model.Employee;

import java.util.ArrayList;


public class EmployeeListAdapter extends BaseAdapter {

    private ArrayList<Employee> _mydata = new ArrayList<Employee>();
    private LayoutInflater _Inflater = null;
    private Context _context;

    public EmployeeListAdapter(Context c, ArrayList<Employee> _data) {
        this._mydata = _data;
        this._context = c;
        this._Inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return _mydata.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final MyHolder holder;

        if (convertView == null) {
            holder = new MyHolder();
            convertView = this._Inflater.inflate(R.layout.employee_item, null);


            holder.tvAddress = convertView.findViewById(R.id.tvAddress);
			holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            holder.tvId = convertView.findViewById(R.id.tvId);
            holder.tvAge = (TextView) convertView.findViewById(R.id.tvAge);

            convertView.setTag(holder);
        } else {
            holder = (MyHolder) convertView.getTag();
        }

        holder.tvAddress.setText(this._mydata.get(position).getAddress());
		holder.tvName.setText(this._mydata.get(position).getName());
		holder.tvId.setText(this._mydata.get(position).getId());
        holder.tvAge.setText(this._mydata.get(position).getAge());


        return convertView;

    }

    class MyHolder {


        TextView tvName, tvId, tvAddress,tvAge;



    }

}
