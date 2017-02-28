package br.com.mobiplus.simplerecyclerview.sample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

        private TextView textName;
        private TextView textCapacity;
        private TextView textFoundationDate;
        private TextView textLikeCount;
        private ImageView imageStadiumPhoto;

        public StadiumViewHolder(View itemView) {
            super(itemView);

            this.textName = (TextView) itemView.findViewById(R.id.text_1);
            this.textCapacity = (TextView) itemView.findViewById(R.id.text_2);
            this.textFoundationDate = (TextView) itemView.findViewById(R.id.text_3);
            this.textLikeCount = (TextView) itemView.findViewById(R.id.text_4);
            this.imageStadiumPhoto = (ImageView) itemView.findViewById(R.id.imageIcon);
        }
    }
}
