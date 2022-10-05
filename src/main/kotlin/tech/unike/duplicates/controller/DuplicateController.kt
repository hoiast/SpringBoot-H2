package tech.unike.duplicates.controller

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import tech.unike.duplicates.dto.DuplicateView
import tech.unike.duplicates.dto.NewDuplicateForm
import tech.unike.duplicates.service.DuplicateService
import javax.validation.Valid

@RestController
@RequestMapping("/duplicates")
class DuplicateController (
    private val service: DuplicateService,
    private val gson: Gson
){

    @GetMapping
    fun findAll() : List<DuplicateView> {
        return service.findAllView()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : DuplicateView {
        return service.findByIdView(id)
    }

    @PostMapping
    @Transactional
    fun save(
        @RequestBody @Valid form: NewDuplicateForm,
        uriBuilder: UriComponentsBuilder
    ) : ResponseEntity<DuplicateView> {

        // Convert JSON list in List<Int>
        val typeToken = object : TypeToken<List<Int>>() {}.type
        val input = gson.fromJson<List<Int>>(form.input, typeToken)

        val duplicateView = service.calculateDuplicatesAndSave(input)

        val uri = uriBuilder.path("/duplicates/${duplicateView.id}").build().toUri()
        return ResponseEntity.created(uri).body(duplicateView)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.deleteById(id)
    }

}