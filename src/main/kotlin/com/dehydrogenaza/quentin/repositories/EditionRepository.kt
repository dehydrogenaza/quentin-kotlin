package com.dehydrogenaza.quentin.repositories

import com.dehydrogenaza.quentin.entities.ContestEdition
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import java.time.Year

interface EditionRepository : JpaRepository<ContestEdition, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, value = "contest_edition_graph")
    fun findByEditionYear(year: Year): ContestEdition?
}