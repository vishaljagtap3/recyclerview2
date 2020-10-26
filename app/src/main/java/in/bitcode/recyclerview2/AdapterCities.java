package in.bitcode.recyclerview2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterCities extends RecyclerView.Adapter<AdapterCities.CityViewHolder> {

    private ArrayList<City> mListCities;

    public AdapterCities(ArrayList<City> cities) {
        mListCities = cities;
    }

    class CityViewHolder extends RecyclerView.ViewHolder {

        public TextView mTxtName, mTxtPopulation;
        public ImageView mImgCity;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxtName = itemView.findViewById(R.id.txtName);
            mTxtPopulation = itemView.findViewById(R.id.txtPopulation);
            mImgCity = itemView.findViewById(R.id.imgCity);

            mImgCity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    City city = mListCities.get(getAdapterPosition());
                    Toast.makeText(view.getContext(), "Image of " + city.getName(), Toast.LENGTH_LONG)
                            .show();
                }
            });

            mTxtName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    City city = mListCities.get(getAdapterPosition());
                    Snackbar.make(view, city.getName() + " " + city.getPopulation(), Snackbar.LENGTH_LONG)
                            .show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mListCities.size();
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_view, null);


        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {

        City city = mListCities.get(position);

        holder.mImgCity.setImageResource(city.getImageId());
        holder.mTxtName.setText(city.getName());
        holder.mTxtPopulation.setText(city.getPopulation() + " lacs");

        //set up listener (Not Good)
        /*
        holder.mImgCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Image of " + city.getName() , Toast.LENGTH_LONG)
                        .show();
            }
        });

        holder.mTxtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, city.getName() + " " + city.getPopulation(), Snackbar.LENGTH_LONG)
                        .show();
            }
        });
        */
    }
}