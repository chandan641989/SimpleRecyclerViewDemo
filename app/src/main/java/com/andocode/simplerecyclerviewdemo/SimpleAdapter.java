package com.andocode.simplerecyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter {
    private List<SimpleViewModel> models;

    public SimpleAdapter(List<SimpleViewModel> simpleViewModels) {
        models = simpleViewModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SimpleViewHolder) holder).bindData(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item;
    }

    class SimpleViewHolder extends RecyclerView.ViewHolder{
        private TextView simpletext;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            simpletext = (TextView)itemView.findViewById(R.id.tv_simple_text);

        }
        public void bindData(final SimpleViewModel viewModel) {
            simpletext.setText(viewModel.getSimpleText());
        }

    }
}
