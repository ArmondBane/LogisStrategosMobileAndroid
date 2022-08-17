package com.goodcomp.core.di

import com.goodcomp.core.data.repository.StratagemRepositoryImpl
import com.goodcomp.core.domain.repository.StratagemRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class MainModule {

    @Binds
    abstract fun stratagemRepository(repository: StratagemRepositoryImpl): StratagemRepository
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope


