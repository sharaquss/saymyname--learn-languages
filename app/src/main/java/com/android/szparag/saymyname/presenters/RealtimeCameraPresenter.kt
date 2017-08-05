package com.android.szparag.saymyname.presenters

import com.android.szparag.saymyname.models.ImageRecognitionModel
import com.android.szparag.saymyname.models.TranslationModel
import com.android.szparag.saymyname.repositories.ImagesWordsRepository

/**
 * Created by Przemyslaw Jablonski (github.com/sharaquss, pszemek.me) on 7/5/2017.
 */
interface RealtimeCameraPresenter : CameraPresenter, ImageProcessingPresenter {

  val imageRecognitionModel: ImageRecognitionModel
  val translationModel : TranslationModel
  val imagesWordsRepository: ImagesWordsRepository
}