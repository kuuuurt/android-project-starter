package com.kurt.core.presentation.helpers

import androidx.lifecycle.MutableLiveData
import com.kurt.core.presentation.utils.livedata.Event

/**
 * Copyright 2019, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 09/06/2019
 */

fun <T> MutableLiveData<Event<T>>.postValueEvent(value: T) {
    postValue(value.toEvent())
}

fun <T> T.toEvent() = Event(this)