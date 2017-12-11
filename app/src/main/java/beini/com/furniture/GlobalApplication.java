package beini.com.furniture;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

//import beini.com.dailyapp.bean.MyObjectBox;
//import io.objectbox.BoxStore;

/**
 * Created by beini on 2017/10/24.
 */

public class GlobalApplication extends Application {
    private static GlobalApplication INSTANCE;
//    private BoxStore boxStore;

//    public BoxStore getBoxStore() {
//        return boxStore;
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
//        boxStore = MyObjectBox.builder().androidContext(this).build();
        Fresco.initialize(getInstance());
    }

    public static GlobalApplication getInstance() {
        return INSTANCE;
    }

}
