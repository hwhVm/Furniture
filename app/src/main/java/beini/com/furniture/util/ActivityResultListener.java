package beini.com.furniture.util;

import android.content.Intent;

/**
 * Created by beini on 2017/3/15.
 */

public interface ActivityResultListener {
    void resultCallback(int requestCode, int resultCode, Intent data);
}
