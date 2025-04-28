package com.example.gpscameratest.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.moneytracker.moneymanager.moneywallet.activity.base.BaseActivity
import java.lang.ref.WeakReference

abstract class BaseFragment<B : ViewBinding>(private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> B) :
    Fragment() {

    private var _binding: B? = null
    protected val binding get() = _binding!!

    private var baseActivity: WeakReference<BaseActivity<*>>? = null
    var w = 0f

    protected abstract fun setUp()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.isClickable = true
        w = requireContext().resources.displayMetrics.widthPixels / 100f
        setUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*>) baseActivity = WeakReference(context)
    }


    companion object {
        //animation
        const val res = android.R.id.content
    }

}