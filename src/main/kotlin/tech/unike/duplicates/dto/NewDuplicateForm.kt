package tech.unike.duplicates.dto

import javax.validation.constraints.NotEmpty

data class NewDuplicateForm (
    @field:NotEmpty
    val input: String,
)