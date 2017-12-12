package jp.miyanqii.tokyometroapiclientdemo.api.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TravelTime(

    @SerializedName("odpt:fromStation")
    @Expose
    val odptFromStation: String,
    @SerializedName("odpt:toStation")
    @Expose
    val odptToStation: String,
    @SerializedName("odpt:necessaryTime")
    @Expose
    val odptNecessaryTime: Int,
    @SerializedName("odpt:trainType")
    @Expose
    val odptTrainType: String

)
