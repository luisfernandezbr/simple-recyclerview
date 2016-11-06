package br.com.mobiplus.simplerecylerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.List;

import br.com.mobiplus.simplerecylerview.adapter.OnItemClickListener;


/**
 * Created by luisfernandez on 2/11/16.
 */
public abstract class LinearRecyclerView extends RecyclerView {

    public LinearRecyclerView(Context context) {
        super(context);
        this.init(context);
    }

    public LinearRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(context);
    }

    public LinearRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init(context);
    }

    protected void init(Context context) {
        setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(context));
    }

    public abstract void setCollection(List list, OnItemClickListener onItemClickListener);
}
