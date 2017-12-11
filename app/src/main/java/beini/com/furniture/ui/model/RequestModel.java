package beini.com.furniture.ui.model;

import android.support.annotation.NonNull;

import beini.com.furniture.net.RxNetUtil;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by beini on 2017/10/19.
 */

public class RequestModel {

    /**
     * 统一接口
     */
    //普通post请求
    public void sendRequest(@NonNull final String url, @NonNull final Object request, @NonNull Scheduler scheduler,
                            @NonNull final Consumer<ResponseBody> subscriber, Consumer<Throwable> consumer) {
        RxNetUtil.getSingleton().sendRequestReturnResponseBody(url, request).observeOn(scheduler).subscribeOn(Schedulers.io()).subscribe(subscriber, consumer);
    }


}
