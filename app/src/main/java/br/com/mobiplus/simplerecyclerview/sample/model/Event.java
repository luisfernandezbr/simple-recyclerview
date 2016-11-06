package br.com.mobiplus.simplerecyclerview.sample.model;

import java.io.Serializable;

import br.com.mobiplus.simplerecyclerview.sample.R;
import br.com.mobiplus.simplerecylerview.annotations.ImageAdapter;
import br.com.mobiplus.simplerecylerview.annotations.LayoutAdapter;
import br.com.mobiplus.simplerecylerview.annotations.TextAdapter;


/**
 * Created by luisfernandez on 2/11/16.
 */
@LayoutAdapter(layoutResId = R.layout.item_custom_adapter_event_layout)
public class Event implements Serializable {

    private String imageUrl;
    private String date;
    private String description;
    private double price;
    private String hour;

    public Event(String imageUrl, String date, String description, double price, String hour) {
        this.imageUrl = imageUrl;
        this.date = date;
        this.description = description;
        this.price = price;
        this.hour = hour;
    }

    @ImageAdapter(resId = R.id.eventImage)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @TextAdapter(resId = R.id.eventText_2)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @TextAdapter(resId = R.id.eventText_1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @TextAdapter(resId = R.id.eventText_3)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @TextAdapter(resId = R.id.eventText_subtitle)
    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
