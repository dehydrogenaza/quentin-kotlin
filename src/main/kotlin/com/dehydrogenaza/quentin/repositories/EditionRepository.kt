package com.dehydrogenaza.quentin.repositories

import com.dehydrogenaza.quentin.entities.ContestEdition
import org.springframework.data.jpa.repository.JpaRepository
import java.time.Year

interface EditionRepository : JpaRepository<ContestEdition, Long> {
    fun findByEditionYear(year: Year): ContestEdition?
}