package com.smartgig.tech.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.navigation.fragment.findNavController
import com.smartgig.tech.R
import com.smartgig.tech.databinding.FragmentEmployeeListBinding

class EmployeeListFragment : Fragment() {
    private lateinit var binding:FragmentEmployeeListBinding

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEmployeeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        binding.layoutEmployeeList.layoutLayoutType.tvScreenTypeHeading.text = R.string.download_data.toString()
        binding.layoutEmployeeList.layoutLayoutType.sivScreenTypeLogo.setImageResource(R.drawable.ic_download)

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
                    EmployeeListFragmentDirections.actionEmployeeListFragmentToAdminAccessFragment()
                findNavController().navigate(action)
            }
            R.id.popup_addEmployee -> {
                val action =
                    EmployeeListFragmentDirections.actionEmployeeListFragmentToAddEmployeeFragment()
                findNavController().navigate(action)
            }
            R.id.popup_addClient -> {
                val action =
                    EmployeeListFragmentDirections.actionEmployeeListFragmentToAddClientFragment()
                findNavController().navigate(action)
            }
            R.id.popup_addClientProject -> {
                val action =
                    EmployeeListFragmentDirections.actionEmployeeListFragmentToAddClientProjectFragment()
                findNavController().navigate(action)
            }
            R.id.popup_employeeList -> {
            }
            R.id.popup_pieChart -> {
                val action =
                    EmployeeListFragmentDirections.actionEmployeeListFragmentToPieChartFragment()
                findNavController().navigate(action)
            }
        }
    }
}