package com.dehydrogenaza.quentin.entities

import jakarta.persistence.Entity
import jakarta.persistence.OneToMany

@Entity
class JuryMember(
    var handle: String,
    var editions: Set<ContestEdition>,
    var ratings: Set<Rating>,
) : BaseEntity()
