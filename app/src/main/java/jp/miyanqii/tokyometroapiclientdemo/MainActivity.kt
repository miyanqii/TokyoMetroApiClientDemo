package jp.miyanqii.tokyometroapiclientdemo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import jp.miyanqii.tokyometroapiclientdemo.api.TokyoMetroApi
import jp.miyanqii.tokyometroapiclientdemo.api.data.Railway
import jp.miyanqii.tokyometroapiclientdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var railwayApiDisposable: Disposable? = null

//    private var stationApiDisposable: Disposable? = null
//    private var trainApiDisposable: Disposable? = null

    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(b.toolbar)
    }

    private fun setUpViewPager(railways: List<Railway>) {
        b.viewPager.adapter = MainActivityPagerAdapter(supportFragmentManager, railways)
        b.tabLayout.apply {
            tabMode = TabLayout.MODE_SCROLLABLE
            setupWithViewPager(b.viewPager)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onStart() {
        super.onStart()

        railwayApiDisposable = TokyoMetroApi()
                .fetchRailways()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .doOnSubscribe { }
                .subscribe { railways ->
                    setUpViewPager(railways)
                }

//        stationApiDisposable = TokyoMetroApi()
//                .fetchStations()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .doOnSubscribe { }
//                .subscribe { stations ->
//
//                }
//
//        trainApiDisposable = TokyoMetroApi()
//                .fetchTrains()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .doOnSubscribe { }
//                .subscribe { trains ->
//
//                }

    }

    private fun hideProgress() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun showProgress() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStop() {
        super.onStop()
        railwayApiDisposable?.dispose()
    }
}
