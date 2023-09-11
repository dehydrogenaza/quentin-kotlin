package com.dehydrogenaza.quentin.controllers

import com.dehydrogenaza.quentin.dto.SubmissionBasicsDto
import com.dehydrogenaza.quentin.dto.SubmissionFormDto
import com.dehydrogenaza.quentin.services.SubmissionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/submissions")
class SubmissionController (
    val service: SubmissionService,
) {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<SubmissionBasicsDto> {
        return service.getBasicsById(id)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping
    fun postSubmission(@RequestBody form: SubmissionFormDto): ResponseEntity<SubmissionBasicsDto> {
        return service.addSubmission(form)
            ?.let { ResponseEntity(it, HttpStatus.CREATED) }
            ?: ResponseEntity(HttpStatus.BAD_REQUEST)
    }
}