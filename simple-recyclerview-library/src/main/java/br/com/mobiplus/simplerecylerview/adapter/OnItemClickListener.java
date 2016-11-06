package br.com.mobiplus.simplerecylerview.adapter;

import android.support.annotation.IdRes;

public interface OnItemClickListener<T> {
    void onItemClick(T item, @IdRes int resId);
}