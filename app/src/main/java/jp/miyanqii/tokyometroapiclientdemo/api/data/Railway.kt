package jp.miyanqii.tokyometroapiclientdemo.api.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Railway(

        @SerializedName("@context")
    @Expose
    val context: String,
        @SerializedName("@id")
    @Expose
    val id: String,
        @SerializedName("@type")
    @Expose
    val type: String,
        @SerializedName("owl:sameAs")
    @Expose
    val owlSameAs: String,
        @SerializedName("dc:title")
    @Expose
    val dcTitle: String,
        @SerializedName("odpt:stationOrder")
    @Expose
    val odptStationOrder: List<StationOrder> = emptyList(),
        @SerializedName("odpt:travelTime")
    @Expose
    val odptTravelTime: List<TravelTime> = emptyList(),
        @SerializedName("odpt:lineCode")
    @Expose
    val odptLineCode: String,
        @SerializedName("ug:region")
    @Expose
    val ugRegion: String,
        @SerializedName("dc:date")
    @Expose
    val dcDate: String,
        @SerializedName("odpt:operator")
    @Expose
    val odptOperator: String

)
