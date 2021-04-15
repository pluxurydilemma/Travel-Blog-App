package com.androiddev.travelblogapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedView extends AppCompatActivity {
    int position;
    ImageView imageView;
    TextView MainTitle,MainTheme,Date,Author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);
        getSupportActionBar().setTitle("Detailed View");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MainTitle = (TextView) findViewById(R.id.MainTitleDetailed);
        MainTheme = (TextView) findViewById(R.id.MainTheme);
        Date = (TextView) findViewById(R.id.DateDetailed);
        imageView = (ImageView) findViewById(R.id.imageView2);
        Author = (TextView) findViewById(R.id.author);
        MainTitle.setText(PostsDB.getPostsArrayList().get(position).getMainTitle());
        MainTheme.setText(PostsDB.getPostsArrayList().get(position).getMainTheme());
        Date.setText(PostsDB.getPostsArrayList().get(position).getDate());
        Author.setText(PostsDB.getPostsArrayList().get(position).getAuthor());
        imageView.setImageResource(PostsDB.getPostsArrayList().get(position).getImageResource());






        position = 0;
        Intent intent = getIntent();
        String temp = intent.getStringExtra("post");
        position = Integer.parseInt(temp);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.more:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Web site Link");
                String shareMessage= "\nTo view other posts visit our web site\n\n";
                shareMessage = shareMessage + "https://www.travelblog.org/" + BuildConfig.APPLICATION_ID +"\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
        }
        return super.onOptionsItemSelected(item);
    }
}