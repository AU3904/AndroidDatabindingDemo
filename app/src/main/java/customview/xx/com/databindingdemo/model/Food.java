package customview.xx.com.databindingdemo.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import customview.xx.com.databindingdemo.R;

/**
 * Created by aaron_lu on 6/21/16.
 */
public class Food {

    public String name;
    public String review;
    public String photoUrl;


    public Food(String name, String review, String photoUrl) {
        this.name = name;
        this.review = review;
        this.photoUrl = photoUrl;
    }

    /**
     * 自定义绑定逻辑
     *
     * @param view
     * @param photoUrl
     */
    @BindingAdapter({"bind:photoUrl"})
    public static void loadImage(ImageView view, String photoUrl) {
        Picasso.with(view.getContext())
                .load(photoUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(view);
    }
}
