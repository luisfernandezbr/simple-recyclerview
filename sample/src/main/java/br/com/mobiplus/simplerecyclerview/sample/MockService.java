package br.com.mobiplus.simplerecyclerview.sample;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import br.com.mobiplus.simplerecyclerview.sample.model.Stadium;

/**
 * Created by luis.fernandez on 2/27/17.
 */

public class MockService {

    public void loadStadiumList(final DataCallback dataCallback) {
        AsyncTask<Void, Void, List<Stadium>> asyncTask = new AsyncTask<Void, Void, List<Stadium>>() {

            @Override
            protected List<Stadium> doInBackground(Void... params) {
                return getStadiumList();
            }

            @Override
            protected void onPostExecute(List<Stadium> stadiumList) {
                super.onPostExecute(stadiumList);
                dataCallback.onLoadData(stadiumList);
            }
        };

        asyncTask.execute();
    }

    private List<Stadium> getStadiumList() {
        List<Stadium> stadiumList = new ArrayList<>();
        stadiumList.add(new Stadium("Stanford Bridge", "http://www.campeoesdofutebol.com.br/estadios/stamford_bridge_stadium.jpg", 65000, "19/03/1940", 12394));
        stadiumList.add(new Stadium("Emirates Stadium", "http://www.stadiumguide.com/wp-content/gallery/emirates/emirates1.jpg", 96000, "20/10/1899", 1));
        stadiumList.add(new Stadium("Maracanã (Mario Filho)", "http://knoow.net/wp-content/uploads/2016/01/maracana2.jpg", 78838, "16/06/1950", 0));
        stadiumList.add(new Stadium("San Siro", "http://www.stadiumguide.com/wp-content/gallery/sansiro/sansiro10.jpg", 80018, "19/09/1926", 4722));
        stadiumList.add(new Stadium("Old Traford", "http://www.stadiumguide.com/wp-content/uploads/oldtrafford_front.jpg", 75811, "02/02/1910", 3494));
        stadiumList.add(new Stadium("Alianz Arena", "http://www.stadiumguide.com/wp-content/uploads/allianzarena_front.jpg", 75000, "06/04/2005", 93645));
        stadiumList.add(new Stadium("Camp Nou", "http://www.stadiumguide.com/wp-content/uploads/campnou_front-2.jpg", 99354, "12/09/1957", 65284));
        stadiumList.add(new Stadium("Juventus Stadium", "http://www.stadiumguide.com/wp-content/uploads/juventus_front1.jpg", 41000, "08/09/2011", 1287));
        return stadiumList;
    }

    public interface DataCallback<T> {
        void onLoadData(T data);
    }
}
