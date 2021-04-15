package com.androiddev.travelblogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayListWork();

        listView = findViewById(R.id.ListView);
        PostsAdapter adapter = new PostsAdapter(MainActivity.this,R.layout.card,PostsDB.getPostsArrayList());
        listView.setAdapter(adapter);






    }

    private void arrayListWork() {

        PostsDB.addToPostsArrayList((new Post(R.drawable.life,"Lions in America","This is a post about a business" +
                "visit to Africa with the purpose of studying","22.01.03","Zack Tyler")));

        PostsDB.addToPostsArrayList((new Post(R.drawable.life,"Lions in Africa","This is a post about a business" +
                "visit to Africa with the purpose of studying","22.01.03","Zack Tyler")));

    }
}