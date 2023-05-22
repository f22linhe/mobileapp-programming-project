package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Vulkaner> items;
    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;

    RecyclerViewAdapter(Context context, List<Vulkaner> items, OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.items = items;
        this.onClickListener = onClickListener;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recycler_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textview_ID.setText(items.get(position).getID());
        holder.textview_name.setText(items.get(position).getName());
        holder.textview_location.setText(items.get(position).getLocation());
        holder.textview_size.setText(items.get(position).getInteger().toString());
        holder.textview_category.setText(items.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textview_ID;
        TextView textview_name;

        TextView textview_location;

        TextView textview_size;

        TextView textview_category;


        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textview_ID = itemView.findViewById(R.id.textview_ID);
            textview_name = itemView.findViewById(R.id.textview_name);
            textview_location = itemView.findViewById(R.id.textview_location);
            textview_size = itemView.findViewById(R.id.textview_size);
            textview_category = itemView.findViewById(R.id.textview_category);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(items.get(getAdapterPosition()));
        }
    }

    public interface OnClickListener {
        void onClick(Vulkaner item);
    }
}