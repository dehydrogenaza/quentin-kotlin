package com.dehydrogenaza.quentin.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDateTime
import java.time.Year

@Entity
class ContestEdition(
    var editionYear: Year,
    var submissionDeadline: LocalDateTime,
    var phase1votingDeadline: LocalDateTime,
    var phase2votingDeadline: LocalDateTime,

    @JsonManagedReference
    @OneToMany(mappedBy = "edition")
    var submissions: MutableSet<Submission>,

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
        name = "Contest_Jury",
        joinColumns = [ JoinColumn(name = "contest_id") ],
        inverseJoinColumns = [ JoinColumn(name = "juror_id") ]
    )
    var jury: MutableSet<Juror>,
) : BaseEntity()