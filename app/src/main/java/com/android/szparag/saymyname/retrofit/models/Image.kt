package com.android.szparag.saymyname.retrofit.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Przemyslaw Jablonski (github.com/sharaquss, pszemek.me) on 7/2/2017.
 */
data class Image(@SerializedName("base64") @Expose val imageBase64:String)