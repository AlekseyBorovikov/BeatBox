package com.example.beatbox.viewmodels

import com.example.beatbox.models.BeatBox
import com.example.beatbox.models.Sound
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class SoundViewModelTest {

    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel
    private lateinit var beatBox: BeatBox

    @Before
    fun setUp() {
        // Созздать имитацию BeatBox
        beatBox = mock(BeatBox::class.java)
        sound = Sound("assetPath")
        subject = SoundViewModel(beatBox)
        subject.sound = sound
    }

    @Test
    fun exposesSoundAsTitle() {
        // Проверить что subject.title = sound.name
        assertThat(subject.title, `is`(sound.name))
    }

    @Test
    fun callsBeatBoxPlayOnButtonClicked() {
        subject.onButtonClicked()
        // Проверка на то, что в beatBox есть функция play(..), которая вызывается с параметром sound
        // эта функция должна вызываться в коде сверху
        verify(beatBox).play(sound)
    }
}