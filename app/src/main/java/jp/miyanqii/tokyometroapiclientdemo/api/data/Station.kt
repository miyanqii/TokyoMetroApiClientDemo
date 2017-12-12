package jp.miyanqii.tokyometroapiclientdemo.api.data

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Station(

    @SerializedName("@id")
    @Expose
    val id: String,

    @SerializedName("@type")
    @Expose
    val type: String,

    @SerializedName("owl:sameAs")
    @Expose
    val owlSameAs: String,

    @SerializedName("dc:date")
    @Expose
    val dcDate: String? = null,

    @SerializedName("dc:title")
    @Expose
    val dcTitle: String,

    @SerializedName("ug:region")
    @Expose
    val ugRegion: String? = null,

    @SerializedName("odpt:operator")
    @Expose
    val odptOperator: String,

    @SerializedName("odpt:railway")
    @Expose
    val odptRailway: String,

    @SerializedName("odpt:connectingRailway")
    @Expose
    val odptConnectingRailway: List<String> = emptyList(),

    @SerializedName("odpt:facility")
    @Expose
    val odptFacility: String,

    @SerializedName("odpt:passengerSurvey")
    @Expose
    val odptPassengerSurvey: List<String>? = emptyList(),

    @SerializedName("odpt:stationCode")
    @Expose
    val odptStationCode: String,

    @SerializedName("odpt:exit")
    @Expose
    val odptExit: List<String> = emptyList(),

    @SerializedName("@context")
    @Expose
    val context: String,

    @SerializedName("geo:lat")
    @Expose
    val geoLat: Double? = null,

    @SerializedName("geo:long")
    @Expose
    val geoLong: Double? = null
    )
