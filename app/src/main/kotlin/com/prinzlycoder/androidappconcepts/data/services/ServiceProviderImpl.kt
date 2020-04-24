package com.prinzlycoder.androidappconcepts.data.services

import com.prinzlycoder.androidappconcepts.data.network.ServiceFactory

class ServiceProviderImpl(private val serviceFactory: ServiceFactory) : ServiceProvider {
    override fun getPostService(): PostService {
        return serviceFactory.create(PostService::class.java)
    }
}