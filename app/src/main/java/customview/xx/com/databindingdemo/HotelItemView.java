package customview.xx.com.databindingdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import customview.xx.com.databindingdemo.databinding.HotelItemLayoutBinding;
import customview.xx.com.databindingdemo.model.Hotel;

/**
 * Created by aaron_lu on 6/21/16.
 */
public class HotelItemView extends LinearLayout {

    private Context mContext;
    private HotelItemLayoutBinding hotelItemLayoutBinding;

    public HotelItemView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public HotelItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        hotelItemLayoutBinding = DataBindingUtil.inflate(mInflater, R.layout.hotel_item_layout, null, false);
        addView(hotelItemLayoutBinding.getRoot());
    }

    private HotelItemLayoutBinding getHotelItemLayoutBinding() {
        return this.hotelItemLayoutBinding;
    }

    public void BindingData(Hotel hotel) {
        hotelItemLayoutBinding.setHotel(hotel);
    }
}
