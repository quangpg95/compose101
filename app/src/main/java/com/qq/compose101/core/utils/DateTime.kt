package com.qq.compose101.core.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun Calendar.toDisplay(pattern: String = "MMM d, yyyy"): String {
    return try {
        val dateFormat = SimpleDateFormat(pattern, Locale.US)
        dateFormat.format(this.time)
    } catch (ex: Throwable) {
        "Wrong Patern"
    }
}