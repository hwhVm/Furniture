package beini.com.furniture.ui.module;

import beini.com.furniture.ui.model.RequestModel;
import dagger.Module;
import dagger.Provides;

/**
 * Created by beini on 2017/12/11.
 */
@Module
public class FurnitureModule {
    @Provides
    public RequestModel returnRequestModel() {
        return new RequestModel();
    }
}
