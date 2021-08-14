package com.devfutech.pemrogramandasar.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Materi(val nama: String, val subMateri: List<SubMateri> = listOf()) : Parcelable