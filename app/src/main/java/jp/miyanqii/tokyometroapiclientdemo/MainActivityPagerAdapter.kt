package jp.miyanqii.tokyometroapiclientdemo

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import jp.miyanqii.tokyometroapiclientdemo.api.data.Railway

class MainActivityPagerAdapter(fm: FragmentManager, val railways: List<Railway>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return RailwayFragment.newInstance(railways.get(position))
    }

    override fun getCount(): Int {
        return railways.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return railways.get(position).dcTitle
    }
}
