package br.com.mobiplus.simplerecyclerview.sample;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.IdRes;
import android.support.annotation.RawRes;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import br.com.mobiplus.simplerecyclerview.sample.model.Stadium;

@SuppressWarnings("WeakerAccess")
public class MockService {

    private final static String TAG = "MockService";

    private Context context;

    public MockService(Context context) {
        this.context = context;
    }

    public void loadStadiumList(final DataCallback<List<Stadium>> dataCallback) {

        AsyncTask<Void, Void, List<Stadium>> asyncTask = new AsyncTask<Void, Void, List<Stadium>>() {

            @Override
            protected List<Stadium> doInBackground(Void... params) {
                List<Stadium> stadiumList = null;

                try {
                    String jsonFromRaw = this.getJsonFromRaw(R.raw.stadium_list);
                    stadiumList = this.getStadiumListFrom(jsonFromRaw);

                } catch (IOException e) {
                    Log.e(TAG, "Error executing doInBackground(). ", e);
                }

                return stadiumList;
            }

            @Override
            protected void onPostExecute(List<Stadium> stadiumList) {
                super.onPostExecute(stadiumList);
                dataCallback.onLoadData(stadiumList);

                Gson gson = new Gson();
                String toJson = gson.toJson(stadiumList);
                Log.d(TAG, "onPostExecute: " + toJson);
            }

            private List<Stadium> getStadiumListFrom(String json) {
                Gson gson = new Gson();

                List<Stadium> stadiumList = gson.fromJson(json, new TypeToken<List<Stadium>>(){}.getType());

                return stadiumList;
            }

            public String getJsonFromRaw(@RawRes int resRawId) throws IOException {
                InputStream inputStream = context.getResources().openRawResource(resRawId);
                Writer writer = new StringWriter();
                char[] buffer = new char[1024];

                try {
                    Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                    int n;
                    while ((n = reader.read(buffer)) != -1) {
                        writer.write(buffer, 0, n);
                    }
                } finally {
                    inputStream.close();
                }

                return writer.toString();
            }
        };

        asyncTask.execute();
    }

    public interface DataCallback<DATA_TYPE> {
        void onLoadData(DATA_TYPE data);
    }
}
