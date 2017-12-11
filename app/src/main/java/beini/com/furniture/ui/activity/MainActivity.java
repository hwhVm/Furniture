package beini.com.furniture.ui.activity;

import javax.inject.Inject;

import beini.com.furniture.ui.component.DaggerFurnitureComponent;
import beini.com.furniture.ui.component.FurnitureComponent;
import beini.com.furniture.ui.fragments.user.LoginFragment;
import beini.com.furniture.ui.model.RequestModel;
import beini.com.furniture.ui.module.FurnitureModule;

public class MainActivity extends BaseActivity {
    @Inject
    RequestModel requestModel;

    @Override
    public void init() {
        replaceFragment(LoginFragment.class, null);
        FurnitureComponent build = DaggerFurnitureComponent.builder().furnitureModule(new FurnitureModule()).build();
        build.inject(this);
    }


}
