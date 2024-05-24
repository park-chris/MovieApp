package com.crystal.movieapp.library.storage.usecases

import com.crystal.movieapp.library.storage.IStorage
import com.crystal.movieapp.library.storage.usecases.IStorageClearUseCase
import javax.inject.Inject

class StorageClearUseCase @Inject constructor(
    private val storage: IStorage
) : IStorageClearUseCase {
    override fun invoke() {
        storage.clear()
    }
}
