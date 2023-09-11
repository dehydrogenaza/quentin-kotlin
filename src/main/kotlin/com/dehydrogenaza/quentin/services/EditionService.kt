package com.dehydrogenaza.quentin.services

import com.dehydrogenaza.quentin.dto.ContestEditionWrapper
import com.dehydrogenaza.quentin.dto.EditionDetailsDto
import com.dehydrogenaza.quentin.dto.converters.Converter
import com.dehydrogenaza.quentin.dto.converters.EditionConverter
import com.dehydrogenaza.quentin.entities.ContestEdition
import com.dehydrogenaza.quentin.repositories.EditionRepository
import org.springframework.stereotype.Service
import java.time.Year
import java.time.format.DateTimeParseException

@Service
class EditionService(
    val repo: EditionRepository,
    val converter: EditionConverter,
) : Converter<ContestEdition, EditionDetailsDto> by converter {
    fun getBasicsByYear(year: String): ContestEditionWrapper {
        return try {
            Year.parse(year).let { repo.findByEditionYear(it) }.wrap()
        } catch (e: DateTimeParseException) {
            ContestEditionWrapper(
                err = "'$year' is not a valid year."
            )
        }.also { println(it) }
    }

    private fun ContestEdition?.wrap(): ContestEditionWrapper = ContestEditionWrapper(
        err = this.toError(),
        data = this.toDto(),
    )

    private fun ContestEdition?.toError(): String? =
        if (this == null) "Could not find edition data." else null

}