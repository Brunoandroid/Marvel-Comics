package com.example.marvelcomics.di

import android.content.Context
import androidx.room.Room
import com.example.marvelcomics.data.db.cart.AppDBCart
import com.example.marvelcomics.data.service.MyInterceptor
import com.example.marvelcomics.data.service.RequestApi
import com.example.marvelcomics.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    //
    @Singleton
    @Provides
    fun provideComicDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDBCart::class.java,
        "cart_comic_shopping"
    ).build()


    @Singleton
    @Provides
    fun provideFavMovieDao(db: AppDBCart) = db.getCartDao()
    //

    @Singleton
    @Provides
    fun providerHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(MyInterceptor())
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(
            okHttpClient: OkHttpClient,
            gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .build()
    }

    @Singleton
    @Provides
    fun providerApiService(retrofit: Retrofit): RequestApi {
        return retrofit.create(RequestApi::class.java)
    }

}