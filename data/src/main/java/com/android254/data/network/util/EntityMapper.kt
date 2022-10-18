package com.android254.data.network.util



interface EntityMapper<Entity, DomainModel> {
    fun mapFromEntity(entity: Entity):DomainModel
    fun mapToEntity(domain:DomainModel):Entity
}