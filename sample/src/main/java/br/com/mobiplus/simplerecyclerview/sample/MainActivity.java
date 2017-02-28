package br.com.mobiplus.simplerecyclerview.sample;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.mobiplus.simplerecyclerview.sample.model.Stadium;
import br.com.mobiplus.simplerecylerview.SimpleLinearRecyclerView;
import br.com.mobiplus.simplerecylerview.adapter.OnItemClickListener;
import br.com.mobiplus.simplerecylerview.adapter.OnPreloadContent;

public class MainActivity extends AppCompatActivity implements MockService.DataCallback<List<Stadium>>{

    private MockService mockService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        mockService = new MockService();

        this.loadData();
    }

    private void loadData() {
        mockService.loadStadiumList(this);
    }

    @Override
    public void onLoadData(List<Stadium> stadiumList) {
        SimpleLinearRecyclerView recyclerView = (SimpleLinearRecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addOnPreloadContent(new OnPreloadContent() {
            @Override
            public boolean onPreLoadContent(String content, TextView textView) {

                if (R.id.text_4 == textView.getId()) {
                    Resources res = getResources();

                    String quantityString = res.getQuantityString(R.plurals.text_like_plural, Integer.parseInt(content), Integer.parseInt(content));
                    textView.setText(quantityString);

                    return true;
                }

                return false;
            }
        });

        recyclerView.setCollection(stadiumList, new OnItemClickListener<Stadium>() {
            @Override
            public void onItemClick(Stadium stadium, @IdRes int resId) {
                Toast.makeText(getApplicationContext(), "Clicked item: " + stadium.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
