package br.com.mobiplus.simplerecyclerview.sample;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.mobiplus.simplerecyclerview.sample.model.Event;
import br.com.mobiplus.simplerecylerview.SimpleLinearRecyclerView;
import br.com.mobiplus.simplerecylerview.adapter.OnItemClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        List<Event> eventList = new ArrayList<>();
        eventList.add(new Event("http://cdn.guiasrbs.com.br/uXaFhMfKw_j67sgNnYmAG2bnTrk=/620x330/smart/www.guiadasemana.com.br/system/pictures/2014/6/115261/cropped/citibank-hall.png", "30/03/2016", "Roupa Nova - Citibank Hall", 90.00d, "22:30"));
        eventList.add(new Event("http://imgs-srzd.s3.amazonaws.com/srzd/upload/b/a/barra_music_01_620.jpg", "01/04/2016", "Anitta - Barra Music", 45.00d, "23:00"));
        eventList.add(new Event("http://www.vivorio.com.br/wp-content/uploads/vivo_rio1.jpg", "02/04/2016", "Sorriso Maroto - Vivo Rio", 60.00d, "21:00"));

        SimpleLinearRecyclerView recyclerView = (SimpleLinearRecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setCollection(eventList, new OnItemClickListener<Event>() {
            @Override
            public void onItemClick(Event event, @IdRes int resId) {
                Toast.makeText(getApplicationContext(), "Clicked item: " + event.getDescription(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
