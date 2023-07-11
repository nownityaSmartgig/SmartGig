package com.smartgig.tech.ui.fragment

import android.content.Intent
import android.graphics.Color.parseColor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.navigation.fragment.findNavController
import com.smartgig.tech.R
import com.smartgig.tech.databinding.FragmentPieChartBinding
import com.smartgig.tech.ui.activities.LoginActivity
import org.eazegraph.lib.models.PieModel


class PieChartFragment : Fragment() {

    private lateinit var binding: FragmentPieChartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPieChartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val popupButton = binding.layoutTopBoard.ivDownCaret

        popupButton.setOnClickListener {
            showPopupMenu(it)
        }

        val pieChart1 = binding.layoutPieChart.pcPieChart1
        val pieChart2 =binding.layoutPieChart.pcPieChart2

        pieChart1.apply {
            addPieSlice(PieModel("Kotlin" , 25f , parseColor("#B125EA")))
            addPieSlice(PieModel("Java" , 15f , parseColor("#F14C4D")))
            addPieSlice(PieModel("Python" , 20f ,parseColor("#306998")))
            addPieSlice(PieModel("Ruby" , 40f , parseColor("#CC0000")))

        }

        pieChart1.startAnimation()

        pieChart2.apply {
            addPieSlice(PieModel("Kotlin" , 25f , parseColor("#B125EA")))
            addPieSlice(PieModel("Java" , 15f , parseColor("#F14C4D")))
            addPieSlice(PieModel("Python" , 20f ,parseColor("#306998")))
            addPieSlice(PieModel("Ruby" , 40f , parseColor("#CC0000")))
        }

        pieChart2.startAnimation()

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
            R.id.popup_admin_access -> {
                val action =
                    PieChartFragmentDirections.actionPieChartFragmentToAdminAccessFragment()
                findNavController().navigate(action)
            }

            R.id.popup_addEmployee -> {
                val action =
                    PieChartFragmentDirections.actionPieChartFragmentToAddEmployeeFragment()
                findNavController().navigate(action)
            }

            R.id.popup_addClient -> {
                val action =
                    PieChartFragmentDirections.actionPieChartFragmentToAddClientFragment()
                findNavController().navigate(action)
            }

            R.id.popup_addClientProject -> {
                val action =
                    PieChartFragmentDirections.actionPieChartFragmentToAddClientProjectFragment()
                findNavController().navigate(action)
            }

            R.id.popup_employeeList -> {
                val action =
                    PieChartFragmentDirections.actionPieChartFragmentToEmployeeListFragment()
                findNavController().navigate(action)
            }

            R.id.popup_pieChart -> {
            }

            R.id.popup_add_employee_document->{
                val action=PieChartFragmentDirections.actionPieChartFragmentToAddEmployeeDocumentFragment2()
            }

            R.id.popup_apply_leave -> {
                val action =
                    PieChartFragmentDirections.actionPieChartFragmentToApplyLeaveFragment()
                findNavController().navigate(action)
            }

            R.id.popup_assigned_project -> {
                val action =
                    PieChartFragmentDirections.actionPieChartFragmentToAssignedProjectFragment()
                findNavController().navigate(action)
            }
            R.id.popup_paySlip->{
                val action=
                    PieChartFragmentDirections.actionPieChartFragmentToPaySlipFragment()
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