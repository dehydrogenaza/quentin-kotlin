package com.dehydrogenaza.quentin.dto

import java.time.LocalDateTime
import java.time.Year

data class ContestEditionWrapper(
    val err: String? = null,
    val data: EditionDetailsDto? = null,
)

class EditionDetailsDto {
    lateinit var year: Year
    lateinit var submissionDeadline: LocalDateTime
    lateinit var phase1votingDeadline: LocalDateTime
    lateinit var phase2votingDeadline: LocalDateTime
    lateinit var submissions: List<String>
    lateinit var jury: List<String>

    companion object {
        fun edition(init: EditionDetailsDto.() -> Unit): EditionDetailsDto {
            val dto = EditionDetailsDto()
            dto.init()
            return dto
        }
    }
}