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
import com.smartgig.tech.databinding.FragmentAddEmployeeDocumentsBinding
import com.smartgig.tech.databinding.FragmentApplyLeaveBinding
import com.smartgig.tech.ui.activities.LoginActivity


class ApplyLeaveFragment : Fragment() {

    private lateinit var binding:FragmentApplyLeaveBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplyLeaveBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val popupButton = binding.layoutTopBoard.ivDownCaret
        popupButton.setOnClickListener {
            showPopupMenu(it)
        }

        val logOutButton=binding.layoutLogoutButton.tvLogoutHeading

        logOutButton.setOnClickListener{
            jumpToLoginActivity()
        }
    }

    private fun showPopupMenu(view: View?) {
        val popupMenu = PopupMenu(requireContext() , view)
        popupMenu.inflate(R.menu.popup_menu)
        popupMenu.setOnMenuItemClickListener { menuItem->
            handleMenuItemClick(menuItem)
            true
        }
        popupMenu.show()

    }

    private fun handleMenuItemClick(menuItem: MenuItem){
        when (menuItem.itemId) {
            R.id.popup_apply_leave -> {
            }

            R.id.popup_admin_access -> {
                val action =
                    ApplyLeaveFragmentDirections.actionApplyLeaveFragmentToAdminAccessFragment()
                findNavController().navigate(action)
            }

            R.id.popup_add_employee_document-> {
                val action =
                    ApplyLeaveFragmentDirections.actionApplyLeaveFragmentToAddEmployeeDocumentFragment()

                findNavController().navigate(action)
            }

            R.id.popup_assigned_project -> {
                val action =
                    ApplyLeaveFragmentDirections.actionApplyLeaveFragmentToAssignedProjectFragment()
                findNavController().navigate(action)
            }
        }

    }

    private fun jumpToLoginActivity() {
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish() // Finish the current activity
    }



}