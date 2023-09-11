package com.dehydrogenaza.quentin.controllers

import com.dehydrogenaza.quentin.dto.EditionDetailsDto
import com.dehydrogenaza.quentin.services.EditionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/editions")
class EditionController(
    val service: EditionService,
) {
    @GetMapping("/{year}")
    fun getByYear(@PathVariable year: String): ResponseEntity<EditionDetailsDto> {
        val (err, data) = service.getBasicsByYear(year)

        return when {
            err != null -> ResponseEntity(HttpStatus.NOT_FOUND)
            data != null -> ResponseEntity.ok(data)
            else -> ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}