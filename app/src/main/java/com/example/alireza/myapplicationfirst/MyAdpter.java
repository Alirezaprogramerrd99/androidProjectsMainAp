package com.example.alireza.myapplicationfirst;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
// addpter part.

public class MyAdpter extends RecyclerView.Adapter <MyAdpter.MyViewHolder> {


    private List<Task> tasks;

    MyAdpter(List<Task> tasks){  // saveing ref from tasks from input

        if (tasks == null){

            //**** this part must throws exception.//
        }
        else {
            this.tasks = tasks;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
       View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_tasks_list1, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        myViewHolder.bind(tasks.get(position));  // index ha ro set mekhoonee. to view holder

        // position is a index in list.

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        AppCompatTextView massageTextView;
        AppCompatTextView DateTextView;  // inja bayad baraye eleman ha digar field dar nazar

        // gerfete shavad.
        MyViewHolder(View itemView){
            super(itemView);
            massageTextView = itemView.findViewById(R.id.masssageTxt); // ref ing massage txt to xml code.
            DateTextView = itemView.findViewById(R.id.DateTxt);
        }

        public void bind(Task task){  // field ha ro por mikoneee. toye on bind view holder

            massageTextView.setText(task.getMassage());
            DateTextView.setText(task.getDate());

        }
    }
}
