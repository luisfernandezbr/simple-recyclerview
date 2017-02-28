package br.com.mobiplus.simplerecyclerview.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.mobiplus.simplerecyclerview.sample.model.Stadium;

/**
 * Created by luis.fernandez on 2/28/17.
 */

public class StadiumAdapter extends RecyclerView.Adapter<StadiumAdapter.StadiumViewHolder> {

    private Context context;
    private List<Stadium> stadiumList;

    public StadiumAdapter(Context context, List<Stadium> stadiumList) {
        this.context = context;
        this.stadiumList = stadiumList;
    }

    @Override
    public StadiumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_custom_adapter_event_layout, parent, false);

        return new StadiumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StadiumViewHolder holder, int position) {
        Stadium stadium = this.getItem(position);

        holder.textName.setText(stadium.getName());
        holder.textCapacity.setText(String.valueOf(stadium.getCapacity()));
        holder.textFoundationDate.setText(stadium.getFoundation());
        holder.textLikeCount.setText(String.valueOf(stadium.getLikes()));

        Picasso.with(context).load(stadium.getIconUrl()).into(holder.imageStadiumPhoto);
    }

    private Stadium getItem(int position) {
        return stadiumList.get(position);
    }

    @Override
    public int getItemCount() {
        return stadiumList.size();
    }

    public static class StadiumViewHolder extends RecyclerView.ViewHolder {

        TextView textName;
        TextView textCapacity;
        TextView textFoundationDate;
        TextView textLikeCount;
        ImageView imageStadiumPhoto;

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
