package com.dehydrogenaza.quentin.repositories

import com.dehydrogenaza.quentin.entities.Submission
import org.springframework.data.jpa.repository.JpaRepository

interface SubmissionRepository : JpaRepository<Submission, Long>