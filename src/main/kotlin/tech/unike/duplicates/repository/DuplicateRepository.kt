package tech.unike.duplicates.repository

import org.springframework.data.jpa.repository.JpaRepository
import tech.unike.duplicates.model.Duplicate

interface DuplicateRepository: JpaRepository<Duplicate, Long> {
}