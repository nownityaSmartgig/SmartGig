package com.smartgig.tech.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.navigation.fragment.findNavController
import com.smartgig.tech.R
import com.smartgig.tech.databinding.FragmentAddEmployeeBinding
import com.smartgig.tech.ui.activities.LoginActivity


class AddEmployeeFragment : Fragment() {

    private lateinit var binding:FragmentAddEmployeeBinding

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


        val type="Employee Details"
        binding.layoutAddEmployeeDetails.layoutLayoutType.tvScreenTypeHeading.text = type
        binding.layoutAddEmployeeDetails.layoutLayoutType.sivScreenTypeLogo.setImageResource(R.drawable.ic_employees_detail)

        val popupButton = binding.layoutTopBoard.ivDownCaret

        popupButton.setOnClickListener {
            showPopupMenu(it)
        }

        val logOutButton = binding.layoutLogoutButton.tvLogoutHeading

        logOutButton.setOnClickListener {
            jumpToLoginActivity()
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
            R.id.popup_addEmployee -> {

            }
            R.id.popup_add_employee_document -> {
                val action=
                    AddEmployeeFragmentDirections.actionAddEmployeeFragmentToAddEmployeeDocumentFragment()
                findNavController().navigate(action)
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
            R.id.popup_apply_leave->{
                val action=
                    AddEmployeeFragmentDirections.actionAddEmployeeFragmentToApplyLeaveFragment()
                findNavController().navigate(action)
            }
            R.id.popup_assigned_project->{
                val action=
                    AddEmployeeFragmentDirections.actionAddEmployeeFragmentToAssignedProjectFragment()
                findNavController().navigate(action)
            }
            R.id.popup_admin_access->{
                val action=
                    AddEmployeeFragmentDirections.actionAddEmployeeFragmentToAdminAccessFragment()
                findNavController().navigate(action)
            }
            R.id.popup_paySlip->{
                val action=
                    AddEmployeeFragmentDirections.actionAddEmployeeFragmentToPaySlipFragment()
                findNavController().navigate(action)
            }
        }
    }

    private fun jumpToLoginActivity() {
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }


}