package customview.xx.com.databindingdemo;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import customview.xx.com.databindingdemo.databinding.FoodDetailLayoutBinding;
import customview.xx.com.databindingdemo.model.Food;

/**
 * Created by aaron_lu on 6/21/16.
 */
public class FoodDetailFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater mInflater = LayoutInflater.from(getActivity());
        FoodDetailLayoutBinding foodDetailLayoutBinding = DataBindingUtil.inflate(mInflater, R.layout.food_detail_layout, container, false);
        foodDetailLayoutBinding.setFood(new Food("椒麻鸡", "椒麻鸡是一道流传于新疆的传统名菜。主料是鸡肉，主要烹饪工艺是煮。成品麻醇咸鲜，质地软嫩，清爽可口。我国饮食文化源远流长，要说用鸡烹制佳肴就不下百种，其中具有新疆风味的“椒麻鸡”，称得上是独树一帜",
                "http://a.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=2d7d048781cb39dbd5cd6f04b17f6241/7acb0a46f21fbe099bdaa3796b600c338644add3.jpg"));
        return foodDetailLayoutBinding.getRoot();
    }
}
