package com.smartgig.tech.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.smartgig.tech.R
import com.smartgig.tech.databinding.FragmentAddClientBinding
import com.smartgig.tech.databinding.FragmentAddClientProjectBinding
import com.smartgig.tech.ui.activities.LoginActivity


class AddClientProjectFragment : Fragment() {

    private lateinit var binding: FragmentAddClientProjectBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddClientProjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val type="Project"

        binding.layoutAddClientProject.layoutLayoutType.tvScreenTypeHeading.text = type
        binding.layoutAddClientProject.layoutLayoutType.sivScreenTypeLogo.setImageResource(R.drawable.ic_project)

        val popupButton = binding.layoutTopBoard.ivDownCaret

        popupButton.setOnClickListener {
            showPopupMenu(it)
            Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
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

    private fun handelMenuItemClick(menuItem: MenuItem) {

        when (menuItem.itemId) {
            R.id.popup_addClientProject->{

            }
            R.id.popup_addClient->{
                val action=
                    AddClientProjectFragmentDirections.actionAddClientProjectFragmentToAddClientFragment()
                findNavController().navigate(action)
            }
            R.id.popup_addEmployee->{
                val action=
                    AddClientProjectFragmentDirections.actionAddClientProjectFragmentToAddEmployeeFragment()
                findNavController().navigate(action)
            }
            R.id.popup_employeeList->{
                val action=
                    AddClientProjectFragmentDirections.actionAddClientProjectFragmentToEmployeeListFragment()
                findNavController().navigate(action)
            }
            R.id.popup_admin_access->{
                val action=
                    AddClientProjectFragmentDirections.actionAddClientProjectFragmentToAdminAccessFragment()
                findNavController().navigate(action)
            }
            R.id.popup_add_employee_document->{
                val action=
                    AddClientProjectFragmentDirections.actionAddClientProjectFragmentToAddEmployeeDocumentFragment()
                findNavController().navigate(action)
            }
            R.id.popup_apply_leave->{
                val action=
                    AddClientProjectFragmentDirections.actionAddClientProjectFragmentToApplyLeaveFragment()
                findNavController().navigate(action)
            }
            R.id.popup_assigned_project->{
                val action=
                    AddClientProjectFragmentDirections.actionAddClientProjectFragmentToAssignedProjectFragment()
                findNavController().navigate(action)
            }
            R.id.popup_pieChart->{
                val action=
                    AddClientProjectFragmentDirections.actionAddClientProjectFragmentToPieChartFragment()
                findNavController().navigate(action)
            }
            R.id.popup_paySlip->{
                val action=
                    AddClientFragmentDirections.actionAddClientFragmentToPaySlipFragment()
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