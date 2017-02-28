package br.com.mobiplus.simplerecylerview.adapter;

import android.support.annotation.IdRes;
import android.widget.TextView;

/**
 * Created by luis.fernandez on 11/12/16.
 */

public interface OnPreloadContent {

    boolean onPreLoadContent(String content, TextView textView);
}
