package com.smartgig.tech.ui.fragment

import android.app.DatePickerDialog
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
import com.smartgig.tech.databinding.FragmentApplyLeaveBinding
import com.smartgig.tech.databinding.FragmentAssignedProjectBinding
import com.smartgig.tech.ui.activities.LoginActivity
import java.util.Calendar


class AssignedProjectFragment : Fragment() {
    private lateinit var binding:FragmentAssignedProjectBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAssignedProjectBinding.inflate(inflater,container,false)
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

        val datePicker=binding.layoutAssignProject.etOnboardingDate
        datePicker.setOnClickListener{
            showDatePickerDialog()
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

    private fun handleMenuItemClick(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.popup_assigned_project -> {
            }

            R.id.popup_admin_access -> {
                val action =
                    AssignedProjectFragmentDirections.actionAssignedProjectFragmentToAdminAccessFragment()
                findNavController().navigate(action)
            }

            R.id.popup_add_employee_document -> {
                val action =
                    AssignedProjectFragmentDirections.actionAssignedProjectFragmentToAddEmployeeDocumentFragment()

                findNavController().navigate(action)
            }

            R.id.popup_apply_leave-> {
                val action =
                    AssignedProjectFragmentDirections.actionAssignedProjectFragmentToApplyLeaveFragment()
                findNavController().navigate(action)
            }
        }
    }

    private fun jumpToLoginActivity() {
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish() // Finish the current activity
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = String.format("%02d-%02d-%04d", selectedDay, selectedMonth + 1, selectedYear)
                binding.layoutAssignProject.etOnboardingDate.setText(formattedDate)
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }











}