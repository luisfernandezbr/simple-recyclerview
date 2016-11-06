package br.com.mobiplus.simplerecyclerview.sample.model;

import br.com.mobiplus.simplerecyclerview.sample.R;
import br.com.mobiplus.simplerecylerview.annotations.ImageAdapter;
import br.com.mobiplus.simplerecylerview.annotations.LayoutAdapter;
import br.com.mobiplus.simplerecylerview.annotations.TextAdapter;

/**
 * Created by luisfernandez on 2/10/16.
 */
@LayoutAdapter(layoutResId = R.layout.item_custom_adapter_event_layout)
public class Stadium {

    private String name;
    private String iconUrl;
    private int capacity;
    private String foundation;

    public Stadium(String name, String iconUrl, int capacity, String foundation) {
        this.name = name;
        this.iconUrl = iconUrl;
        this.capacity = capacity;
        this.foundation = foundation;
    }

    @TextAdapter(resId = R.id.eventText_1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ImageAdapter(resId = R.id.eventImage)
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @TextAdapter(resId = R.id.eventText_2)
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @TextAdapter(resId = R.id.eventText_3)
    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }
}
