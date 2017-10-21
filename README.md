# Mobiplus Simple RecyclerView
Simple RecyclerView library is based on adapter-kit library concept from https://github.com/ragunathjawahar

The main Simple RecyclerView's target is to simplify the RecyclerView development in commom usages.
You don't need to bind POJO data to views if this work don't needs intelligence.
That's it.

## What you need?

### An XML layout that represents your view

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

## Configuring

/build.gradle

`repositories { maven { url  "https://dl.bintray.com/luis82fernandez/libraries" }}`

/[your_app]/build.gradle

`implementation 'br.com.mobiplus:simple-recyclerview-library:[last_version]'`
