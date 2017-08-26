package com.example.bookdetailfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.Fragment;

public class BookDetailFragment extends Fragment {
    public static final String ITEM_ID = "item_id";
    BookContent.Book book=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ITEM_ID)){
            book = BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book_detail, container, false);
        if (book!=null){
            ((TextView)rootView.findViewById(R.id.Book_title)).setText(book.title);
            ((TextView) rootView.findViewById(R.id.book_desc)).setText(book.desc);
        }
        return rootView;
    }
}
