package com.example.alireza.myapplicationfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Collection;
import java.util.Collections;
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

        /// sort must be done here....

        taskList.add(new Task("not def",1));
        taskList.add(new Task("not def", "2018" ,"12" ,"3" , "12" ,"30" ,"0",1));
        taskList.add(new Task("not def", "2014" ,"12" ,"3" , "12" ,"30" ,"0",1));
        taskList.add(new Task("other", "2019" ,"12" ,"3" , "12" ,"30" ,"0",2));
        taskList.add(new Task("high", "2018" ,"12" ,"3" , "12" ,"30" ,"0",3));
        taskList.add(new Task("high", "2018" ,"12" ,"3" , "11" ,"30" ,"0",3));
        taskList.add(new Task("high",3));
        taskList.add(new Task("other", "2018" ,"12" ,"3" , "12" ,"30" ,"0",2));
        taskList.add(new Task("low", "2018" ,"12" ,"3" , "12" ,"30" ,"0",5));
        taskList.add(new Task("low", "2019" ,"12" ,"3" , "12" ,"30" ,"0",5));
        taskList.add(new Task("low", "2018" ,"12" ,"3" , "11" ,"30" ,"0",5));



        //taskList.add(task);
        Collections.sort(taskList);  // sorting ba time ha.



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
