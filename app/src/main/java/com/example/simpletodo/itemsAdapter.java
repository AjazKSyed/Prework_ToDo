package com.example.simpletodo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class itemsAdapter extends RecyclerView.Adapter<itemsAdapter.ViewHolder> {

    public interface OnLongClickListener {
        void onItemLongClicked(int position);
    }

    public interface OnClickListener {
        void onItemClicked(int position);
    }
    List<String> items;
    OnLongClickListener longClickListener;
    OnClickListener clickListener;

    public itemsAdapter(List<String> items, OnLongClickListener longClickListener, OnClickListener clickListener) {
        this.items = items;
        this.longClickListener = longClickListener;
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public itemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);

        return new ViewHolder(todoView);
    }

    @Override
    public void onBindViewHolder(@NonNull itemsAdapter.ViewHolder holder, int position) {
        String item = items.get(position);
        holder.bind(item);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // container to provide easy access to views that represent each row of the list

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txItem = itemView.findViewById(android.R.id.text1);

        }

        public void bind(String item) {
            txItem.setText(item);
            txItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemClicked(getAbsoluteAdapterPosition());
                }
            });
            txItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    // notify listener which position was long pressed
                    longClickListener.onItemLongClicked(getAbsoluteAdapterPosition());
                    return true;
                }
            });
        }
    }
}
