package com.example.alireza.myapplicationfirst;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdpter extends RecyclerView.Adapter <MyAdpter.MyViewHolder> {


    private List<Task> tasks;

    MyAdpter(List<Task> tasks){  // saveing ref from tasks from input

        if (tasks == null){

            //**** this part must throws exception.
        }
        else {
            this.tasks = tasks;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        MyViewHolder(View itemView){
            super(itemView);
        }

    }
}
