package beini.com.furniture.ui.fragments.user;


import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;

import beini.com.furniture.R;
import beini.com.furniture.bind.ContentView;
import beini.com.furniture.bind.ViewInject;
import beini.com.furniture.ui.fragments.BaseFragment;


/**
 * Create  by beini  2017/12/11
 */
@ContentView(R.layout.fragment_login)
public class LoginFragment extends BaseFragment {
    @ViewInject(R.id.image_demo)
    SimpleDraweeView image_demo;

    @Override
    public void init() {
        Uri uri = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1512992068986&di=019d47c4fa05cc92a6fd45603a5cc911&imgtype=0&src=http%3A%2F%2Fa2.att.hudong.com%2F43%2F87%2F20300543669437145007874802107.jpg");
//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                .setUri(uri)
//                .setTapToRetryEnabled(true)//点击重试
//                .setOldController(image_demo.getController())
//                .build();
        image_demo.setImageURI(uri);

    }

    @Override
    protected void hiddenChanged(boolean hidden) {

    }
}
