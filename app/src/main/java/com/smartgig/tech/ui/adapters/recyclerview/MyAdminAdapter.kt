package com.smartgig.tech.ui.adapters.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.smartgig.tech.R
import com.smartgig.tech.databinding.RvLayoutAdminsBinding
import com.smartgig.tech.domain.model.Admin

class MyAdminAdapter(private val adminList:ArrayList<Admin>): RecyclerView.Adapter<MyAdminAdapter.MyViewHolder>() {

//    private lateinit var mListener:onItemClickListener
//    interface onItemClickListener{
//        fun onItemClick(position: Int,bottomLayout:View)
//    }
//
//    fun setOnClickListener(listener:onItemClickListener){
//        mListener=listener
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val binding=RvLayoutAdminsBinding.inflate(inflater,parent,false)
        return  MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return adminList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=adminList[position]
        holder.employeeName.text=currentItem.EmployeeName
        holder.adminType.text=currentItem.Role
        holder.arrowDown.setImageResource(R.drawable.ic_arrow_down)
        holder.emailId.text=currentItem.EmailId
        holder.designation.text=currentItem.Designation
        holder.role.text=currentItem.Role
        holder.status.text=currentItem.Status


    }

    class MyViewHolder(private val binding: RvLayoutAdminsBinding):RecyclerView.ViewHolder(binding.root){
        val employeeName=binding.tvEmployeeName
        val adminType=binding.tvRoleDetailTop
        val arrowDown=binding.ivCaretDown
        val emailId=binding.tvEmailIdDetail
        val designation=binding.tvDesignationDetail
        val role=binding.tvRoleDetail
        val status=binding.tvStatusDetail
        val bottomLayout=binding.clBottomLayout

        init {

            itemView.setOnClickListener {
                if (bottomLayout.visibility == View.VISIBLE) {
                    arrowDown.setImageResource(R.drawable.ic_arrow_down)
                    adminType.visibility=View.VISIBLE
                    bottomLayout.visibility = View.GONE
                } else {
                    arrowDown.setImageResource(R.drawable.ic_arrow_up)
                    adminType.visibility=View.GONE
                    status.setTextColor(ContextCompat.getColor(itemView.context, R.color.active_green))
                    bottomLayout.visibility = View.VISIBLE
                }
            }

        }

    }
}