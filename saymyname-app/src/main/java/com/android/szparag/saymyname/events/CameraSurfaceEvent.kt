package com.android.szparag.saymyname.events

/**
 * Created by Przemyslaw Jablonski (github.com/sharaquss, pszemek.me) on 10/09/2017.
 */
class CameraSurfaceEvent(
    val type: CameraSurfaceEventType
) {

  enum class CameraSurfaceEventType {
    SURFACE_CREATED,
    SURFACE_DESTROYED,
    SURFACE_CHANGED
  }

}