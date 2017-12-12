package jp.miyanqii.tokyometroapiclientdemo.api.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Train (

    @SerializedName("@context")
    @Expose
    val context: String,
    @SerializedName("@type")
    @Expose
    val type: String,
    @SerializedName("@id")
    @Expose
    val id: String,
    @SerializedName("dc:date")
    @Expose
    val dcDate: String,
    @SerializedName("dct:valid")
    @Expose
    val dctValid: String,
    @SerializedName("odpt:frequency")
    @Expose
    val odptFrequency: Int,
    @SerializedName("odpt:railway")
    @Expose
    val odptRailway: String,
    @SerializedName("owl:sameAs")
    @Expose
    val owlSameAs: String,
    @SerializedName("odpt:trainNumber")
    @Expose
    val odptTrainNumber: String,
    @SerializedName("odpt:trainType")
    @Expose
    val odptTrainType: String,
    @SerializedName("odpt:delay")
    @Expose
    val odptDelay: Int,
    @SerializedName("odpt:startingStation")
    @Expose
    val odptStartingStation: String,
    @SerializedName("odpt:terminalStation")
    @Expose
    val odptTerminalStation: String,
    @SerializedName("odpt:fromStation")
    @Expose
    val odptFromStation: String,
    @SerializedName("odpt:toStation")
    @Expose
    val odptToStation: String = "",
    @SerializedName("odpt:railDirection")
    @Expose
    val odptRailDirection: String,
    @SerializedName("odpt:trainOwner")
    @Expose
    val odptTrainOwner: String

)
