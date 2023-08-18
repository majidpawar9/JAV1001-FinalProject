package com.majid.cambrianapp

import android.os.Parcel
import android.os.Parcelable

//data class
data class User(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val fcmToken: String = ""
) : Parcelable {
    // Constructor for Parcelable
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
    )

    // Write object values to the Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(phone)
        parcel.writeString(fcmToken)
    }

    // Used when you need to print the object
    override fun describeContents(): Int {
        return 0
    }

    // Write object values to the Parcel (alternative way)
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