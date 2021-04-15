package com.androiddev.travelblogapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import java.util.List;

public class PostsAdapter extends ArrayAdapter<Post> {
    Context context;
    int resource;
    public PostsAdapter(@NonNull Context context, int resource, @NonNull List<Post> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        {
            int ImageResource = getItem(position).getImageResource();
            String MainTitle = getItem(position).getMainTitle();
            String MainTheme = getItem(position).getMainTheme();
            String Date = getItem(position).getDate();
            String Author = getItem(position).getAuthor();


            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.card,parent,false);


            TextView mainTitle = convertView.findViewById(R.id.MainTitle);
            TextView mainTheme = convertView.findViewById(R.id.Theme);
            ImageView MainPhoto = convertView.findViewById(R.id.imageView);
            TextView date = convertView.findViewById(R.id.date);
            CardView cardView = convertView.findViewById(R.id.cardView);

            mainTitle.setText(MainTitle);
            mainTheme.setText(MainTheme);
            MainPhoto.setImageResource(ImageResource);
            date.setText(Date);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,DetailedView.class);
                    intent.putExtra("post",String.valueOf(position));
                    context.startActivity(intent);

                }
            });

            return convertView;
        }
    }
    private void notifyData(){
        notifyDataSetChanged();
    }
}
