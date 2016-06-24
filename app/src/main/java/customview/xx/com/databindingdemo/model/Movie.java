package customview.xx.com.databindingdemo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import customview.xx.com.databindingdemo.BR;

/**
 * Created by aaron_lu on 6/21/16.
 */
public class Movie extends BaseObservable {

    @Bindable
    public String title;

    @Bindable
    public String genre;

    @Bindable
    public String year;

    public Movie(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
        notifyPropertyChanged(BR.year);
    }
}
