package ru.sushina.test_1.app.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.sushina.test_1.app.OnNumberClickListener;
import ru.sushina.test_1.app.R;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Integer> numList;
    private final OnNumberClickListener mListener;

    public ItemAdapter(@NonNull OnNumberClickListener listener) {
        mListener = listener;
    }

    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(numList.get(position));
    }

    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    public void setItems(@NonNull List<Integer> nums) {
        numList = nums;
        notifyDataSetChanged();
    }

    public void clearItems() {
        numList.clear();
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return numList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.itemTextView);
        }

        public void bind(final Integer num) {
            textView.setText(String.valueOf(num));
            int textColor;
            if (num % 2 == 0) {
                textColor = Color.RED;
            } else {
                textColor = Color.BLUE;
            }
            textView.setTextColor(textColor);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClickNumber(num);
                }
            });
        }
    }
}
