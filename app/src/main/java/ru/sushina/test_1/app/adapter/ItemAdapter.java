package ru.sushina.test_1.app.adapter;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.sushina.test_1.app.NumberFragment;
import ru.sushina.test_1.app.R;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Integer> numList = new ArrayList<>();
    private View view;
    Context mContext;

    public ItemAdapter(Context con) {
        mContext = con;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public ItemViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.itemTextView);
        }

        public void bind(final Integer num) {
            tv.setText(String.valueOf(num));
            int textColor;
            if (num % 2 == 0) {
                textColor = Color.RED;
            } else {
                textColor = Color.BLUE;
            }
            tv.setTextColor(textColor);
            tv.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("tag", "in one item");
                    NumberFragment f = NumberFragment.newInstance(num);
                    FragmentTransaction transaction = ((Activity) mContext).getFragmentManager()
                            .beginTransaction();
                    transaction.replace(R.id.main_layout, f);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
        }
    }

    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(numList.get(position));
    }

    public ItemAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ItemViewHolder(view);
    }

    public void setItems(ArrayList<Integer> nums) {
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
}
