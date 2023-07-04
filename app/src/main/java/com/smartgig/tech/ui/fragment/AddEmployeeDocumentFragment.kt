package com.smartgig.tech.ui.fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.smartgig.tech.R
import com.smartgig.tech.databinding.FragmentAddEmployeeDocumentsBinding
import com.smartgig.tech.ui.activities.LoginActivity
import com.smartgig.tech.ui.activities.SuperAdminActivity

class AddEmployeeDocumentFragment : Fragment() {
    private lateinit var binding: FragmentAddEmployeeDocumentsBinding

    private val PICK_DOCUMENT_REQUEST_CODE = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddEmployeeDocumentsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        val type:String="Documents"
        binding.layoutAddEmployeeDocuments.layoutLayoutType.tvScreenTypeHeading.text = type
        binding.layoutAddEmployeeDocuments.layoutLayoutType.sivScreenTypeLogo.setImageResource(R.drawable.ic_upload_documets)


        val popupButton = binding.layoutTopBoard.ivDownCaret

        popupButton.setOnClickListener {
            showPopupMenu(it)
        }
        val logOutButton=binding.layoutLogoutButton.tvLogoutHeading

        logOutButton.setOnClickListener{
            jumpToLoginActivity()
        }




        val uploadPhoto= binding.layoutAddEmployeeDocuments.tvUploadPhotoDocument
        val uploadHighSchool= binding.layoutAddEmployeeDocuments.tvUploadHighschoolDocument
        val uploadIntermediate=binding.layoutAddEmployeeDocuments.tvUploadIntermediateDocument
        val uploadUG=binding.layoutAddEmployeeDocuments.tvUploadUGDocument
        val uploadPG=binding.layoutAddEmployeeDocuments.tvUploadPGDocument
        val uploadPaySlip=binding.layoutAddEmployeeDocuments.tvUploadPaySlipDocument
        val uploadOfferLetter_1=binding.layoutAddEmployeeDocuments.tvUploadOfferLetterDocument1
        val uploadOfferLetter_2=binding.layoutAddEmployeeDocuments.tvUploadOfferLetterDocument2
        val uploadOfferLetter_3=binding.layoutAddEmployeeDocuments.tvUploadOfferLetterDocument3

        uploadPhoto.setOnClickListener{
            onDocumentClick(it)
        }
        uploadHighSchool.setOnClickListener{
            onDocumentClick(it)
        }
        uploadIntermediate.setOnClickListener{
            onDocumentClick(it)
        }
        uploadUG.setOnClickListener{
            onDocumentClick(it)
        }
        uploadPG.setOnClickListener{
            onDocumentClick(it)
        }
        uploadPaySlip.setOnClickListener{
            onDocumentClick(it)
        }
        uploadOfferLetter_1.setOnClickListener{
            onDocumentClick(it)
        }
        uploadOfferLetter_2.setOnClickListener{
            onDocumentClick(it)
        }
        uploadOfferLetter_3.setOnClickListener{
            onDocumentClick(it)
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

    //Handling the functions when an item is clicked on pop_up menu
    private fun handleMenuItemClick(menuItem: MenuItem){
        when (menuItem.itemId) {
            R.id.popup_add_employee_document -> {
            }

            R.id.popup_admin_access -> {
                val action =
                    AddEmployeeDocumentFragmentDirections.actionAddEmployeeDocumentFragmentToAdminAccessFragment()
                findNavController().navigate(action)
            }

            R.id.popup_apply_leave -> {
                val action =
                    AddEmployeeDocumentFragmentDirections.actionAddEmployeeDocumentFragmentToApplyLeaveFragment()

                findNavController().navigate(action)
            }

            R.id.popup_assigned_project -> {
                val action =
                    AddEmployeeDocumentFragmentDirections.actionAddEmployeeDocumentFragmentToAssignedProjectFragment()
                findNavController().navigate(action)
            }
        }

    }

    //function from onclick from layout

    private var clickedTextViewId: Int? = null

    fun onDocumentClick(view: View) {
        clickedTextViewId = view.id
        val clickedTextView = view as? TextView
        clickedTextView?.let {
            it.hint = "Select your file"  // Reset the hint initially
            openDocumentPicker()
        }
    }

    private fun openDocumentPicker() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        startActivityForResult(intent, PICK_DOCUMENT_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_DOCUMENT_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val selectedFileUri = data?.data
            if (selectedFileUri != null) {
                val fileName = getFileNameFromUri(selectedFileUri)
                val clickedTextViewId = clickedTextViewId
                if (clickedTextViewId != null) {
                    val clickedTextView = binding.root.findViewById<TextView>(clickedTextViewId)
                    clickedTextView?.hint = fileName
                }
            }
        }
    }


    private fun getFileNameFromUri(uri: Uri): String {
        var displayName=""
        val cursor = requireContext().contentResolver.query(uri, null, null, null, null)
        cursor?.let {
            if (it.moveToFirst()) {
                val displayNameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (displayNameIndex != -1) {
                    displayName = it.getString(displayNameIndex)
                }
            }
            return displayName
        }
        return ""
    }

    private fun jumpToLoginActivity() {
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish() // Finish the current activity
    }
}