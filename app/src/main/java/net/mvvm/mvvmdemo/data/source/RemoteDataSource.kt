package net.mvvm.mvvmdemo.data.source

import android.util.Log
import com.google.gson.Gson
import net.mvvm.mvvmdemo.data.DataSource
import net.mvvm.mvvmdemo.data.bean.NewsList
import net.mvvm.mvvmdemo.http.ApiService
import net.mvvm.mvvmdemo.http.InfoCallBack
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * <p>类说明</p>
 * @author liuzhaohong 2018/4/25 13:38
 * @version V1.0
 * @name RemoteDataSource
 */
class RemoteDataSource : DataSource {
    val TAG = "RemoteDataSource"

    override fun getRandData(category: String, callback: InfoCallBack<NewsList>) {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://gank.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val apiService = retrofit.create(ApiService::class.java);
        val call = apiService.executeGet(category)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                Log.e(TAG, t?.localizedMessage)
                callback.onError("连接服务器失败")
            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                val result = response?.body()?.string()
                if (result == null) {
                    callback.onError("返回数据为空")
                    return
                }
                Log.i(TAG, result)
                callback.onSuccess(Gson().fromJson(result, NewsList::class.java))
            }

        })


    }

}