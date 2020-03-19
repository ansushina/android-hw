package ru.sushina.test_1.app.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.sushina.test_1.app.R;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Integer> numList = new ArrayList<>();

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public ItemViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.itemTextView);
        }

        public void bind(Integer num) {
            tv.setText(String.valueOf(num));
            int textColor;
            if (num%2 == 0) {
                textColor = Color.RED;
            } else {
                textColor = Color.BLUE;
            }
            tv.setTextColor(textColor);
        }

    }

    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(numList.get(position));
    }

    public ItemAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    public void setItems(ArrayList<Integer> nums) {
        numList.addAll(nums);
        notifyDataSetChanged();
    }

    public void clearItems() {
        numList.clear();
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return numList.size();
    }
}
