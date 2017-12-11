package beini.com.furniture.net;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import beini.com.furniture.constant.NetConstants;
import beini.com.furniture.util.BLog;
import io.reactivex.Flowable;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by beini on 2017/12/11.
 */

public class RxNetUtil {
    private static RxNetUtil instance;
    private static Retrofit retrofit;
    private static RxReServer rxReServer;
    private static int DEFAULT_TIMEOUT = 5;

    public static RxNetUtil getSingleton() {
        synchronized (RxNetUtil.class) {
            if (instance == null) {
                instance = new RxNetUtil();
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> BLog.h(message));
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//日志级别,NONE BASIC HEADERS BODY
                OkHttpClient client = new OkHttpClient//添加头信息，cookie等
                        .Builder()
//                      .retryOnConnectionFailure()//重试机制
                        .connectTimeout(8, TimeUnit.SECONDS) // 设置连接超时时间
//                      .writeTimeout(8, TimeUnit.SECONDS)// 设置写入超时时间
//                      .readTimeout(8, TimeUnit.SECONDS)// 设置读取数据超时时间
//                      .cookieJar(returnCookieJar())
//                      .addInterceptor(returnGeneralHeadInterceptor())// 添加通用的Header
//                        .addInterceptor(returnCacheInterceptor())
                        .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .addInterceptor(httpLoggingInterceptor)
                        .build();
                retrofit = new Retrofit.Builder()
                        .client(client)
                        .baseUrl(NetConstants.ROOT_URL)
                        .addConverterFactory(GsonConverterFactory.create())//compile 'com.squareup.retrofit2:converter-gson:2.0.2'
                        // 添加Retrofit到RxJava的转换器
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                      .addConverterFactory(ScalarsConverterFactory.create())//普通类型
                        .build();

                rxReServer = retrofit.create(RxReServer.class);
            }
        }
        return instance;
    }

    /**
     * 通用方法
     *
     * @param url
     * @param object
     * @return
     * @throws InterruptedException
     */
    public Flowable<ResponseBody> sendRequestReturnResponseBody(@NonNull final String url, @NonNull final Object object) {
        return rxReServer.sendRequestReturnResponseBody(url, object);
    }

}
