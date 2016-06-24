package customview.xx.com.databindingdemo.model;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import customview.xx.com.databindingdemo.R;

/**
 * Created by aaron_lu on 6/21/16.
 */
public class Hotel {
    public String address;
    public String name;
    public int price;
    public String pic;
    public ObservableField<String> imageUrl = new ObservableField<>();

    public Hotel(String name, String address, String pic, int price, ObservableField<String> imageUrl) {
        this.name = name;
        this.address = address;
        this.pic = pic;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    /**
     * 自定义绑定逻辑
     *
     * @param view
     * @param imageUrl
     */
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(view);
    }

    public ObservableField<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(ObservableField<String> imageUrl) {
        this.imageUrl = imageUrl;
    }
}
