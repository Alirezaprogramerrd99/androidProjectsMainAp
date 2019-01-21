package com.example.alireza.myapplicationfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    RecyclerView myRecView;
    static List<Task> taskList;
    MyAdpter adpter;

    public static boolean prepareData(Task task) {

        if (taskList == null) {  // if it was empty list create it
            taskList = new Vector<Task>();
        }

        if (taskList.contains(task)){
            return false;
        }

        taskList.add(task);

//        taskList.add(new Task("not def",1));
//        taskList.add(new Task("not def", "2018" ,"12" ,"3" , "12" ,"30" ,"0",1));
//        taskList.add(new Task("not def", "2014" ,"12" ,"3" , "12" ,"30" ,"0",1));
//        taskList.add(new Task("other", "2019" ,"12" ,"3" , "12" ,"30" ,"0",2));
//        taskList.add(new Task("high", "2018" ,"12" ,"3" , "12" ,"30" ,"0",3));
//        taskList.add(new Task("high", "2018" ,"12" ,"3" , "11" ,"30" ,"0",3));
//        taskList.add(new Task("high",3));
//        taskList.add(new Task("other", "2018" ,"12" ,"3" , "12" ,"30" ,"0",2));
//        taskList.add(new Task("low", "2018" ,"12" ,"3" , "12" ,"30" ,"0",5));
//        taskList.add(new Task("low", "2019" ,"12" ,"3" , "12" ,"30" ,"0",5));
//        taskList.add(new Task("low", "2018" ,"12" ,"3" , "11" ,"30" ,"0",5));

        //taskList.add(task);
        Collections.sort(taskList);  // sorting ba time ha.
        return true;
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
        //prepareData();
        showData();
    }
}