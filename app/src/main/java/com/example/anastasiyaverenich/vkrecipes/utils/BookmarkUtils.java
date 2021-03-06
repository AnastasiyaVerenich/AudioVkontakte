package com.example.anastasiyaverenich.vkrecipes.utils;

import com.example.anastasiyaverenich.vkrecipes.application.VkRApplication;
import com.example.anastasiyaverenich.vkrecipes.modules.Recipe;

import java.util.List;

public class BookmarkUtils {
    private static List<Recipe.Feed> bookmarks;

    public static List<Recipe.Feed> getBookmarks(List<Recipe.Feed> bookmarks)
    {
        return bookmarks;
    }

    public static void setBookmarks(List<Recipe.Feed> bookmarks) {
        BookmarkUtils.bookmarks = bookmarks;
    }

    public static boolean checkBookmarks(long id){
        for(int i = 0; i < bookmarks.size(); i++){
            if(id == bookmarks.get(i).id) {
                return true;
            }
        }
        return false;
    }

    public static void addBookmark(Recipe.Feed feed, int categoryId){
        bookmarks.add(feed);
        VkRApplication.get().getMySQLiteHelper().addBookmarks(feed, categoryId);
    }

    public static void deleteBookmark(Recipe.Feed feed){
        for(int i = 0; i < bookmarks.size(); i++){
            if(feed.id == bookmarks.get(i).id) {
                bookmarks.remove(i);
                break;
            }
        }
        VkRApplication.get().getMySQLiteHelper().deleteBookmark(feed);
    }
}
