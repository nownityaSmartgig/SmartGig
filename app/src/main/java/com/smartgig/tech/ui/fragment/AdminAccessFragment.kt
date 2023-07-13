package com.smartgig.tech.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.smartgig.tech.R
import com.smartgig.tech.databinding.FragmentAdminAccessBinding
import com.smartgig.tech.databinding.FragmentAssignedProjectBinding
import com.smartgig.tech.domain.model.Admin
import com.smartgig.tech.ui.activities.LoginActivity
import com.smartgig.tech.ui.adapters.recyclerview.MyAdminAdapter


class AdminAccessFragment : Fragment() {

    private lateinit var binding: FragmentAdminAccessBinding
    private lateinit var adminRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Admin>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentAdminAccessBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val popupButton = binding.layoutTopBoard.ivDownCaret
        popupButton.setOnClickListener {
            showPopupMenu(it)
        }
        val logOutButton=binding.layoutLogoutButton.tvLogoutHeading

        logOutButton.setOnClickListener{
            jumpToLoginActivity()
        }

        adminRecyclerView=binding.layoutAdminAccess.adminRecyclerView
        adminRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<Admin>()
        val adminObject1=Admin("Mahesh Nayani","Super Admin","xyz@gmail.com","CEO","Active")

        newArrayList.add(adminObject1)
        newArrayList.add(adminObject1)
        newArrayList.add(adminObject1)
        newArrayList.add(adminObject1)

        val adapter=MyAdminAdapter(newArrayList)

        adminRecyclerView.adapter=MyAdminAdapter(newArrayList)


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
            R.id.popup_admin_access -> {
            }

            R.id.popup_add_employee_document -> {
                val action =
                    AdminAccessFragmentDirections.actionAdminAccessFragmentToAddEmployeeDocumentFragment()
                findNavController().navigate(action)
            }

            R.id.popup_apply_leave-> {
                val action =
                    AdminAccessFragmentDirections.actionAdminAccessFragmentToApplyLeaveFragment()

                findNavController().navigate(action)
            }

            R.id.popup_assigned_project -> {
                val action =
                    AdminAccessFragmentDirections.actionAdminAccessFragmentToAssignedProjectFragment()
                findNavController().navigate(action)
            }
            R.id.popup_addEmployee -> {
                val action =
                    AdminAccessFragmentDirections.actionAdminAccessFragmentToAddEmployeeFragment()
                findNavController().navigate(action)
            }

            R.id.popup_employeeList -> {
                val action =
                    AdminAccessFragmentDirections.actionAdminAccessFragmentToEmployeeListFragment()
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

            R.id.popup_pieChart -> {
                val action =
                    AdminAccessFragmentDirections.actionAdminAccessFragmentToPieChartFragment()
                findNavController().navigate(action)
            }
            R.id.popup_paySlip->{
                val action=
                    AdminAccessFragmentDirections.actionAdminAccessFragmentToPaySlipFragment()
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