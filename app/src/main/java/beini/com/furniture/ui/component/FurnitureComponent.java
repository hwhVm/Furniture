package beini.com.furniture.ui.component;

import beini.com.furniture.ui.activity.MainActivity;
import beini.com.furniture.ui.module.FurnitureModule;
import dagger.Component;

/**
 * Created by beini on 2017/12/11.
 */
@Component(modules = FurnitureModule.class)
public interface FurnitureComponent {

    void inject(MainActivity mainActivity);
}
