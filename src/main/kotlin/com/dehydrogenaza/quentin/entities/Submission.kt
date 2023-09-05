package com.dehydrogenaza.quentin.entities

import jakarta.persistence.Entity

@Entity
class Submission(
    var edition: ContestEdition,
    var title: String,
    var description: String?,
    var author: String,
    var rpg: RPG,
    var ratings: Set<Rating> = mutableSetOf()
) : BaseEntity()
