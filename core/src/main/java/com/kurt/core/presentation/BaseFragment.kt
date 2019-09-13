package com.kurt.core.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

/**
 * Copyright 2019, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 09/06/2019
 */

abstract class BaseFragment<VM : ViewModel>(layout: Int) : Fragment(layout) {
    abstract val viewModel: VM

    abstract fun setupViews(view: View)
    abstract fun setupInputs()
    abstract fun setupOutputs()

    open fun inject() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews(view)
        setupInputs()
        setupOutputs()
    }
}