package jp.miyanqii.tokyometroapiclientdemo.api.data

import android.os.Parcel
import android.os.Parcelable
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

) : Parcelable { //TODO replace  to @Parcelize
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createTypedArrayList(StationOrder),
            parcel.createTypedArrayList(TravelTime),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(context)
        parcel.writeString(id)
        parcel.writeString(type)
        parcel.writeString(owlSameAs)
        parcel.writeString(dcTitle)
        parcel.writeTypedList(odptStationOrder)
        parcel.writeTypedList(odptTravelTime)
        parcel.writeString(odptLineCode)
        parcel.writeString(ugRegion)
        parcel.writeString(dcDate)
        parcel.writeString(odptOperator)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Railway> {
        override fun createFromParcel(parcel: Parcel): Railway {
            return Railway(parcel)
        }

        override fun newArray(size: Int): Array<Railway?> {
            return arrayOfNulls(size)
        }
    }
}
