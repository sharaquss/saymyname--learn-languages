package com.android.szparag.saymyname.views.contracts

import com.android.szparag.saymyname.events.CameraPictureEvent
import io.reactivex.Completable
import io.reactivex.Observable
import java.util.Locale

/**
 * Created by Przemyslaw Jablonski (github.com/sharaquss, pszemek.me) on 7/3/2017.
 */
interface RealtimeCameraPreviewView :
    CameraPreviewView,
    ImageRecognitionView,
    TextToSpeechView {

  //user interface events:
  fun onUserModelSwitchButtonClicked(): Observable<Any>
  fun onUserModelSwitchLanguageClicked(): Observable<Any>
  fun onUserHamburgerMenuClicked(): Observable<Any>

  //general view rendering:
  fun renderLoadingAnimation()
  fun stopRenderingLoadingAnimation()

  //camera parallax fx:
  fun initializeSuddenMovementDetection()
  fun onSuddenMovementDetected()

}