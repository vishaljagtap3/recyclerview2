package in.bitcode.recyclerview2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CityDetailsFragment extends Fragment {

    private ImageView mImgCity;
    private TextView mTxtCityName, mTxtCityPopulation;

    private City mCity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.act_city_details, null);

        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });

        mImgCity = view.findViewById(R.id.imgCity);
        mTxtCityName = view.findViewById(R.id.txtCityName);
        mTxtCityPopulation = view.findViewById(R.id.txtCityPopulation);

        init();

        return view;
    }

    private void init() {
        mCity = (City) getArguments().getSerializable(City.KEY_CITY);
        if(mCity != null) {
            mImgCity.setImageResource(mCity.getImageId());
            mTxtCityName.setText(mCity.getName());
            mTxtCityPopulation.setText(mCity.getPopulation()+" lacs");
        }
    }
}
