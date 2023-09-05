package com.dehydrogenaza.quentin.entities

import jakarta.persistence.Entity
import java.time.LocalDateTime
import java.time.Year

@Entity
class ContestEdition(
    var year: Year,
    var submissionDeadline: LocalDateTime,
    var phase1votingDeadline: LocalDateTime,
    var phase2votingDeadline: LocalDateTime,
    var submissions: Set<Submission>,
    var jury: Set<JuryMember>,
) : BaseEntity()