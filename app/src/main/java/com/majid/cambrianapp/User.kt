package com.majid.cambrianapp

import android.os.Parcel
import android.os.Parcelable


data class User(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val fcmToken: String = "",
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(phone)
        parcel.writeString(fcmToken)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun writeToParcel(dest: Parcel?, flags: Int) = with(dest){
        this?.writeString(id)
        this?.writeString(name)
        this?.writeString(email)
        this?.writeString(phone)
        this?.writeString(fcmToken)

    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }


}