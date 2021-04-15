package com.androiddev.travelblogapp;

import java.util.ArrayList;

public class PostsDB {

    private static ArrayList<Post> postsArrayList = new ArrayList<Post>();

    public static ArrayList<Post> getPostsArrayList() {return postsArrayList;};
    public static void addToPostsArrayList(Post post ){ postsArrayList.add(post);}

}
