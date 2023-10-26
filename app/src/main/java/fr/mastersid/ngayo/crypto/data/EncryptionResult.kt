package fr.mastersid.ngayo.crypto.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed interface EncryptionResult {

    @Parcelize
    data object Empty : EncryptionResult, Parcelable
    @Parcelize
    @JvmInline
    value class Encrypted( val text : String ) : EncryptionResult, Parcelable
    @Parcelize
    @JvmInline
    value class Failed(val faulty: Char) : EncryptionResult, Parcelable
}