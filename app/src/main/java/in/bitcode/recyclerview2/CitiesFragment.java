package in.bitcode.recyclerview2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class CitiesFragment extends Fragment {

    private RecyclerView mRecyclerCities;
    private ArrayList<City> mListCities;
    private AdapterCities mAdatperCities;

    public interface OnCityClickListener {
        public void onCityClick(City city, int position);
    }

    private OnCityClickListener mOnCityClickListener;

    public void setOnCityClickListener(OnCityClickListener onCityClickListener){
        mOnCityClickListener = onCityClickListener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.cities_fragment, null);
        mRecyclerCities = view.findViewById(R.id.recyclerCities);

        init();

        return view;
    }

    private void init() {

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
        mAdatperCities.setOnCityClickListener(new CitiesFragment.MyOnCityClickListener());

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
           //Add a fragment to view details of city

            /*
            CityDetailsFragment cityDetailsFragment = new CityDetailsFragment();

            Bundle args = new Bundle();
            args.putSerializable("city", city);
            cityDetailsFragment.setArguments(args);

            getFragmentManager().beginTransaction()
                    .add(R.id.mainContainer, cityDetailsFragment, null)
                    .addToBackStack(null)
                    .commit();
             */

            if(mOnCityClickListener != null) {
                mOnCityClickListener.onCityClick(city, position);
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        menu.add(1, 3, 0, "CF-M1");
        menu.add(1, 4, 0, "CF-M2");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
