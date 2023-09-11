package com.dehydrogenaza.quentin.dto

data class SubmissionBasicsDto(
    val id: Long?,
    val title: String,
    val author: String,
    val description: String?
)

data class SubmissionFormDto (
    val title: String,
    val author: String,
    val description: String?,
    val rpg: String?,
    val year: Int,
)