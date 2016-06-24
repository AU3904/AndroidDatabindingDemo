package customview.xx.com.databindingdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import customview.xx.com.databindingdemo.model.Hotel;
import customview.xx.com.databindingdemo.model.Movie;

/**
 * Created by aaron_lu on 6/21/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {
    private static final String TAG = RecyclerViewAdapter.class.getSimpleName();
    private ArrayList<Object> mDataArrayList = new ArrayList<>();

    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<Object> movieList) {
        this.mContext = context;
        mDataArrayList = movieList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = null;
        if (viewType == R.layout.hotel_item_layout) {
            viewDataBinding =
                    DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.hotel_item_layout, parent, false);
        } else if (viewType == R.layout.movie_list_row) {
            viewDataBinding =
                    DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.movie_list_row, parent, false);
        }

        return CustomViewHolder.create(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.bindTo(mDataArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object item = mDataArrayList.get(position);
        if (item instanceof Hotel) {
            return R.layout.hotel_item_layout;
        } else if (item instanceof Movie) {
            return R.layout.movie_list_row;
        }
        throw new RuntimeException("invalid obj");
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ViewDataBinding mViewDataBinding;
        private Movie mMovie;

        private CustomViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            mViewDataBinding = viewDataBinding;
        }

        static CustomViewHolder create(ViewDataBinding viewDataBinding) {
            return new CustomViewHolder(viewDataBinding);
        }

        public void bindTo(Object o) {
            if (o instanceof Movie) {
                mViewDataBinding.setVariable(customview.xx.com.databindingdemo.BR.movie, o);
                mViewDataBinding.setVariable(customview.xx.com.databindingdemo.BR.viewHolder, this);

                this.mMovie = (Movie) o;

            } else if (o instanceof Hotel) {
                mViewDataBinding.setVariable(customview.xx.com.databindingdemo.BR.hotel, o);
            }

            mViewDataBinding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            if (mMovie == null || mViewDataBinding == null) return;

            switch (v.getId()) {
                case R.id.title:
                    Toast.makeText(mViewDataBinding.getRoot().getContext(), mMovie.title, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.genre:
                    Toast.makeText(mViewDataBinding.getRoot().getContext(), mMovie.genre, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.year:
                    Toast.makeText(mViewDataBinding.getRoot().getContext(), mMovie.year, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }
}
