package com.dehydrogenaza.quentin.entities

import jakarta.persistence.Entity
import jakarta.persistence.OneToMany

@Entity
class RPG(
    var system: String,
    var version: String?,

    @OneToMany(mappedBy = "rpg")
    var submissions: MutableSet<Submission>,
) : BaseEntity()
