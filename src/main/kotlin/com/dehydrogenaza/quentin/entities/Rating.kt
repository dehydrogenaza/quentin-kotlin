package com.dehydrogenaza.quentin.entities

import jakarta.persistence.Basic
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne

@Entity
class Rating(
    @Lob @Basic(fetch = FetchType.LAZY)
    var comment: String,

    var phase1Score: Int,
    var phase2Score: Int,

    @ManyToOne
    var juror: Juror,

    @ManyToOne
    var submission: Submission,
) : BaseEntity()
