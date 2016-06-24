package customview.xx.com.databindingdemo.test;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import customview.xx.com.databindingdemo.R;
import customview.xx.com.databindingdemo.databinding.MovieListRowBinding;
import customview.xx.com.databindingdemo.model.Movie;
import customview.xx.com.databindingdemo.model.MyHandlers;

/**
 * Created by aaron_lu on 6/21/16.
 */
public class TestActivity extends Activity {
    public String imageUrl = "http://pic3.zhongsou.com/image/3806713114fbbf99f64.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieListRowBinding movieListRowBinding = DataBindingUtil.setContentView(this, R.layout.movie_list_row);
        movieListRowBinding.setMovie(new Movie("22", "33", "44"));
//        movieListRowBinding.setHandlers(new MyHandlers());
//        ImageView imageView = (ImageView) findViewById(R.id.image);
//        Picasso.with(imageView.getContext())
//                .load(imageUrl)
//                .placeholder(R.mipmap.ic_launcher)
//                .into(imageView);
    }
}
