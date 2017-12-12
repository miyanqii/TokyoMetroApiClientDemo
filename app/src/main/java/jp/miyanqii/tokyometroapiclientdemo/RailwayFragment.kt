package jp.miyanqii.tokyometroapiclientdemo

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import jp.miyanqii.tokyometroapiclientdemo.api.TokyoMetroApi
import jp.miyanqii.tokyometroapiclientdemo.api.data.Railway
import jp.miyanqii.tokyometroapiclientdemo.api.data.Station
import jp.miyanqii.tokyometroapiclientdemo.databinding.FragmentMainBinding

class RailwayFragment : Fragment() {

    lateinit var b: FragmentMainBinding
    lateinit var railway: Railway

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        railway = arguments.getParcelable<Railway>(ARG_RAILWAY)
        b = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        b.recycler.adapter = StationsRecyclerAdapter() //TODO Set Data
        return b.root
    }

    private var stationApiDisposable: Disposable? = null

    override fun onStart() {
        super.onStart()

        stationApiDisposable?.dispose()
        stationApiDisposable = TokyoMetroApi()
                .fetchStations()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .doOnSubscribe { }
                .subscribe { stations ->
                    //TODO Set Data
                }
    }

    override fun onStop() {
        super.onStop()
        stationApiDisposable?.dispose()
    }

    companion object {
        private val ARG_RAILWAY = "railway"

        fun newInstance(railway: Railway): RailwayFragment {
            return RailwayFragment().apply {
                arguments = Bundle().apply { putParcelable(ARG_RAILWAY, railway) }
            }
        }
    }
}

class StationsRecyclerAdapter(val stations: List<Station> = emptyList()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

        val station = stations.get(position)

        (holder as StationsViewHolder).b.setVariable(BR.station, station)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return StationsViewHolder(
                LayoutInflater.from(parent?.context)
                        .inflate(R.layout.recycler_item_station, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return stations.size
    }

}

class StationsViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    val b: ViewDataBinding = DataBindingUtil.bind(itemView)
}
