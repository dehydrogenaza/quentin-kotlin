package com.dehydrogenaza.quentin.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class Submission(
    var title: String,
    var description: String?,
    var author: String,

    @ManyToOne
    var rpg: RPG? = null,

    @JsonBackReference
    @ManyToOne
    var edition: ContestEdition,

    @OneToMany(mappedBy = "submission")
    var ratings: MutableSet<Rating>
) : BaseEntity()
