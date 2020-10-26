package in.bitcode.recyclerview2;

import java.io.Serializable;

class City implements Serializable {

    private String mName;
    private int mImageId;
    private int mPopulation; //in lacs

    public City(String name, int imageId, int population) {
        mName = name;
        mImageId = imageId;
        mPopulation = population;
    }

    public String getName() {
        return mName;
    }

    public int getImageId() {
        return mImageId;
    }

    public int getPopulation() {
        return mPopulation;
    }
}
