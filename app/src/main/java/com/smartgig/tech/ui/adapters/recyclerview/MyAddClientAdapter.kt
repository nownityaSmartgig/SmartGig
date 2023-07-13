package com.smartgig.tech.ui.adapters.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.smartgig.tech.R
import com.smartgig.tech.databinding.RvLayoutClientDetailBinding
import com.smartgig.tech.domain.model.Client

class MyAddClientAdapter(private val clientList:ArrayList<Client>):RecyclerView.Adapter<MyAddClientAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val binding=RvLayoutClientDetailBinding.inflate(inflater,parent,false)
        return MyViewHolder(binding)

    }

    override fun getItemCount(): Int {
       return clientList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=clientList[position]
        holder.clientName.text=currentItem.ClientName
        holder.locationTop.text=currentItem.Location
        holder.location.text=currentItem.Location
        holder.status.text=currentItem.Status
        holder.arrowDown.setImageResource(R.drawable.ic_arrow_down)
        holder.deleteIcon.setImageResource(R.drawable.ic_delete_red)
        holder.editPencil.setImageResource(R.drawable.ic_pencil)


    }
    class MyViewHolder(private val binding: RvLayoutClientDetailBinding):RecyclerView.ViewHolder(binding.root){

        val clientName=binding.tvClientName
        val locationTop=binding.tvLocationTop
        val status=binding.tvStatusDetail
        val location=binding.tvLocationDetail
        val arrowDown=binding.ivCaretDown
        val deleteIcon=binding.ivDelete
        val editPencil=binding.ivEdit
        val bottomLayout=binding.clBottomLayout



        init {

            itemView.setOnClickListener {
                if (bottomLayout.visibility == View.VISIBLE) {
                    arrowDown.setImageResource(R.drawable.ic_arrow_down)
                    locationTop.visibility=View.VISIBLE
                    bottomLayout.visibility = View.GONE
                } else {
                    arrowDown.setImageResource(R.drawable.ic_arrow_up)
                    status.setTextColor(ContextCompat.getColor(itemView.context, R.color.active_green))
                    locationTop.visibility=View.GONE
                    bottomLayout.visibility = View.VISIBLE
                }
            }

        }

    }

}