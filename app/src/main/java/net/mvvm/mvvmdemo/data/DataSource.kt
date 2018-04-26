package net.mvvm.mvvmdemo.data

import net.mvvm.mvvmdemo.data.bean.NewsList
import net.mvvm.mvvmdemo.http.InfoCallBack

/**
 * <p>类说明</p>
 * @author liuzhaohong 2018/4/25 13:38
 * @version V1.0
 * @name DataSource
 */
interface DataSource {
    public fun getRandData(category: String, callback: InfoCallBack<NewsList>)
}