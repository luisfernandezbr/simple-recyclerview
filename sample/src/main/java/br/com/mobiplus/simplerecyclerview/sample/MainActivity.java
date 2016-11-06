package br.com.mobiplus.simplerecyclerview.sample;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.mobiplus.simplerecyclerview.sample.model.Stadium;
import br.com.mobiplus.simplerecylerview.SimpleLinearRecyclerView;
import br.com.mobiplus.simplerecylerview.adapter.OnItemClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        List<Stadium> stadiumList = new ArrayList<>();
        stadiumList.add(new Stadium("Stanford Bridge", "http://www.campeoesdofutebol.com.br/estadios/stamford_bridge_stadium.jpg", 65000, "19/03/1940"));
        stadiumList.add(new Stadium("Emirates Stadium", "http://www.stadiumguide.com/wp-content/gallery/emirates/emirates1.jpg", 96000, "20/10/1899"));
        stadiumList.add(new Stadium("Maracanã (Mario Filho)", "http://knoow.net/wp-content/uploads/2016/01/maracana2.jpg", 78838, "16/06/1950"));
        stadiumList.add(new Stadium("San Siro", "http://www.stadiumguide.com/wp-content/gallery/sansiro/sansiro10.jpg", 80018, "19/09/1926"));
        stadiumList.add(new Stadium("Old Traford", "http://www.stadiumguide.com/wp-content/uploads/oldtrafford_front.jpg", 75811, "02/02/1910"));
        stadiumList.add(new Stadium("Alianz Arena", "http://www.stadiumguide.com/wp-content/uploads/allianzarena_front.jpg", 75000, "06/04/2005"));
        stadiumList.add(new Stadium("Camp Nou", "http://www.stadiumguide.com/wp-content/uploads/campnou_front-2.jpg", 99354, "12/09/1957"));
        stadiumList.add(new Stadium("Juventus Stadium", "http://www.stadiumguide.com/wp-content/uploads/juventus_front1.jpg", 41000, "08/09/2011"));

        stadiumList.addAll(stadiumList);
        SimpleLinearRecyclerView recyclerView = (SimpleLinearRecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setCollection(stadiumList, new OnItemClickListener<Stadium>() {
            @Override
            public void onItemClick(Stadium stadium, @IdRes int resId) {
                Toast.makeText(getApplicationContext(), "Clicked item: " + stadium.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
