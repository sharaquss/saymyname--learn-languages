package com.android.szparag.saymyname.retrofit.services

import com.android.szparag.saymyname.retrofit.apis.ApiTranslationYandex
import com.android.szparag.saymyname.retrofit.entities.translation.TranslatedTextResponse
import com.android.szparag.saymyname.retrofit.services.contracts.TranslationNetworkService
import com.android.szparag.saymyname.retrofit.services.contracts.TranslationNetworkService.TranslationNetworkResult
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

/**
 * Created by Przemyslaw Jablonski (github.com/sharaquss, pszemek.me) on 7/5/2017.
 */
class SaymynameTranslationNetworkService(
    private val retrofit: Retrofit,
    override val NETWORK_SERVICE_API_KEY: String)
  : TranslationNetworkService {

  private val networkApiClient: ApiTranslationYandex = initializeNetworkApiClient()

  private fun initializeNetworkApiClient(): ApiTranslationYandex {
    return retrofit.create(ApiTranslationYandex::class.java)
  }

  //todo: languagesPair should be handled here somehow
  override fun requestTextTranslation(texts: List<String>, languagePair: String): Observable<List<String>> {
    networkApiClient.translate(
        key = NETWORK_SERVICE_API_KEY,
        textToTranslate = texts,
        targetLanguagesPair = languagePair
    ).doOnEach {
      //todo: logging here
    }.map {
      response -> response.
    }
//        .enqueue(object : Callback<TranslatedTextResponse> {
//      override fun onResponse(
//          call: Call<TranslatedTextResponse>?,
//          response: Response<TranslatedTextResponse>?)
//          = processSuccessfulResponse(response, callback)
//
//      override fun onFailure(
//          call: Call<TranslatedTextResponse>?,
//          t: Throwable?)
//          = callback.onFailed()
//    })
  }

  private fun processSuccessfulResponse(
      response: Response<TranslatedTextResponse>?,
      callback: TranslationNetworkResult) {
    val texts = response?.body()?.texts
    if (texts != null && texts.isNotEmpty()) {
      callback.onSucceeded(texts)
    } else {
      callback.onFailed()
    }
  }

}