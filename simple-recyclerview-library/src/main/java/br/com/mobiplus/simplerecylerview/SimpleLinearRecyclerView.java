package br.com.mobiplus.simplerecylerview;

import android.content.Context;
import android.util.AttributeSet;

import java.util.List;

import br.com.mobiplus.simplerecylerview.adapter.CustomAdapter;
import br.com.mobiplus.simplerecylerview.adapter.OnItemClickListener;
import br.com.mobiplus.simplerecylerview.adapter.OnPreloadContent;


/**
 * Created by luisfernandez on 2/10/16.
 */
public class SimpleLinearRecyclerView extends LinearRecyclerView {

    private OnPreloadContent onPreloadContent;

    public SimpleLinearRecyclerView(Context context) {
        super(context);
    }

    public SimpleLinearRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleLinearRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void addOnPreloadContent(OnPreloadContent onPreloadContent) {
        this.onPreloadContent = onPreloadContent;
    }

    public void setCollection(List list, OnItemClickListener onItemClickListener) {
        CustomAdapter adapter = new CustomAdapter(getContext(), list, onItemClickListener);
        adapter.addOnPreloadContent(onPreloadContent);
        setAdapter(adapter);
    }
}
