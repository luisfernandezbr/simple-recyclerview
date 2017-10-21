package br.com.mobiplus.simplerecyclerview.sample;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

import br.com.mobiplus.simplerecyclerview.sample.model.Stadium;
import br.com.mobiplus.simplerecylerview.SimpleLinearRecyclerView;
import br.com.mobiplus.simplerecylerview.adapter.OnItemClickListener;

public class SimpleRecyclerViewActivity extends AppCompatActivity implements MockService.DataCallback<List<Stadium>> {

    private MockService mockService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recycler_view);

        mockService = new MockService(getApplicationContext());

        this.loadData();
    }

    private void loadData() {
        mockService.loadStadiumList(this);
    }

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
}
