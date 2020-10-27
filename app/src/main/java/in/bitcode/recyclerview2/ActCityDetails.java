package in.bitcode.recyclerview2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActCityDetails extends AppCompatActivity {

    private TextView mTxtCityName, mTxtCityPopulation;
    private ImageView mImgCity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_city_details);

        init();
    }

    private void init() {
        mTxtCityName = findViewById(R.id.txtCityName);
        mTxtCityPopulation = findViewById(R.id.txtCityPopulation);
        mImgCity = findViewById(R.id.imgCity);

        City city = (City) getIntent().getSerializableExtra("city");
        mTxtCityName.setText(city.getName());
        mTxtCityPopulation.setText(city.getPopulation()+" lacs");
        mImgCity.setImageResource(city.getImageId());
    }
}
