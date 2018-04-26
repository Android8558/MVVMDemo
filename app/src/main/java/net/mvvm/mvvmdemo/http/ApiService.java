package net.mvvm.mvvmdemo.http;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * <p>类说明</p>
 *
 * @author liuzhaohong 2018/4/25 11:16
 * @version V1.0
 * @name ApiService
 */

public interface ApiService {

    @GET("api/random/data/{category}/10")
    Call<ResponseBody> executeGet(@Path("category") String category);

}
