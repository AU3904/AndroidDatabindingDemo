package customview.xx.com.databindingdemo.base;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import customview.xx.com.databindingdemo.R;
import customview.xx.com.databindingdemo.databinding.MenuListItemBinding;
import customview.xx.com.databindingdemo.model.OperMenu;

/**
 * Created by aaron_lu on 6/13/16.
 */
public class MainActivity extends Activity {


    private ArrayList<OperMenu> operMenuArrayList = new ArrayList<>();
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        setContentView(R.layout.main_activity);
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(new MenuAdapter());
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OperMenu operMenu = operMenuArrayList.get(position);
                switch (operMenu.id) {
                    case 0:
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("databinding://test_databinding_activity"));
                        startActivity(intent);
                        break;
                    case 7:
                        Intent inten1t = new Intent(Intent.ACTION_VIEW, Uri.parse("databinding://test_activity"));
                        startActivity(inten1t);
                        break;
                    case 3:
                        Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("databinding://list_databinding_activity"));
                        startActivity(intent3);
                        break;
                    case 1:
                        Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("databinding://fragment_databinding_activity"));
                        startActivity(intent4);
                        break;
                    case 4:
                        Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("databinding://recyclerview_databinding_activity"));
                        startActivity(intent5);
                        break;
                    case 5:
                        Intent intent6 = new Intent(Intent.ACTION_VIEW, Uri.parse("databinding://views_withids_activity"));
                        startActivity(intent6);
                        break;
                    case 6:
                        Intent intent7 = new Intent(Intent.ACTION_VIEW, Uri.parse("databinding://list_databinding_activity"));
                        startActivity(intent7);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void initData() {
        operMenuArrayList.add(new OperMenu("Activity & 自定义绑定逻辑", 0));
        operMenuArrayList.add(new OperMenu("Fragment", 1));
        operMenuArrayList.add(new OperMenu("ListView item & 自定义View", 3));
        operMenuArrayList.add(new OperMenu("RecycleView item & Observable Data", 4));
        operMenuArrayList.add(new OperMenu("View with IDs", 5));
        operMenuArrayList.add(new OperMenu("Custom Setters", 6));
        operMenuArrayList.add(new OperMenu("任意线程更新UI", 6));//不推荐在listview or recyclerView中使用

        operMenuArrayList.add(new OperMenu("自定义", 7));
    }

    

    class MenuAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return operMenuArrayList.size();
        }

        @Override
        public OperMenu getItem(int position) {
            return operMenuArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final OperMenu item = operMenuArrayList.get(position);
            MenuListItemBinding binding = null;
            if (convertView == null) {
                binding = DataBindingUtil.inflate(LayoutInflater.from(getApplicationContext()), R.layout.menu_list_item, parent, false);
                convertView = binding.getRoot();
                convertView.setTag(binding);
            } else {
                binding = (MenuListItemBinding) convertView.getTag();
            }
            binding.setMenu(item);
            return convertView;
        }
    }
}
