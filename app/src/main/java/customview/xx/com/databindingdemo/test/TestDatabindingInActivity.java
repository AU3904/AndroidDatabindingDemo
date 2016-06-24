package customview.xx.com.databindingdemo.test;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;

import customview.xx.com.databindingdemo.R;
import customview.xx.com.databindingdemo.databinding.HotelDetailLayoutBinding;
import customview.xx.com.databindingdemo.model.Hotel;

/**
 * 测试点：
 * 1. 在activity中使用 databinding，
 * 2. 如果api返回 价格，前端+ 单位后，再在 textview上展示
 * 3.
 */
public class TestDatabindingInActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HotelDetailLayoutBinding hotelDetailLayoutBinding = DataBindingUtil.setContentView(this, R.layout.hotel_detail_layout);
        hotelDetailLayoutBinding.setHotel(new Hotel("希尔顿酒店", "淮海中路333号", "lllll",
                23, new ObservableField<String>("http://i2.hdslb.com/video/14/147fcf649880f0033d91da4207138374.jpg")));
    }
}
