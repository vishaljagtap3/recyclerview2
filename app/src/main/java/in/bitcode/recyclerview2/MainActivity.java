package in.bitcode.recyclerview2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CitiesFragment mCitiesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mCitiesFragment = (CitiesFragment) getSupportFragmentManager()
                .findFragmentById(R.id.citiesFragment);
        mCitiesFragment.setOnCityClickListener(new MyMainCityClickListener());
    }

    class MyMainCityClickListener implements CitiesFragment.OnCityClickListener {

        @Override
        public void onCityClick(City city, int position) {

            CityDetailsFragment cityDetailsFragment = new CityDetailsFragment();

            Bundle args = new Bundle();
            args.putSerializable(City.KEY_CITY, city);
            cityDetailsFragment.setArguments(args);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.mainContainer, cityDetailsFragment, null)
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "MA-M1");
        menu.add(0, 2, 0, "MA-M2");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
        return true;
    }
}