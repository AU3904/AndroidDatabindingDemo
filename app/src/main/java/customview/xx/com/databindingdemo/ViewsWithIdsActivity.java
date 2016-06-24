package customview.xx.com.databindingdemo;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import customview.xx.com.databindingdemo.databinding.HotelDetailLayoutBinding;
import customview.xx.com.databindingdemo.databinding.ViewWithIdLayoutBinding;
import customview.xx.com.databindingdemo.model.Hotel;

/**
 * Created by aaron_lu on 6/23/16.
 */
public class ViewsWithIdsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ViewWithIdLayoutBinding viewWithIdLayoutBinding = DataBindingUtil.setContentView(this, R.layout.view_with_id_layout);
        viewWithIdLayoutBinding.setHotel(new Hotel("希尔顿酒店", "淮海中路333号", "lllll",
                23, new ObservableField<String>("http://i2.hdslb.com/video/14/147fcf649880f0033d91da4207138374.jpg")));

        viewWithIdLayoutBinding.titleOfShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), viewWithIdLayoutBinding.titleOfShop.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
