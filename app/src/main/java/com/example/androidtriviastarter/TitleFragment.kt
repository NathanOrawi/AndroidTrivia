package com.example.androidtriviastarter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import com.example.androidtriviastarter.databinding.FragmentTitleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    val binding = DataBindingUtil.inflate<FragmentTitleBinding>(
        inflater, R.layout.fragment_title, container, false)
        binding.playButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.options_menu, menu)
            }
            override fun onMenuItemSelected(menuItem: android.view.MenuItem): Boolean {
                // Handle the menu selection
                when (menuItem.itemId) {
                    R.id.aboutFragment ->
                        view?.findNavController()?.navigate(R.id.action_titleFragment_to_aboutFragment)
                    else -> return false
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
        return binding.root
    }
}