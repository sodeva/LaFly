package sodevan.lafly;

/**
 * Created by ravipiyush on 16/10/16.
 */

public class StoreItem {



    String iname ;
    float price ;


    int image ;

    public StoreItem(String iname, float price , int image) {
        this.iname = iname;
        this.price = price;
        this.image = image ;


    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}
