package com.onlinequiz.category.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onlinequiz.R;
import com.onlinequiz.model.Category;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    private TextView category_title;
    private IOnClickListener iOnClickListener;

    public CategoryViewHolder(@NonNull View itemView, final IOnClickListener iOnClickListener) {
        super(itemView);
        category_title = itemView.findViewById(R.id.category_title);
        this.iOnClickListener = iOnClickListener;
    }

    public interface IOnClickListener{
        void onClick(String categoryId, String categoryTitle);
    }

    public void onBind(Category category){
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClickListener.onClick(category.getCategoryId(),category.getCategoryName());
            }
        });
        category_title.setText(category.getCategoryName());
    }
}
