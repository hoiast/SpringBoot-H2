package tech.unike.duplicates.mapper

interface Mapper<T, U> {
    fun map(source: T): U
}
