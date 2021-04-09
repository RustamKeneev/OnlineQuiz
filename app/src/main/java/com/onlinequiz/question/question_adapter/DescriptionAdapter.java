package com.onlinequiz.question.question_adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.onlinequiz.R;
import com.onlinequiz.model.Description;
import com.onlinequiz.model.OptionList;
import com.onlinequiz.model.Question;
import com.onlinequiz.question.QuestionViewModel;
import com.onlinequiz.test_sucategory.SubItem;
import com.onlinequiz.test_sucategory.SubItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class DescriptionAdapter  extends RecyclerView.Adapter<DescriptionAdapter.DescriptionViewHolder> {

    private List<Description> descriptionList;
    private QuestionViewModel questionViewModel;
    private LifecycleOwner lifecycleOwner;
    private OnCheckedListener listener;

    DescriptionAdapter(List<Description> descriptionList, QuestionViewModel questionViewModel, LifecycleOwner lifecycleOwner,OnCheckedListener listener) {
        this.descriptionList = descriptionList;
        this.questionViewModel = questionViewModel;
        this.lifecycleOwner = lifecycleOwner;
        this.listener = listener;
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
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    listener.checked(isChecked,descriptionList.get(position), description.getId());
//                    questionViewModel.optionlistData.observe(lifecycleOwner, new Observer<List<OptionList>>() {
//                        @Override
//                        public void onChanged(List<OptionList> optionLists) {
////                            OptionList localModel;
////                            for (int i = 0; i < optionLists.size(); i++) {
////                                for (int j = 0; j < optionLists.get(i).getDescriptionList().size(); j++) {
////                                    if (optionLists.get(i).getDescriptionList().get(j).getId() == Integer.parseInt(description.getId())){
////                                        localModel = optionLists.get(i).getDescriptionList().get(j);
//////                                        Toast.makeText(holder.itemView.getContext(),  Toast.LENGTH_SHORT).show();
////                                        Log.d("ololo", optionLists.get(i).getOptionsPostAnswers() + "a");
////                                        break;
////                                    }
////                                }
//////                                if (optionLists.get(i).get == Integer.parseInt(description.getId())){
//////                                    localModel = optionLists.get(i);
//////                                    Toast.makeText(holder.itemView.getContext(), localModel.getOptionsPostAnswers(), Toast.LENGTH_SHORT).show();
//////                                }
////                            }
//
//                        }
//                    });

                }else {
                    listener.checked(isChecked,descriptionList.get(position), description.getId());
                }
            }
        });
    }
    

    
    public void setOnCheckedListener(OnCheckedListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return descriptionList.size();
    }

    class DescriptionViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView tvSubItemTitle;

        DescriptionViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.description_checkbox);
            tvSubItemTitle = itemView.findViewById(R.id.tv_sub_item_title);
        }
    }
}
