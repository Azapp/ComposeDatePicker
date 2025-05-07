package com.vsnappy1.datepicker.enums

enum class Days(val abbreviation: String, val value: String, val number: Int) {
    MONDAY("TH 2", "Thứ 2", 2),
    TUESDAY("TH 3", "Thứ 3", 3),
    WEDNESDAY("TH 4", "Thứ 4", 4),
    THURSDAY("TH 5", "Thứ 5", 5),
    FRIDAY("TH 6", "Thứ 6", 6),
    SATURDAY("TH 7", "Thứ 7", 7),
    SUNDAY("CN", "Chủ nhật", 1);

    companion object {
        fun get(number: Int): Days {
            return when (number) {
                1 -> SUNDAY
                2 -> MONDAY
                3 -> TUESDAY
                4 -> WEDNESDAY
                5 -> THURSDAY
                6 -> FRIDAY
                else -> SATURDAY
            }
        }
    }
}