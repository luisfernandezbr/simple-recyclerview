# Mobiplus Simple RecyclerView
Simple RecyclerView library is based on adapter-kit library concept from https://github.com/ragunathjawahar

The main Simple RecyclerView's target is to simplify the RecyclerView development in commom usages.
You don't need to bind POJO data to views if this work don't needs intelligence.

## What you need?

### 1 - A XML layout that represents your view

```xml
<?xml version="1.0" encoding="utf-8"?>
<!--
    This sample layout.xml file is not valid.
    To see complete layout get the project and see inside the sample app.
-->
<RelativeLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <ImageView
        android:id="@+id/imageIcon"
        android:layout_width="100dp"
        android:layout_height="60dp"
        android:scaleType="centerCrop"/>

    <LinearLayout
        android:orientation="vertical">

        <TextView
            android:id="@+id/textName"
            tools:text="Alianz Arena"/>

        <TextView
            android:id="@+id/textCapacity"
            tools:text="75000"/>

        <TextView
            android:id="@+id/textFoundationDate"
            tools:text="06/04/2005"/>

        <TextView
            android:id="@+id/textLikes"
            tools:text="93645 likes"/>
    </LinearLayout>

</RelativeLayout>
```

### 2 - A POJO class binding attributes to view items

```java
@LayoutAdapter(layoutResId = R.layout.item_custom_adapter_stadium_layout)
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

    @TextAdapter(resId = R.id.textCapacity, typeface = FontConstants.FONT_ROBOTO_LIGHT)
    public int getCapacity() {
        return capacity;
    }

    @TextAdapter(resId = R.id.textFoundationDate, typeface = FontConstants.FONT_ROBOTO_LIGHT)
    public String getFoundation() {
        return foundation;
    }

    @TextAdapter(resId = R.id.textLikes, typeface = FontConstants.FONT_ROBOTO_LIGHT)
    public int getLikes() {
        return likes;
    }
    // ...
}
```

### 3 - Start SimpleRecyclerView with your Collection

```java
    @Override
    public void onLoadData(List<Stadium> stadiumList) {
        SimpleLinearRecyclerView recyclerView = this.findViewById(R.id.recyclerView);
        recyclerView.setCollection(stadiumList, new OnItemClickListener<Stadium>() {
            @Override
            public void onItemClick(Stadium stadium, @IdRes int resId) {
                Toast.makeText(SimpleRecyclerViewActivity.this, "Clicked item: " + stadium.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
```
## Configuring

/build.gradle

`repositories { maven { url  "https://dl.bintray.com/luis82fernandez/libraries" }}`

/[your_app]/build.gradle

`implementation 'br.com.mobiplus:simple-recyclerview-library:[last_version]'`
