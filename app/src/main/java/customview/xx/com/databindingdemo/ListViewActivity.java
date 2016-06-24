package customview.xx.com.databindingdemo;

import android.app.Activity;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import customview.xx.com.databindingdemo.model.Hotel;

/**
 * Created by aaron_lu on 6/21/16.
 */
public class ListViewActivity extends Activity {

    private ListView mListView;
    private ArrayList<Hotel> mHotelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        setContentView(R.layout.main_activity);
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(new HotelAdapter());
    }

    private void initData() {
        mHotelArrayList.add(new Hotel("希尔顿酒店", "淮海中路333号", "lllll",
                23, new ObservableField<String>("http://i2.hdslb.com/video/14/147fcf649880f0033d91da4207138374.jpg")));
        mHotelArrayList.add(new Hotel("希尔顿酒店", "淮海中路333号", "lllll",
                23, new ObservableField<String>("http://i2.hdslb.com/video/14/147fcf649880f0033d91da4207138374.jpg")));
        mHotelArrayList.add(new Hotel("希尔顿酒店", "淮海中路333号", "lllll",
                23, new ObservableField<String>("http://i2.hdslb.com/video/14/147fcf649880f0033d91da4207138374.jpg")));
        mHotelArrayList.add(new Hotel("希尔顿酒店", "淮海中路333号", "lllll",
                23, new ObservableField<String>("http://i2.hdslb.com/video/14/147fcf649880f0033d91da4207138374.jpg")));
        mHotelArrayList.add(new Hotel("希尔顿酒店", "淮海中路333号", "lllll",
                23, new ObservableField<String>("http://i2.hdslb.com/video/14/147fcf649880f0033d91da4207138374.jpg")));
    }


    class HotelAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mHotelArrayList.size();
        }

        @Override
        public Hotel getItem(int position) {
            return mHotelArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final Hotel item = mHotelArrayList.get(position);

            if (convertView == null) {
                convertView = new HotelItemView(getApplicationContext());
            }

            if (convertView instanceof HotelItemView) {
                ((HotelItemView) convertView).BindingData(item);
            }

            return convertView;
        }
    }
}
