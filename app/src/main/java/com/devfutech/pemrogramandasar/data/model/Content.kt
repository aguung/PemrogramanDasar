package com.devfutech.pemrogramandasar.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Content(val nama: String, val content: String? = "", val image: Int? = 0) : Parcelable
