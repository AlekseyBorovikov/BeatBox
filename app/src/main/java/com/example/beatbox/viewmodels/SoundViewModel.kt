package com.example.beatbox.viewmodels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.beatbox.models.BeatBox
import com.example.beatbox.models.Sound

class SoundViewModel(val beatBox: BeatBox) : BaseObservable() {

    fun onButtonClicked() {
        sound?.let {
            beatBox.play(it)
        }
    }

    var sound: Sound? = null
        set(sound) {
            field = sound
            notifyChange()
        }

    @get:Bindable
    val title: String?
        get() = sound?.name

}