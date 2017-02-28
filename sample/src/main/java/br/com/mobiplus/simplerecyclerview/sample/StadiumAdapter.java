package br.com.mobiplus.simplerecyclerview.sample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.mobiplus.simplerecyclerview.sample.model.Stadium;

/**
 * Created by luis.fernandez on 2/28/17.
 */

public class StadiumAdapter extends RecyclerView.Adapter<StadiumAdapter.StadiumViewHolder> {


    private List<Stadium> stadiumList;

    public StadiumAdapter(List<Stadium> stadiumList) {
        this.stadiumList = stadiumList;
    }

    @Override
    public StadiumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(StadiumViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return stadiumList.size();
    }

    public static class StadiumViewHolder extends RecyclerView.ViewHolder {
        public StadiumViewHolder(View itemView) {
            super(itemView);
        }
    }
}
