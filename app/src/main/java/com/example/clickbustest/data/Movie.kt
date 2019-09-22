package com.example.clickbustest.data

import android.os.Parcel
import android.os.Parcelable

data class Movie(var title: String, var poster: String, var vote: Float,var date: String, var overview: String, var tagline: String, var vote_count: Float): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(poster)
        parcel.writeFloat(vote)
        parcel.writeString(date)
        parcel.writeString(overview)
        parcel.writeString(tagline)
        parcel.writeFloat(vote_count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }

}
