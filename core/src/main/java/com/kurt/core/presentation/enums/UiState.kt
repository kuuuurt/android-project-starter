package com.kurt.core.presentation.enums

/**
 * Copyright 2019, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 09/02/2019
 */

sealed class UiState {
    object Complete : UiState()
    object Loading : UiState()
    object Empty : UiState()
    class Error(throwable: Throwable) : UiState()
}