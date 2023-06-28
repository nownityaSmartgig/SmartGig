package com.smartgig.tech.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.smartgig.tech.R
import com.smartgig.tech.databinding.FragmentAddClientBinding

class AddClientFragment : Fragment() {

    private lateinit var binding: FragmentAddClientBinding
    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddClientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        val popupButton = binding.layoutTopBoard.ivDownCaret

        popupButton.setOnClickListener {
            showPopupMenu(it)
        }

        binding.layoutAddClient.layoutLayoutType.tvScreenTypeHeading.text = R.string.client.toString()
        binding.layoutAddClient.layoutLayoutType.sivScreenTypeLogo.setImageResource(R.drawable.ic_project)

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
                    AddClientFragmentDirections.actionAddClientFragmentToAdminAccessFragment()
                findNavController().navigate(action)

            }
            R.id.popup_addEmployee -> {
                val action =
                    AddClientFragmentDirections.actionAddClientFragmentToAddEmployeeFragment()
                findNavController().navigate(action)
            }
            R.id.popup_addClient -> {
            }
            R.id.popup_addClientProject -> {
                val action =
                    AddClientFragmentDirections.actionAddClientFragmentToAddClientProjectFragment()
                findNavController().navigate(action)
            }
            R.id.popup_employeeList -> {
                val action =
                    AddClientFragmentDirections.actionAddClientFragmentToEmployeeListFragment()
                findNavController().navigate(action)
            }
            R.id.popup_pieChart -> {
                val action =
                    AddClientFragmentDirections.actionAddClientFragmentToPieChartFragment()
                findNavController().navigate(action)
            }
        }
    }



}