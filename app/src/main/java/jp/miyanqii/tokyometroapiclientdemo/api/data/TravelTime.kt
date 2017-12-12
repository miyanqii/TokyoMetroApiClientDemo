package jp.miyanqii.tokyometroapiclientdemo.api.data

import android.os.Parcel
import android.os.Parcelable
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

) : Parcelable { //TODO replace  to @Parcelize
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(odptFromStation)
        parcel.writeString(odptToStation)
        parcel.writeInt(odptNecessaryTime)
        parcel.writeString(odptTrainType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TravelTime> {
        override fun createFromParcel(parcel: Parcel): TravelTime {
            return TravelTime(parcel)
        }

        override fun newArray(size: Int): Array<TravelTime?> {
            return arrayOfNulls(size)
        }
    }
}
