package br.com.mobiplus.simplerecyclerview.sample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by luis.fernandez on 2/28/17.
 */

public class StadiumAdapter extends RecyclerView.Adapter<StadiumAdapter.StadiumViewHolder> {

    @Override
    public StadiumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(StadiumViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class StadiumViewHolder extends RecyclerView.ViewHolder {
        public StadiumViewHolder(View itemView) {
            super(itemView);
        }
    }
}
