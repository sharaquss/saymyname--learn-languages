package com.android.szparag.saymyname

import android.app.Application
import com.android.szparag.saymyname.repositories.entities.Image
import com.android.szparag.saymyname.repositories.entities.Word
import com.facebook.stetho.Stetho
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by Przemyslaw Jablonski (github.com/sharaquss, pszemek.me) on 7/2/2017.
 */
class SaymynameApplication : Application(){

  override fun onCreate() {
    super.onCreate()
    Stetho.initializeWithDefaults(this)
    Realm.init(this)
    Realm.setDefaultConfiguration(RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build())
    Realm.getDefaultInstance().executeTransaction {
      realm ->
      realm.delete(Image::class.java)
      realm.delete(Word::class.java)
    }
  }

}