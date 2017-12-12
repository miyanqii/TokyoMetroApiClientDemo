package jp.miyanqii.tokyometroapiclientdemo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.miyanqii.tokyometroapiclientdemo.api.data.Railway
import jp.miyanqii.tokyometroapiclientdemo.databinding.FragmentMainBinding

class RailwayFragment : Fragment() {

    lateinit var b: FragmentMainBinding
    lateinit var railway: Railway

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        railway = arguments.getParcelable<Railway>(ARG_RAILWAY)

        b = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        b.sectionLabel.text = railway.toString()
        return b.root
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
