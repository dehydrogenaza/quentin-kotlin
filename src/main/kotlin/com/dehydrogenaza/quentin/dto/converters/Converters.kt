package com.dehydrogenaza.quentin.dto.converters

import com.dehydrogenaza.quentin.dto.EditionDetailsDto
import com.dehydrogenaza.quentin.entities.BaseEntity
import com.dehydrogenaza.quentin.entities.ContestEdition
import com.dehydrogenaza.quentin.entities.Submission
import org.springframework.stereotype.Component

interface Converter<in S : BaseEntity, out T> {
    fun S?.toDto(): T?
}

@Component
class EditionConverter : Converter<ContestEdition, EditionDetailsDto> {
    override fun ContestEdition?.toDto(): EditionDetailsDto? = this?.let {
        EditionDetailsDto.edition {
            year = it.editionYear
            submissionDeadline = it.submissionDeadline
            phase1votingDeadline = it.phase1votingDeadline
            phase2votingDeadline = it.phase2votingDeadline
            submissions = it.submissions.map { sub -> sub.header }
            jury = it.jury.map { juror -> juror.handle }
        }
    }

    private val Submission.header get() =
            "[$id] $title by $author - " +
                    if (description == null) "(no description)" else description
}