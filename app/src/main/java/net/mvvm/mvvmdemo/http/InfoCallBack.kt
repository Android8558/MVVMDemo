package net.mvvm.mvvmdemo.http

/**
 * <p>类说明</p>
 * @author liuzhaohong 2018/4/25 13:46
 * @version V1.0
 * @name InfoCallBack
 */
interface InfoCallBack<in T> {
    public fun onSuccess(data: T)

    public fun onError(str: String)
}