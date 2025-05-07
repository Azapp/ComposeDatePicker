package com.vsnappy1.datepicker.data

import com.vsnappy1.datepicker.enums.Days
import com.vsnappy1.datepicker.enums.Days.FRIDAY
import com.vsnappy1.datepicker.enums.Days.MONDAY
import com.vsnappy1.datepicker.enums.Days.SATURDAY
import com.vsnappy1.datepicker.enums.Days.SUNDAY
import com.vsnappy1.datepicker.enums.Days.THURSDAY
import com.vsnappy1.datepicker.enums.Days.TUESDAY
import com.vsnappy1.datepicker.enums.Days.WEDNESDAY
import com.vsnappy1.datepicker.data.model.Month
import com.vsnappy1.extension.isLeapYear
import java.util.Calendar

internal object Constant {
    private const val repeatCount: Int = 200

    val days = listOf(
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    )

    private val monthNames = listOf(
        "Tháng 1",
        "Tháng 2",
        "Tháng 3",
        "Tháng 4",
        "Tháng 5",
        "Tháng 6",
        "Tháng 7",
        "Tháng 8",
        "Tháng 9",
        "Tháng 10",
        "Tháng 11",
        "Tháng 12",
    )

    fun getMonths(): List<String> {
        val list = mutableListOf<String>()
        for (i in 1..repeatCount) {
            list.addAll(monthNames)
        }
        return list
    }

    fun getMiddleOfMonth(): Int {
        return 12 * (repeatCount / 2)
    }

    fun getMonths(year: Int): List<Month> {
        return listOf(
            Month("Tháng 1", 31, getFirstDayOfMonth(0, year), 0),
            Month("Tháng 2", if (year.isLeapYear()) 29 else 28, getFirstDayOfMonth(1, year), 1),
            Month("Tháng 3", 31, getFirstDayOfMonth(2, year), 2),
            Month("Tháng 4", 30, getFirstDayOfMonth(3, year), 3),
            Month("Tháng 5", 31, getFirstDayOfMonth(4, year), 4),
            Month("Tháng 6", 30, getFirstDayOfMonth(5, year), 5),
            Month("Tháng 7", 31, getFirstDayOfMonth(6, year), 6),
            Month("Tháng 8", 31, getFirstDayOfMonth(7, year), 7),
            Month("Tháng 9", 30, getFirstDayOfMonth(8, year), 8),
            Month("Tháng 10", 31, getFirstDayOfMonth(9, year), 9),
            Month("Tháng 11", 30, getFirstDayOfMonth(10, year), 10),
            Month("Tháng 12", 31, getFirstDayOfMonth(11, year), 11)
        )
    }

    private fun getFirstDayOfMonth(month: Int, year: Int): Days {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, 1)
        return Days.get(calendar[Calendar.DAY_OF_WEEK])
    }

    val years = List(200) { it + Calendar.getInstance()[Calendar.YEAR] - 100 }
}