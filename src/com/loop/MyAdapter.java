package com.loop;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{

	private  LayoutInflater inflater;
	List<WishData> list;

	public MyAdapter(Context context, List<WishData> list){
		inflater = LayoutInflater.from(context);
		this.list = list;
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.list_item, null);
			holder.title = (TextView) convertView.findViewById(R.id.listItem_Title);
			holder.subTitle = (TextView) convertView.findViewById(R.id.listItem_Subtitle);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.title.setText(String.valueOf(list.get(position).getWishName()));
		holder.subTitle.setText(String.valueOf(list.get(position).getWishNote()));
		
		return convertView;
	}
	
	public class ViewHolder {
		TextView title;
		TextView subTitle;
	}

}
