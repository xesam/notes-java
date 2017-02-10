package dev.xesam.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by xesamguo@gmail.com on 17-2-10.
 */
public class Main {
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Book.class, new BookDeserializer());
        Gson gson = gsonBuilder.create();

        Book book = gson.fromJson("{\"title\":\"Java Puzzlers: Traps, Pitfalls, and Corner Cases\",\"isbn-10\":\"032133678X\",\"isbn-13\":\"978-0321336781\",\"authors\":[\"Joshua Bloch\",\"Neal Gafter\"]}", Book.class);
        System.out.println(book);
    }
}
