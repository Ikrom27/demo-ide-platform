package ru.ikrom.demo_ide_platform.ui.items

import android.provider.Settings.System.DATE_FORMAT
import android.provider.Settings.System.TIME_12_24
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

data class ProductItem(
    val id: Int,
    val name: String,
    val amount: Int,
    val date: DateUI,
    val tags: List<TagUI>
)

@JvmInline
value class TagUI(val text: String)

@JvmInline
value class DateUI(val date: String){

    constructor(timestamp: Long): this(format(timestamp))

    fun toTimestamp(): Long {
        val formatter = SimpleDateFormat(TIME_12_24, Locale.getDefault())
        val parsedDate = formatter.parse(date)
        return parsedDate?.time ?: throw IllegalArgumentException("Invalid date format: $date")
    }

    companion object {
        private fun format(timestamp: Long): String {
            val calendar = Calendar.getInstance().apply {
                timeInMillis = timestamp
            }
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH) + 1
            val year = calendar.get(Calendar.YEAR)

            return String.format(Locale.getDefault(), "%02d.%02d.%d", day, month, year)
        }
    }
}