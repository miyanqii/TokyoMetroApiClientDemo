package jp.miyanqii.tokyometroapiclientdemo.api.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class StationOrder(

    @SerializedName("odpt:station")
    @Expose
    var odptStation: String,
    @SerializedName("odpt:index")
    @Expose
    var odptIndex: Int

)
