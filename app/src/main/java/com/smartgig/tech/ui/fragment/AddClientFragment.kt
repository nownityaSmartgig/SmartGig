package com.smartgig.tech.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.smartgig.tech.R
import com.smartgig.tech.databinding.FragmentAddClientBinding
import com.smartgig.tech.databinding.FragmentAddEmployeeDocumentsBinding
import com.smartgig.tech.domain.model.Client
import com.smartgig.tech.ui.activities.LoginActivity
import com.smartgig.tech.ui.adapters.recyclerview.MyAddClientAdapter
import com.smartgig.tech.ui.fragment.AddClientFragmentDirections


class AddClientFragment : Fragment() {

    private lateinit var binding: FragmentAddClientBinding
    private lateinit var clientRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Client>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddClientBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val popupButton = binding.layoutTopBoard.ivDownCaret

        popupButton.setOnClickListener {
            showPopupMenu(it)
        }

        val type = "Client"
        binding.layoutAddClient.layoutLayoutType.tvScreenTypeHeading.text = type
        binding.layoutAddClient.layoutLayoutType.sivScreenTypeLogo.setImageResource(R.drawable.ic_project)


        clientRecyclerView=binding.layoutAddClient.rvClientDetails
        newArrayList= arrayListOf<Client>()
        val client1=Client("Joe","Banglore","Active")

        newArrayList.add(client1)
        newArrayList.add(client1)
        newArrayList.add(client1)

        val adapter=MyAddClientAdapter(newArrayList)
        clientRecyclerView.adapter=adapter

        val logOutButton = binding.layoutLogoutButton.tvLogoutHeading

        logOutButton.setOnClickListener {
            jumpToLoginActivity()
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
            R.id.popup_addClient -> {
            }

            R.id.popup_admin_access -> {
                val action =
                    AddClientFragmentDirections.actionAddClientFragmentToAdminAccessFragment()
                findNavController().navigate(action)
            }

            R.id.popup_apply_leave -> {
                val action =
                    AddClientFragmentDirections.actionAddClientFragmentToApplyLeaveFragment()
                findNavController().navigate(action)
            }

            R.id.popup_assigned_project -> {
                val action =
                    AddClientFragmentDirections.actionAddClientFragmentToAssignedProjectFragment()
                findNavController().navigate(action)
            }

            R.id.popup_add_employee_document -> {
                val action =
                    AddClientFragmentDirections.actionAddClientFragmentToAddEmployeeDocumentFragment()
                findNavController().navigate(action)
            }

            R.id.popup_employeeList -> {
                val action =
                    AddClientFragmentDirections.actionAddClientFragmentToEmployeeListFragment()
                findNavController().navigate(action)

            }

            R.id.popup_addEmployee -> {
                val action =
                    AddClientFragmentDirections.actionAddClientFragmentToAddEmployeeFragment()
                findNavController().navigate(action)
            }

            R.id.popup_addClientProject -> {
                val action =
                    AddClientFragmentDirections.actionAddClientFragmentToAddClientProjectFragment()
                findNavController().navigate(action)
            }

            R.id.popup_pieChart -> {
                val action =
                    AddClientFragmentDirections.actionAddClientFragmentToPieChartFragment()
                findNavController().navigate(action)
            }

            R.id.popup_paySlip -> {
                val action =
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