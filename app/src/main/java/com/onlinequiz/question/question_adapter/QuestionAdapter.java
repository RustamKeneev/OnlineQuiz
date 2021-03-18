package com.onlinequiz.question.question_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.onlinequiz.R;
import com.onlinequiz.model.Description;
import com.onlinequiz.model.Question;
import com.onlinequiz.test_sucategory.Item;
import com.onlinequiz.test_sucategory.ItemAdapter;
import com.onlinequiz.test_sucategory.SubItemAdapter;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<Question> itemList;

    public QuestionAdapter(List<Question> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,
                parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Question item = itemList.get(position);
        holder.tvItemTitle.setText(item.getSubCategoryName());

        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                holder.rvSubItem.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(item.getDescriptionList().size());

        // Create sub item view adapter
        DescriptionAdapter descriptionAdapter = new DescriptionAdapter(item.getDescriptionList());

        holder.rvSubItem.setLayoutManager(layoutManager);
        holder.rvSubItem.setAdapter(descriptionAdapter);
        holder.rvSubItem.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder{
        private TextView tvItemTitle;
        private RecyclerView rvSubItem;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemTitle = itemView.findViewById(R.id.tv_item_title);
            rvSubItem = itemView.findViewById(R.id.rv_sub_item);
        }
    }
}
