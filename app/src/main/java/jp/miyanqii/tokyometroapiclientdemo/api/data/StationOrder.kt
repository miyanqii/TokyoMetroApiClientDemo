package jp.miyanqii.tokyometroapiclientdemo.api.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class StationOrder(

        @SerializedName("odpt:station")
        @Expose
        var odptStation: String,
        @SerializedName("odpt:index")
        @Expose
        var odptIndex: Int

) : Parcelable { //TODO replace to @Parcelize
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(odptStation)
        parcel.writeInt(odptIndex)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StationOrder> {
        override fun createFromParcel(parcel: Parcel): StationOrder {
            return StationOrder(parcel)
        }

        override fun newArray(size: Int): Array<StationOrder?> {
            return arrayOfNulls(size)
        }
    }
}
