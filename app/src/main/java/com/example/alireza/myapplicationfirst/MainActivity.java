package com.example.alireza.myapplicationfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    RecyclerView myRecView;
    List<Task> taskList;
    MyAdpter adpter;

    void prepareData() {

        if (taskList == null) {  // if it was empty list create it
            taskList = new Vector<Task>();
        } else { // else it was full clear it.
            taskList.clear();
        }

        taskList.add(new Task("Important", "2018.12.3"));
        taskList.add(new Task("dededed", "2015.3.5"));
        taskList.add(new Task("Important", "2018.12.3"));
        taskList.add(new Task("dededed", "2015.3.5"));
        taskList.add(new Task("Important", "2018.12.3"));
        taskList.add(new Task("dededed", "2015.3.5"));
        taskList.add(new Task("Important", "2018.12.3"));
        taskList.add(new Task("dededed", "2015.3.5"));
        taskList.add(new Task("Important", "2018.12.3"));
        taskList.add(new Task("dededed", "2015.3.5"));
        taskList.add(new Task("Important", "2018.12.3"));
        taskList.add(new Task("dededed", "2015.3.5"));
    }

    void showData() {

        adpter = new MyAdpter(taskList);
        myRecView.setLayoutManager(new LinearLayoutManager(this)); // this acticity
        myRecView.setItemAnimator(new DefaultItemAnimator());
        myRecView.setAdapter(adpter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecView = (RecyclerView) findViewById(R.id.recylerview);
        prepareData();
        showData();
    }
}
