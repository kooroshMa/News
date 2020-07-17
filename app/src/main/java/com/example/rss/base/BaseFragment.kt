package com.example.rss.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rss.R
import com.example.rss.util.extension.toast
import dagger.android.support.DaggerFragment
import com.example.rss.base.ViewModelScope.ACTIVITY
import com.example.rss.base.ViewModelScope.FRAGMENT
import javax.inject.Inject

abstract class BaseFragment <V : BaseViewModel, B : ViewDataBinding> :
    DaggerFragment(), BaseView<V, B> {

    override lateinit var binding: B

    @Inject
    override lateinit var viewModelFactory: ViewModelProvider.Factory

    private val progressDialog: ProgressDialog by lazy {
        ProgressDialog(requireContext()).apply {
            this.setMessage(getString(R.string.message_loading))
        }
    }

    inline fun <reified T : BaseViewModel> getLazyViewModel(scope: ViewModelScope): Lazy<T> =
        lazy {
            when (scope) {
                ACTIVITY -> ViewModelProvider(
                    requireActivity(),
                    viewModelFactory
                )[T::class.java]
                FRAGMENT -> ViewModelProvider(this, viewModelFactory)[T::class.java]
            }
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this

        lifecycle.addObserver(viewModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveDate()
        bindObservables()
        onViewInitialized()
    }

    abstract fun bindObservables()

    private fun observeLiveDate() {
        viewModel.activityAction.observe(viewLifecycleOwner, Observer { it?.invoke(requireActivity()) })

        viewModel.fragmentAction.observe(viewLifecycleOwner, Observer { it?.invoke(this) })

        viewModel.toastMessage.observe(viewLifecycleOwner, Observer { toast(it) })

        viewModel.showLoading.observe(viewLifecycleOwner, Observer {
            if (it) {
                if (!progressDialog.isShowing) {
                    progressDialog.show()
                }
            } else {
                if (progressDialog.isShowing) {
                    progressDialog.dismiss()
                }
            }
        })
    }
}