package com.example.rss.base

import android.app.ProgressDialog
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rss.R
import com.example.rss.util.extension.toast
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseFragment <V : BaseViewModel, B : ViewDataBinding> : DaggerAppCompatActivity(),
    BaseView<V, B> {
    override lateinit var binding: B

    @Inject
    override lateinit var viewModelFactory: ViewModelProvider.Factory

    private val progressDialog: ProgressDialog by lazy {
        ProgressDialog(this).apply {
            this.setMessage(getString(R.string.message_loading))
        }
    }

    inline fun <reified T : BaseViewModel> getLazyViewModel(): Lazy<T> =
        lazy { ViewModelProvider(this, viewModelFactory)[T::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this

        lifecycle.addObserver(viewModel)
        observeLiveDate()
        onViewInitialized(binding)
    }


    private fun observeLiveDate() {
        viewModel.activityAction.observe(this, Observer { it?.invoke(this) })

        viewModel.toastMessage.observe(this, Observer { toast(it) })

        viewModel.showLoading.observe(this, Observer {
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