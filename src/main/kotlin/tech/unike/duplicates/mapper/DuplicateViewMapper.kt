package tech.unike.duplicates.mapper

import org.springframework.stereotype.Component
import tech.unike.duplicates.dto.DuplicateView
import tech.unike.duplicates.model.Duplicate

@Component
class DuplicateViewMapper : Mapper<Duplicate, DuplicateView> {
    override fun map(source: Duplicate): DuplicateView {
        return DuplicateView(
            id = source.id,
            input = source.input,
            output = source.output,
        )
    }
}