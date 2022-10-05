package tech.unike.duplicates.service

import org.springframework.stereotype.Service
import tech.unike.duplicates.dto.DuplicateView
import tech.unike.duplicates.exceptions.NotFoundException
import tech.unike.duplicates.mapper.DuplicateViewMapper
import tech.unike.duplicates.model.Duplicate
import tech.unike.duplicates.repository.DuplicateRepository
import java.util.stream.Collectors

@Service
class DuplicateService (
    private val repository: DuplicateRepository,
    private val duplicateViewMapper: DuplicateViewMapper
) {

    fun findAllView(): List<DuplicateView> {
        return repository.findAll().stream().map { duplicateViewMapper.map(it) }.collect(Collectors.toList())
    }

    fun findByIdView(id: Long): DuplicateView {
        val duplicate = this.findById(id)
        return duplicateViewMapper.map(duplicate)
    }

    fun calculateDuplicatesAndSave(input: List<Int>): DuplicateView {
        val duplicate = this.getDuplicates(input)
        return this.save(duplicate)
    }

    fun deleteById(id: Long) {
        val duplicate = this.findById(id)
        repository.delete(duplicate)
    }

    private fun findById(id: Long): Duplicate {
        try {
            return repository.findById(id).get()
        } catch (e: Exception) {
            throw NotFoundException("Duplicate not found")
        }
    }

    private fun save(duplicate: Duplicate): DuplicateView {
        repository.save(duplicate)
        return duplicateViewMapper.map(duplicate)
    }

    private fun getDuplicates(input: List<Int>): Duplicate {
        val output = mutableListOf<Int>()
        input.forEach { element ->
            if (input.count { element == it } > 1) {
                output.add(element)
            }
        }
        return Duplicate(input = input.toString(), output = output.toString())
    }

}