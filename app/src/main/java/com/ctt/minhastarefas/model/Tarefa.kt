package com.ctt.minhastarefas.model

import android.graphics.Bitmap;
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import retrofit2.http.Url

@Parcelize
data class Tarefa(val nomeTarefa: String,
                  val descricaoTarefa: String):Parcelable{

}
