package pt.ulusofona.cm.kotlin.challenge.models

import java.time.LocalDate
import java.time.Period
import java.time.ZoneId
import java.util.*

class Data(date: Date) {
    var localDate: LocalDate

    init {
        localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
    }

    override fun toString(): String {
        return "${ localDate.dayOfMonth.toString().padStart(2, '0') }-" +
                "${ localDate.monthValue.toString().padStart(2, '0') }-${ localDate.year }"
    }

    fun anosAteHoje(): Int {
        val hoje = Calendar.getInstance().time
            .toInstant().atZone(ZoneId.systemDefault()).toLocalDate()

        return Period.between(localDate, hoje).years
    }
}