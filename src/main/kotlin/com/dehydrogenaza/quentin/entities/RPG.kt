package com.dehydrogenaza.quentin.entities

import jakarta.persistence.Entity

@Entity
class RPG(
    var submissions: Set<Submission>,
    var system: String,
    var version: String?
) : BaseEntity()
