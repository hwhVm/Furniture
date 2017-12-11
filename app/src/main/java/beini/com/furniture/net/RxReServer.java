package beini.com.furniture.net;

import android.support.annotation.NonNull;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by beini on 2017/4/14.
 */

public interface RxReServer {
    /**
     * get
     */
    //缓存
    @GET("{url}")
    Flowable<ResponseBody> requestStandardGet(@Path("url") String url);

    /**
     * post
     */

    //标准模式
    @FormUrlEncoded
    @POST("{url}")
    Flowable<ResponseBody> requestStandardPost(@Path("url") String url);

    //多参数 @QueryMap
    @POST("{url}")
    Call<String> queryMap(@Path("url") String url, @QueryMap Map<String, String> maps);

    //json模式
    @POST("{url}")
    @NonNull
    Flowable<ResponseBody> sendRequestReturnResponseBody(@Path("url") String url,@Body Object baseRequestJson);

}

