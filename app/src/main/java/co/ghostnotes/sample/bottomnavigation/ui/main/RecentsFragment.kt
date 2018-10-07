package co.ghostnotes.sample.bottomnavigation.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.ghostnotes.sample.bottomnavigation.R

internal class RecentsFragment: Fragment() {

    companion object {
        fun newInstance(): RecentsFragment = RecentsFragment()
    }

    private lateinit var viewModel: RecentsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.recents_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecentsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}