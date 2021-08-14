package com.devfutech.pemrogramandasar.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SubMateri(
    val nama: String,
    val content: List<Content> = listOf(),
    val type: String? = "Bacaan",
    val image: Int? = 0
) : Parcelable