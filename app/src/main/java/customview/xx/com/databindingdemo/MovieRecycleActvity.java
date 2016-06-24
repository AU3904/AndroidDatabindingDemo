package customview.xx.com.databindingdemo;

import android.app.Activity;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import customview.xx.com.databindingdemo.model.Hotel;
import customview.xx.com.databindingdemo.model.Movie;
import customview.xx.com.databindingdemo.utils.RecyclerItemClickListener;

/**
 * Created by aaron_lu on 6/21/16.
 */
public class MovieRecycleActvity extends Activity {

    private RecyclerView recyclerView;
    private ArrayList<Object> mDataList = new ArrayList<>();
    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_content_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        findViewById(R.id.btn_update1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 老的更新方式
                 */
//                mDataList.set(0, new Movie("hahhhaha", "bbbbbbbbbbb", "2342342"));
//                mAdapter.notifyItemChanged(0);


                Movie movie = (Movie) mDataList.get(0);
                movie.setYear("11111111");
                movie.setTitle("hahhhaha");
                movie.setGenre("bbbbbbbbbbb");
            }
        });

        findViewById(R.id.btn_update2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hotel hotel = (Hotel) mDataList.get(1);
                hotel.imageUrl.set("http://img4.imgtn.bdimg.com/it/u=355275914,1267690550&fm=15&gp=0.jpg");
            }
        });

        findViewById(R.id.btn_update3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Movie movie = (Movie) mDataList.get(0);
                        movie.setYear("00000000000");
                    }
                }).start();
            }
        });


        mAdapter = new RecyclerViewAdapter(this, mDataList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (mDataList.get(position) instanceof Movie) {
                            Movie movie = (Movie) mDataList.get(position);
                            Toast.makeText(getApplicationContext(), "position:" + position + "," + movie.title, Toast.LENGTH_SHORT).show();
                        } else if (mDataList.get(position) instanceof Hotel) {
                            Hotel hotel = (Hotel) mDataList.get(position);
                            Toast.makeText(getApplicationContext(), "position:" + position + "," + hotel.name, Toast.LENGTH_SHORT).show();
                        }
                    }
                }));

        prepareMovieData();
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        mDataList.add(movie);

        mDataList.add(new Hotel("香格里拉大酒店", "安化路切鲁路路口", "http://d2.lashouimg.com/tg/guilin/201212/31/wyn006.jpg",
                2345, new ObservableField<String>("http://d2.lashouimg.com/tg/guilin/201212/31/wyn006.jpg")));

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        mDataList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        mDataList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        mDataList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        mDataList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        mDataList.add(movie);

        mDataList.add(new Hotel("位于纳大酒店", "安化路XXXX路路口", "http://e.hiphotos.baidu.com/nuomi/pic/item/d50735fae6cd7b89aaf0a2f70c2442a7d9330e21.jpg",
                2345, new ObservableField<String>("http://e.hiphotos.baidu.com/nuomi/pic/item/d50735fae6cd7b89aaf0a2f70c2442a7d9330e21.jpg")));

        movie = new Movie("Up", "Animation", "2009");
        mDataList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        mDataList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        mDataList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        mDataList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        mDataList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        mDataList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        mDataList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        mDataList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        mDataList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        mDataList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}
