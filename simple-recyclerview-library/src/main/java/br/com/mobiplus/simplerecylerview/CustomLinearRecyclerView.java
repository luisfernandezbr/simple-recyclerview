package br.com.mobiplus.simplerecylerview;

import android.content.Context;
import android.util.AttributeSet;

import java.util.List;

import br.com.mobiplus.simplerecylerview.adapter.CustomAdapter;
import br.com.mobiplus.simplerecylerview.adapter.OnItemClickListener;


/**
 * Created by luisfernandez on 2/10/16.
 */
public class CustomLinearRecyclerView extends LinearRecyclerView {

    public CustomLinearRecyclerView(Context context) {
        super(context);
    }

    public CustomLinearRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setCollection(List list, OnItemClickListener onItemClickListener) {
        setAdapter(new CustomAdapter(getContext(), list, onItemClickListener));
    }
}
