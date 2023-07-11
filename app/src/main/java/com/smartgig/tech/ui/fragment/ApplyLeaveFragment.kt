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
import com.smartgig.tech.databinding.FragmentAddEmployeeDocumentsBinding
import com.smartgig.tech.databinding.FragmentApplyLeaveBinding
import com.smartgig.tech.ui.activities.LoginActivity
import java.util.Calendar


class ApplyLeaveFragment : Fragment() {

    private lateinit var binding: FragmentApplyLeaveBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplyLeaveBinding.inflate(inflater, container, false)
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

        val datePickerfromDate = binding.layoutApplyLeave.etFromDate
        datePickerfromDate.setOnClickListener {
            showDatePickerDialog1()
        }
        val datePickertoDate = binding.layoutApplyLeave.etToDate
        datePickertoDate.setOnClickListener {
            showDatePickerDialog2()
        }

        val leaveRequestDropDown= binding.layoutApplyLeave.layoutLeaveRequest.layoutLeaveType.tvScreenTypeHeading
        leaveRequestDropDown.setOnClickListener{
            showPopupMenuLeaveRequest(it)
        }
    }

    private fun showPopupMenu(view: View?) {
        val popupMenu = PopupMenu(requireContext(), view)
        popupMenu.inflate(R.menu.popup_menu)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            handleMenuItemClick(menuItem)
            true
        }
        popupMenu.show()

    }

    private fun handleMenuItemClick(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.popup_apply_leave -> {
            }

            R.id.popup_admin_access -> {
                val action =
                    ApplyLeaveFragmentDirections.actionApplyLeaveFragmentToAdminAccessFragment()
                findNavController().navigate(action)
            }

            R.id.popup_add_employee_document -> {
                val action =
                    ApplyLeaveFragmentDirections.actionApplyLeaveFragmentToAddEmployeeDocumentFragment()

                findNavController().navigate(action)
            }

            R.id.popup_assigned_project -> {
                val action =
                    ApplyLeaveFragmentDirections.actionApplyLeaveFragmentToAssignedProjectFragment()
                findNavController().navigate(action)
            }

            R.id.popup_addEmployee -> {
                val action =
                    ApplyLeaveFragmentDirections.actionApplyLeaveFragmentToAddEmployeeFragment()
                findNavController().navigate(action)
            }

            R.id.popup_employeeList -> {
                val action =
                    ApplyLeaveFragmentDirections.actionApplyLeaveFragmentToEmployeeListFragment()
                findNavController().navigate(action)
            }

            R.id.popup_addClient -> {
                val action =
                    ApplyLeaveFragmentDirections.actionApplyLeaveFragmentToAddClientFragment()
                findNavController().navigate(action)
            }

            R.id.popup_addClientProject -> {
                val action =
                    ApplyLeaveFragmentDirections.actionApplyLeaveFragmentToAddClientProjectFragment()
                findNavController().navigate(action)
            }

            R.id.popup_pieChart -> {
                val action =
                    ApplyLeaveFragmentDirections.actionApplyLeaveFragmentToPieChartFragment()
                findNavController().navigate(action)
            }

            R.id.popup_leave_request->{
                val text="Leave Request"
                binding.layoutApplyLeave.layoutLeaveRequest.layoutLeaveType.tvScreenTypeHeading.text=text

            }
            R.id.popup_leave_history->{
                val text="Leave History"
                binding.layoutApplyLeave.layoutLeaveRequest.layoutLeaveType.tvScreenTypeHeading.text=text
            }
            R.id.popup_paySlip->{
                val action=
                    ApplyLeaveFragmentDirections.actionApplyLeaveFragmentToPaySlipFragment()
                findNavController().navigate(action)
            }
        }

    }

    private fun jumpToLoginActivity() {
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish() // Finish the current activity
    }

    private fun showDatePickerDialog1() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate =
                    String.format("%02d-%02d-%04d", selectedDay, selectedMonth + 1, selectedYear)
                binding.layoutApplyLeave.etFromDate.setText(formattedDate)
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun showDatePickerDialog2() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate =
                    String.format("%02d-%02d-%04d", selectedDay, selectedMonth + 1, selectedYear)
                binding.layoutApplyLeave.etToDate.setText(formattedDate)
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun showPopupMenuLeaveRequest(view: View){
        val popupMenu=PopupMenu(requireContext(),view)
        popupMenu.inflate(R.menu.popup_menu_leave_request)
        popupMenu.setOnMenuItemClickListener{menuItem ->
            handleMenuItemClick(menuItem)
            true
        }
        popupMenu.show()

    }


}