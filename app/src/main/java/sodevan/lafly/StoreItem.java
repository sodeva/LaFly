package sodevan.lafly;

/**
 * Created by ravipiyush on 16/10/16.
 */

public class StoreItem {



    String iname ;
    float price ;


    boolean status ;
    int image ;

    public StoreItem(String iname, float price , int image , boolean status) {
        this.iname = iname;
        this.price = price;
        this.image = image ;
        this.status = status ;


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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
