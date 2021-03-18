package com.onlinequiz.question.question_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onlinequiz.R;
import com.onlinequiz.model.Description;
import com.onlinequiz.test_sucategory.SubItem;
import com.onlinequiz.test_sucategory.SubItemAdapter;

import java.util.List;

public class DescriptionAdapter  extends RecyclerView.Adapter<DescriptionAdapter.DescriptionViewHolder> {

    private List<Description> descriptionList;

    DescriptionAdapter(List<Description> descriptionList) {
        this.descriptionList = descriptionList;
    }


    @NonNull
    @Override
    public DescriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_sub_item, parent, false);
        return new DescriptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DescriptionViewHolder holder, int position) {
        Description description = descriptionList.get(position);
        holder.tvSubItemTitle.setText(description.getDescriptionName());
    }

    @Override
    public int getItemCount() {
        return descriptionList.size();
    }

    class DescriptionViewHolder extends RecyclerView.ViewHolder {
        TextView tvSubItemTitle;

        DescriptionViewHolder(View itemView) {
            super(itemView);
            tvSubItemTitle = itemView.findViewById(R.id.tv_sub_item_title);
        }
    }
}
