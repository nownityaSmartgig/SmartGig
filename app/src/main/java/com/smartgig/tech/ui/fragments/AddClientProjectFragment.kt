package com.smartgig.tech.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.smartgig.tech.R
import com.smartgig.tech.databinding.FragmentAddClientProjectBinding


class AddClientProjectFragment : Fragment() {

    private lateinit var binding: FragmentAddClientProjectBinding

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddClientProjectBinding.inflate(inflater , container , false)

        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        binding.layoutAddClientProject.layoutLayoutType.tvScreenTypeHeading.text = R.string.project.toString()
        binding.layoutAddClientProject.layoutLayoutType.sivScreenTypeLogo.setImageResource(R.drawable.ic_project)

        val popupButton = binding.layoutTopBoard.ivDownCaret

        popupButton.setOnClickListener {
            showPopupMenu(it)
            Toast.makeText(requireContext() , "Clicked" , Toast.LENGTH_SHORT).show()
        }

    }

    private fun showPopupMenu(view: View?) {
        val popupMenu = PopupMenu(requireContext() , view)
        popupMenu.inflate(R.menu.popup_menu)
        popupMenu.setOnMenuItemClickListener { menuItem->
            handelMenuItemClick(menuItem)
            true

        }
        popupMenu.show()

    }

    private fun handelMenuItemClick(menuItem: MenuItem) {

        when (menuItem.itemId) {
            R.id.popup_AdminAccess -> {
                val action =
                    AddClientProjectFragmentDirections.actionAddClientProjectFragmentToAdminAccessFragment()
                findNavController().navigate(action)

            }
            R.id.popup_addEmployee -> {
                val action =
                    AddClientProjectFragmentDirections.actionAddClientProjectFragmentToAddEmployeeFragment()
                findNavController().navigate(action)
            }
            R.id.popup_addClient -> {
                val action =
                    AddClientProjectFragmentDirections.actionAddClientProjectFragmentToAddClientFragment()
                findNavController().navigate(action)
            }
            R.id.popup_addClientProject -> {
            }
            R.id.popup_employeeList -> {
                val action =
                    AddClientProjectFragmentDirections.actionAddClientProjectFragmentToEmployeeListFragment()
                findNavController().navigate(action)
            }
            R.id.popup_pieChart -> {
                val action =
                    AddClientProjectFragmentDirections.actionAddClientProjectFragmentToPieChartFragment()
                findNavController().navigate(action)
            }
        }
    }


}