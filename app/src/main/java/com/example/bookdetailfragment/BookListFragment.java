package com.example.bookdetailfragment;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by ASUS on 2017/8/26.
 */

public class BookListFragment extends ListFragment {
    private Callbacks mCallbacks;

    public interface Callbacks {
        public void onItemSelected(Integer id);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(), android.R.layout.simple_list_item_1,
//                android.R.id.text1, BookContent.ITEMS));
        setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(), R.layout.simple_item,
                R.id.simple_item, BookContent.ITEMS));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof Callbacks)){
            throw new IllegalStateException(
                    "BookListFragment 所在的Activity必须实现Callsbacks接口！"
            );
        }
        mCallbacks=(Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallbacks.onItemSelected(BookContent.ITEMS.get(position).id);
    }
    public void setActivateOnItemClick(boolean activateOnItemClick){
        getListView().setChoiceMode(
                activateOnItemClick ? ListView.CHOICE_MODE_SINGLE:ListView.CHOICE_MODE_NONE
        );
    }
}

