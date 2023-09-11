package com.dehydrogenaza.quentin.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.Entity
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany

@Entity
class Juror(
    var handle: String,

    @JsonBackReference
    @ManyToMany(mappedBy = "jury")
    var editions: MutableSet<ContestEdition>,

    @OneToMany(mappedBy = "juror")
    var ratings: MutableSet<Rating>,
) : BaseEntity()
