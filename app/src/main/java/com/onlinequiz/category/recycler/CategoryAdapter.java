package com.onlinequiz.category.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onlinequiz.R;
import com.onlinequiz.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private CategoryViewHolder.IOnClickListener iOnClickListener;
    private List<Category> mCategories = new ArrayList<>();

    public CategoryAdapter(CategoryViewHolder.IOnClickListener iOnClickListener) {
        this.iOnClickListener = iOnClickListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new CategoryViewHolder(view,iOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.onBind(mCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public void setData(List<Category> categories){
        mCategories.clear();
        mCategories.addAll(categories);
        notifyDataSetChanged();
    }
}
