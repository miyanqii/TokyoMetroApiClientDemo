package jp.miyanqii.tokyometroapiclientdemo.api.service

import io.reactivex.Single
import jp.miyanqii.tokyometroapiclientdemo.api.data.Railway
import jp.miyanqii.tokyometroapiclientdemo.api.data.Station
import jp.miyanqii.tokyometroapiclientdemo.api.data.Train
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by shuheimiyaki on 2017/12/02.
 */

interface TokyoMetroApiService {

    //https://developer.tokyometroapp.jp/documents/railway#駅情報-odpt:Station
    @GET("datapoints?rdf:type=odpt:Station")//	地物のクラス名、odpt:Station	◯
    fun getStations(
            @Query("acl:consumerKey") aclConsumerKey: String, //APIアクセス用のアクセストークン	◯
            @Query("@id") id: String, //固有識別子(ucode)
            @Query("owl:sameAs") owlSameAs: String, //固有識別子。命名ルールは、odpt.Station:TokyoMetro.路線名.駅名である。
            @Query("odpt:operator") odptOperator: String, //運行会社
            @Query("odpt:railway") odptRailway: String, //路線
            @Query("odpt:stationCode") odptStationCode: String    //駅コード
    ): Single<List<Station>>

    @GET("datapoints?rdf:type=odpt:Railway")
    fun getRailways(
            @Query("acl:consumerKey") aclConsumerKey: String, //APIアクセス用のアクセストークン	◯
            @Query("@id") id: String, //固有識別子(ucode)
            @Query("owl:sameAs") owlSameAs: String, //固有識別子。命名ルールは、odpt.Station:TokyoMetro.路線名.駅名である。
            @Query("dc:title") dcTitle: String, //運行系統名
            @Query("odpt:operator") odptOperator: String, //運行会社
            @Query("odpt:lineCode") odptLineCode: String    //路線コード
    ): Single<List<Railway>>

    @GET("datapoints?rdf:type=odpt:Train")
    fun getTrains(
            @Query("acl:consumerKey") acl_consumerKey: String, //acl:ConsumerKeyAPIアクセス用のアクセストークン◯
            @Query("@id") id: String, //URN固有識別子(ucode)
            @Query("owl:sameAs") owlSameAs: String, //URL固有識別子。命名ルールは、odpt.Train:TokyoMetro.路線名.列車番号である。
            @Query("odpt:trainNumber") odptTrainNumber: String, //xsd:string列車番号
            @Query("odpt:trainType") odptTrainType: String, //odpt:TrainType列車種別。各停(odpt.TrainType:Local)、急行(odpt.TrainType:Express)、快速(odpt.TrainType:Rapid)、特急(odpt.TrainType:LimitedExpress)など。
            @Query("odpt:railway") odptRailway: String, //odpt:Railway鉄道路線◯
            @Query("odpt:trainOwner") odptTrainOwner: String, //odpt:TrainOwner車両の所属会社
            @Query("odpt:railDirection") odptRailDirection: String, //odpt:RailDirection方面（渋谷方面行きodpt.RailDirection:TokyoMetro.Shibuyaなど。）
            @Query("odpt:delay") odptDelay: String, //xsd:integer遅延時間（秒）
            @Query("odpt:startingStation") odptStartingStation: String, //odpt:Station列車の始発駅
            @Query("odpt:terminalStation") odptTerminalStation: String, //odpt:Station列車の終着駅
            @Query("odpt:fromStation") odptFromStation: String, //odpt:Station列車が出発した駅
            @Query("odpt:toStation") odptToStation: String //odpt:Station列車が向かっている駅

    ): Single<List<Train>>

}
