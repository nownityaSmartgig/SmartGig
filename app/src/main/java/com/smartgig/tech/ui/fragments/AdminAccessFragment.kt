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
import com.smartgig.tech.databinding.FragmentAdminAccessBinding

class AdminAccessFragment : Fragment() {

    private lateinit var binding: FragmentAdminAccessBinding

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAdminAccessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)



        binding.layoutTopBoard.ivUserImage.setOnClickListener {
            Toast.makeText(requireContext() , "Clicked!" , Toast.LENGTH_SHORT).show()

        }

        val popupButton = binding.layoutTopBoard.ivDownCaret

        popupButton.setOnClickListener {
            Toast.makeText(requireContext() , "Clicked!" , Toast.LENGTH_SHORT).show()
            showPopupMenu(it)

        }

        binding.layoutLogoutButton.clLogout.setOnClickListener {
            Toast.makeText(requireContext() , "Clicked!" , Toast.LENGTH_SHORT).show()
        }

//        binding.bt.setOnClickListener {
//            Toast.makeText(requireContext(), "Clicked!" , Toast.LENGTH_SHORT).show()
////            val snackbar = Snackbar.make(requireView() , "CLicked!" , Snackbar.LENGTH_SHORT)
////            snackbar.show()
//        }

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

            }
            R.id.popup_addEmployee -> {
                val action =
                    AdminAccessFragmentDirections.actionAdminAccessFragmentToAddEmployeeFragment()
                findNavController().navigate(action)
            }
            R.id.popup_addClient -> {
                val action =
                    AdminAccessFragmentDirections.actionAdminAccessFragmentToAddClientFragment()
                findNavController().navigate(action)
            }
            R.id.popup_addClientProject -> {
                val action =
                    AdminAccessFragmentDirections.actionAdminAccessFragmentToAddClientProjectFragment()
                findNavController().navigate(action)
            }
            R.id.popup_employeeList -> {
                val action =
                    AdminAccessFragmentDirections.actionAdminAccessFragmentToEmployeeListFragment()
                findNavController().navigate(action)
            }
            R.id.popup_pieChart -> {
                val action =
                    AdminAccessFragmentDirections.actionAdminAccessFragmentToPieChartFragment()
                findNavController().navigate(action)
            }
        }
    }


}