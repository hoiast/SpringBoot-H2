package tech.unike.duplicates.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Duplicate (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val input: String,
    val output: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)