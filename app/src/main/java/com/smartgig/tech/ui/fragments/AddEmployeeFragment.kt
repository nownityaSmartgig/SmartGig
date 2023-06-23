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
import com.smartgig.tech.databinding.FragmentAddEmployeeBinding


class AddEmployeeFragment : Fragment() {

        private lateinit var binding: FragmentAddEmployeeBinding

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddEmployeeBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        binding.layoutAddEmployeeDetails.layoutLayoutType.tvScreenTypeHeading.text = R.string.employee_details.toString()
        binding.layoutAddEmployeeDetails.layoutLayoutType.sivScreenTypeLogo.setImageResource(R.drawable.ic_download)

        val popupButton = binding.layoutTopBoard.ivDownCaret

        popupButton.setOnClickListener {
            showPopupMenu(it)
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
                    AddEmployeeFragmentDirections.actionAddEmployeeFragmentToAdminAccessFragment()
                findNavController().navigate(action)
            }
            R.id.popup_addEmployee -> {
            }
            R.id.popup_addClient -> {
                val action =
                    AddEmployeeFragmentDirections.actionAddEmployeeFragmentToAddClientFragment()
                findNavController().navigate(action)
            }
            R.id.popup_addClientProject -> {
                val action =
                    AddEmployeeFragmentDirections.actionAddEmployeeFragmentToAddClientProjectFragment()
                findNavController().navigate(action)
            }
            R.id.popup_employeeList -> {
                val action =
                    AddEmployeeFragmentDirections.actionAddEmployeeFragmentToEmployeeListFragment()
                findNavController().navigate(action)
            }
            R.id.popup_pieChart -> {
                val action =
                    AddEmployeeFragmentDirections.actionAddEmployeeFragmentToPieChartFragment()
                findNavController().navigate(action)
            }
        }
    }


}