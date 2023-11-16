package fr.mastersid.ngayo.crypto.backend

import fr.mastersid.ngayo.crypto.backend.CryptoUtilImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import fr.mastersid.ngayo.crypto.backend.CryptoUtil

@Module
@InstallIn(ViewModelComponent::class)
abstract  class CryptoUtilModule{
    @Binds
    abstract fun bindCryptoUtil(cryptoUtilImpl: CryptoUtilImpl): CryptoUtil
}