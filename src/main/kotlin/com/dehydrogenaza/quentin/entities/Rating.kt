package com.dehydrogenaza.quentin.entities

import jakarta.persistence.Entity
import jakarta.persistence.Lob

@Entity
class Rating(
    var edition: ContestEdition,
    var juryMember: JuryMember,
    var submission: Submission,
    @Lob var comment: String,
    var phase1Score: Int,
    var phase2Score: Int,
) : BaseEntity()
