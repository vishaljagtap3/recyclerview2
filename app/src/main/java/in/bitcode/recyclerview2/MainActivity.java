package in.bitcode.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<City> mListCities;
    private RecyclerView mRecyclerCities;
    private AdapterCities mAdatperCities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mRecyclerCities = findViewById(R.id.recyclerCities);
        mListCities = new ArrayList<City>();

        mListCities.add(new City("Pune-1", R.drawable.img1, 34));
        mListCities.add(new City("Pune-2 MH India", R.drawable.img2, 12));
        mListCities.add(new City("Pune-3", R.drawable.img3, 34));
        mListCities.add(new City("Tiruanantpuram India", R.drawable.img6, 40));
        mListCities.add(new City("Pune-4", R.drawable.img4, 35));
        mListCities.add(new City("Pune-5", R.drawable.img5, 20));
        mListCities.add(new City("Pune-6", R.drawable.img6, 40));
        mListCities.add(new City("Pune-Maharashtra-India", R.drawable.img7, 14));
        mListCities.add(new City("Pune-8", R.drawable.img8, 49));
        mListCities.add(new City("Pune-9", R.drawable.img9, 36));
        mListCities.add(new City("Pune-10", R.drawable.img1, 60));
        mListCities.add(new City("Pune-11", R.drawable.img2, 23));
        mListCities.add(new City("Vishakhapattanam", R.drawable.img9, 36));
        mListCities.add(new City("Pune-8", R.drawable.img8, 49));
        mListCities.add(new City("Pune-9", R.drawable.img9, 36));
        mListCities.add(new City("Pune-10", R.drawable.img1, 60));
        mListCities.add(new City("Pune-11", R.drawable.img2, 23));
        mListCities.add(new City("Vishakhapattanam-India", R.drawable.img9, 36));
        mListCities.add(new City("Pune-8", R.drawable.img8, 49));
        mListCities.add(new City("Pune-9", R.drawable.img9, 36));
        mListCities.add(new City("Pune-10", R.drawable.img1, 60));
        mListCities.add(new City("Pune-11", R.drawable.img2, 23));


        mAdatperCities = new AdapterCities(mListCities);
        mAdatperCities.setOnCityClickListener(new MyOnCityClickListener());

        mRecyclerCities.setAdapter(mAdatperCities);
        mRecyclerCities.setLayoutManager(
                //new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                //new GridLayoutManager(this, 2)
                //new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        );

    }

    class MyOnCityClickListener implements AdapterCities.OnCityClickListener {

        @Override
        public void onCityClick(City city, int position) {
            Intent intent = new Intent(MainActivity.this, ActCityDetails.class);
            intent.putExtra("city", city);
            startActivity(intent);
        }
    }
}