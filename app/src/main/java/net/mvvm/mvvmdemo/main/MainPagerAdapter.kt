package net.mvvm.mvvmdemo.main

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup


class MainPagerAdapter(/*装有view的集合*/
        private val mViewList: List<View>?, private val mTabList: List<String>?) : PagerAdapter() {
    /**
     * 获取当前view的方法
     */
    internal var currentView: View? = null
        private set

    override fun getCount(): Int {
        return mViewList?.size ?: 0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(mViewList!![position])
        return mViewList[position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(mViewList!![position])
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (mTabList == null) {
            null
        } else mTabList[position]
    }

    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        super.setPrimaryItem(container, position, `object`)
        if (mViewList!!.isNotEmpty()) {
            currentView = mViewList[position]
        }
    }
}
