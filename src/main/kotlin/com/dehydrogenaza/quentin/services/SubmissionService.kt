package com.dehydrogenaza.quentin.services

import com.dehydrogenaza.quentin.dto.SubmissionBasicsDto
import com.dehydrogenaza.quentin.dto.SubmissionFormDto
import com.dehydrogenaza.quentin.entities.Submission
import com.dehydrogenaza.quentin.repositories.EditionRepository
import com.dehydrogenaza.quentin.repositories.SubmissionRepository
import org.springframework.stereotype.Service
import java.time.Year
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Service
class SubmissionService(
    val editionRepo: EditionRepository,
    val submissionRepo: SubmissionRepository,
) {
    fun getBasicsById(id: Long): SubmissionBasicsDto? {
        return submissionRepo.findById(id)
            .toDto()
    }

    fun addSubmission(form: SubmissionFormDto): SubmissionBasicsDto? {
        val year = Year.of(form.year)

        return editionRepo.findByEditionYear(year)
            ?.let { edition ->
                 val submission = Submission(
                    title = form.title,
                    description = form.description,
                    author = form.author,
                    edition = edition,
                    ratings = mutableSetOf()
                )
                val saved = submissionRepo.saveAndFlush(submission)
                edition.submissions += saved

                return@let saved
            }?.toDto()
    }

    private fun Optional<Submission>.toDto(): SubmissionBasicsDto? =
        this.map { it.toDto() }
            .getOrNull()

    private fun Submission.toDto(): SubmissionBasicsDto =
        SubmissionBasicsDto(
            this.id,
            this.title,
            this.author,
            this.description
        )
}
