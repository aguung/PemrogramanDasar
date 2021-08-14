package com.devfutech.pemrogramandasar.utils

import android.content.Context
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.URLSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.HtmlCompat

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun String?.toHtml(): Spanned {
    this ?: return SpannableString("")
    // Replace tags with unknown ones so ListTagHandler will be used
    val formattedHtml = this
        .replace("(?i)<ul[^>]*>".toRegex(), "<${StringUtils.UL_TAG}>")
        .replace("(?i)</ul>".toRegex(), "</${StringUtils.UL_TAG}>")
        .replace("(?i)<ol[^>]*>".toRegex(), "<${StringUtils.OL_TAG}>")
        .replace("(?i)</ol>".toRegex(), "</${StringUtils.OL_TAG}>")
        .replace("(?i)<li[^>]*>".toRegex(), "<${StringUtils.LI_TAG}>")
        .replace("(?i)</li>".toRegex(), "</${StringUtils.LI_TAG}>")

    return HtmlCompat.fromHtml(
        formattedHtml,
        HtmlCompat.FROM_HTML_MODE_LEGACY,
        null,
        ListTagHandler()
    )
}

fun TextView.handleUrlClicks(onClicked: ((Map<String, String>) -> Unit)? = null) {
    text = SpannableStringBuilder.valueOf(text).apply {
        getSpans(0, length, URLSpan::class.java).forEach {
            setSpan(
                object : ClickableSpan() {
                    override fun onClick(widget: View) {
                        val data = mutableMapOf<String, String>()
                        data["video"] = it.url.split("?").last()
                        onClicked?.invoke(data)
                    }
                },
                getSpanStart(it),
                getSpanEnd(it),
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE
            )
            removeSpan(it)
        }
    }
    movementMethod = LinkMovementMethod.getInstance()
}