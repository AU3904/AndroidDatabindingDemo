package customview.xx.com.databindingdemo.base;

import android.app.Application;

/**
 * Created by aaron_lu on 6/22/16.
 */
public class DemoApplication extends Application {

    private static DemoApplication instance;


    public DemoApplication() {
        instance = this;
    }

    public static DemoApplication instance() {
        if (instance == null) {
            throw new IllegalStateException("Application has not been created");
        }

        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
