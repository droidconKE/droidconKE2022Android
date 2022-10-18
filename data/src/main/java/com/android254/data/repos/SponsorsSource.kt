package com.android254.data.repos

import com.android254.data.dao.SponsorDao
import com.android254.data.db.model.SponsorMapper
import com.android254.data.db.model.SponsorsEntity
import com.android254.data.db.util.SponsorDataToDomainMapper.toDomain
import com.android254.data.db.util.SponsorDomainToEntityMapper.toDomain
import com.android254.data.db.util.SponsorDomainToEntityMapper.toEntity
import com.android254.data.network.apis.SponsorsApi
import com.android254.domain.models.Sponsors
import com.android254.domain.repos.SponsorsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import javax.inject.Inject

class SponsorsSource @Inject constructor(
    private val api: SponsorsApi,
    private val sponsorDao:SponsorDao
): SponsorsRepository {

    private fun getSponsorsData(page: Int = 1) {
        CoroutineScope(Dispatchers.IO).launch {

            val response = api.fetchSponsors(10, page = page) ?: return@launch
            val data = response.data
            val mapper = SponsorMapper()
            //val sponsors = Sponsors(data)
            //val entity:SponsorsEntity = mapper.mapToEntity(Sponsors())

            //store data on the local db
            data.forEach() {
                sponsorDao.insert(it.toDomain().toEntity())
            }

            if (response.meta?.paginator?.hasMorePages == true) {
                getSponsorsData(page = page + 1)
            }
        }
    }

    override fun fetchSponsors() {
        getSponsorsData(page = 1)
    }

    override fun getSponsors(): List<Sponsors> {
        return sponsorDao.fetchSponsors().map { it.toDomain() }

    }
}


