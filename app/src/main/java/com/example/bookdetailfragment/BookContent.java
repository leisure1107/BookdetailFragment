package com.example.bookdetailfragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2017/8/26.
 */

public class BookContent {
    public static class Book{
        public Integer id;
        public String title;
        public String desc;
        public Book(Integer id,String title,String desc){
            this.id = id;
            this.title = title;
            this.desc = desc;
        }
        public String toString(){
            return title;
        }
    }
    public static List<Book> ITEMS = new ArrayList<Book>();
    public static Map<Integer, Book> ITEM_MAP = new HashMap<Integer, Book>();
    static {
        addItem(new Book(1, "疯狂java","一本java"));
        addItem(new Book(2, "疯狂android","一本android"));
        addItem(new Book(3, "疯狂java ee","一本java ee"));
    }

    private static void addItem(Book book) {
        ITEMS.add(book);
        ITEM_MAP.put(book.id, book);
    }
}
