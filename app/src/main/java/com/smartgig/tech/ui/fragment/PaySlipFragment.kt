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
import com.smartgig.tech.databinding.FragmentPaySlipBinding
import com.smartgig.tech.ui.activities.LoginActivity


class PaySlipFragment : Fragment() {

    private lateinit var binding: FragmentPaySlipBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPaySlipBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        val popupMenu = PopupMenu(requireContext(), view)
        popupMenu.inflate(R.menu.popup_menu)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            handelMenuItemClick(menuItem)
            true

        }
        popupMenu.show()

    }

    private fun jumpToLoginActivity() {
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    private fun handelMenuItemClick(menuItem: MenuItem) {

        when (menuItem.itemId) {

            R.id.popup_paySlip->{

            }
            R.id.popup_admin_access -> {
                val action =
                    PaySlipFragmentDirections.actionPaySlipFragmentToAdminAccessFragment()
                findNavController().navigate(action)
            }

            R.id.popup_addEmployee -> {
                val action =
                   PaySlipFragmentDirections.actionPaySlipFragmentToAddEmployeeFragment()
                findNavController().navigate(action)
            }

            R.id.popup_addClient -> {
                val action =
                   PaySlipFragmentDirections.actionPaySlipFragmentToAddClientFragment()
                findNavController().navigate(action)
            }

            R.id.popup_addClientProject -> {
                val action =
                    PaySlipFragmentDirections.actionPaySlipFragmentToAddClientProjectFragment()
                findNavController().navigate(action)
            }

            R.id.popup_employeeList -> {
                val action =
                    PaySlipFragmentDirections.actionPaySlipFragmentToEmployeeListFragment()
                findNavController().navigate(action)
            }

            R.id.popup_pieChart -> {
                val action=
                    PaySlipFragmentDirections.actionPaySlipFragmentToPieChartFragment()

                findNavController().navigate(action)
            }

            R.id.popup_add_employee_document->{
                val action=
                    PaySlipFragmentDirections.actionPaySlipFragmentToAddEmployeeDocumentFragment()

                findNavController().navigate(action)

            }

            R.id.popup_apply_leave -> {
                val action =
                    PaySlipFragmentDirections.actionPaySlipFragmentToApplyLeaveFragment()
                findNavController().navigate(action)
            }

            R.id.popup_assigned_project -> {
                val action =
                    PaySlipFragmentDirections.actionPaySlipFragmentToAssignedProjectFragment()
                findNavController().navigate(action)
            }
        }
    }


}