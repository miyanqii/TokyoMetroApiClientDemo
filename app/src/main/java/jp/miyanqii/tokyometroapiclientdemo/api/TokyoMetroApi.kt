package jp.miyanqii.tokyometroapiclientdemo.api

import com.google.gson.Gson

import io.reactivex.Single
import jp.miyanqii.tokyometroapiclientdemo.api.data.Railway
import jp.miyanqii.tokyometroapiclientdemo.api.data.Station
import jp.miyanqii.tokyometroapiclientdemo.api.data.Train
import jp.miyanqii.tokyometroapiclientdemo.api.service.TokyoMetroApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by shuheimiyaki on 2017/12/05.
 */

class TokyoMetroApi {

    companion object {
        private val CONSUMER_KEY = "a233c093b356f1f91cafea96d99b86352024ec77dd84690e49f9d2ca0ba9f19b"//TODO enter Consumer Key
    }

    private fun prepareRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api.tokyometroapp.jp/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    fun fetchStations(id: String = "",
                      sameAs: String = "",
                      operator: String = "",
                      railway: String = "",
                      stationCode: String = ""): Single<List<Station>> {

        return prepareRetrofit()
                .create(TokyoMetroApiService::class.java)
                .getStations(
                        aclConsumerKey = CONSUMER_KEY,
                        id = id,
                        owlSameAs = sameAs,
                        odptOperator = operator,
                        odptRailway = railway,
                        odptStationCode = stationCode)
    }

    fun fetchRailways(id: String = "",
                      sameAs: String = "",
                      title: String = "",
                      operator: String = "",
                      lineCode: String = ""): Single<List<Railway>> {

        return prepareRetrofit()
                .create(TokyoMetroApiService::class.java)
                .getRailways(
                        aclConsumerKey = CONSUMER_KEY,
                        id = id,
                        owlSameAs = sameAs,
                        dcTitle = title,
                        odptOperator = operator,
                        odptLineCode = lineCode)

    }

    fun fetchTrains(id: String = "",
                    sameAs: String = "",
                    trainNumber: String = "",
                    trainType: String = "",
                    railway: String = "",
                    trainOwner: String = "",
                    railDirection: String = "",
                    delay: String = "",
                    startingStation: String = "",
                    terminalStation: String = "",
                    fromStation: String = "",
                    toStation: String = ""):Single<List<Train>>{

        return prepareRetrofit()
                .create(TokyoMetroApiService::class.java)
                .getTrains(
                        acl_consumerKey = CONSUMER_KEY,
                        id = id,
                        owlSameAs = sameAs,
                        odptTrainNumber = trainNumber,
                        odptTrainType = trainType,
                        odptRailway = railway,
                        odptTrainOwner = trainOwner,
                        odptRailDirection = railDirection,
                        odptDelay = delay,
                        odptStartingStation = startingStation,
                        odptTerminalStation = terminalStation,
                        odptFromStation = fromStation,
                        odptToStation = toStation)
    }


}
