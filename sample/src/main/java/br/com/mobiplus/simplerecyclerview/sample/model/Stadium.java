package br.com.mobiplus.simplerecyclerview.sample.model;

import br.com.mobiplus.simplerecyclerview.sample.R;
import br.com.mobiplus.simplerecylerview.annotations.ImageAdapter;
import br.com.mobiplus.simplerecylerview.annotations.LayoutAdapter;
import br.com.mobiplus.simplerecylerview.annotations.TextAdapter;

@LayoutAdapter(layoutResId = R.layout.item_custom_adapter_event_layout)
public class Stadium {

    private String name;
    private String iconUrl;
    private int capacity;
    private String foundation;
    private int likes;

    @TextAdapter(resId = R.id.textName)
    public String getName() {
        return name;
    }

    @ImageAdapter(resId = R.id.imageIcon)
    public String getIconUrl() {
        return iconUrl;
    }

    @TextAdapter(resId = R.id.textCapacity)
    public int getCapacity() {
        return capacity;
    }

    @TextAdapter(resId = R.id.textFoundationDate)
    public String getFoundation() {
        return foundation;
    }

    @TextAdapter(resId = R.id.textLikes)
    public int getLikes() {
        return likes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
