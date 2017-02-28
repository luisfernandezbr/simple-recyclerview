package br.com.mobiplus.simplerecyclerview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.com.mobiplus.simplerecyclerview.sample.model.Stadium;

public class NormalRecyclerViewActivity extends AppCompatActivity  implements MockService.DataCallback<List<Stadium>> {

    private MockService mockService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_recycler_view);

        mockService = new MockService();

        this.loadData();
    }

    private void loadData() {
        mockService.loadStadiumList(this);
    }

    @Override
    public void onLoadData(List<Stadium> stadiumList) {
        StadiumAdapter adapter = new StadiumAdapter(stadiumList);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
