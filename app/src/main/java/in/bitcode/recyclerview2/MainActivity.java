package in.bitcode.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
        mListCities.add(new City("Pune-2", R.drawable.img2, 12));
        mListCities.add(new City("Pune-3", R.drawable.img3, 34));
        mListCities.add(new City("Pune-4", R.drawable.img4, 35));
        mListCities.add(new City("Pune-5", R.drawable.img5, 20));
        mListCities.add(new City("Pune-6", R.drawable.img6, 40));
        mListCities.add(new City("Pune-7", R.drawable.img7, 14));
        mListCities.add(new City("Pune-8", R.drawable.img8, 49));
        mListCities.add(new City("Pune-9", R.drawable.img9, 36));
        mListCities.add(new City("Pune-10", R.drawable.img1, 60));
        mListCities.add(new City("Pune-11", R.drawable.img2, 23));

        mAdatperCities = new AdapterCities(mListCities);
        mRecyclerCities.setAdapter(mAdatperCities);

        mRecyclerCities.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        );

    }
}