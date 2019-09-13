package com.kurt.core.presentation.helpers

import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.toSpannable

/**
 * Copyright 2019, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 08/29/2019
 */

fun TextView.makeTextColored(coloredText: String, colorRes: Int) {
    val spannableText = text.toSpannable()

    if (!spannableText.contains(coloredText)) {
        return
    }

    val startIndex = spannableText.indexOf(coloredText)
    val endIndex = startIndex + coloredText.length

    spannableText.setSpan(
        ForegroundColorSpan(ContextCompat.getColor(context, colorRes)),
        startIndex,
        endIndex,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    movementMethod = LinkMovementMethod.getInstance()
    setText(spannableText, TextView.BufferType.SPANNABLE)
}