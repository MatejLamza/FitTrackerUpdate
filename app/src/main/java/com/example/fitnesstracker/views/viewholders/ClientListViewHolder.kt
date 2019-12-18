package com.example.fitnesstracker.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstracker.data.models.Client
import kotlinx.android.synthetic.main.item_list_client.view.*

class ClientListViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    var client:Client? = null

    set(value) {
        field = value

        itemView.tv_item_client_name.text       = value!!.name
        itemView.tv_item_client_surname.text    = value.surname
        itemView.tv_item_client_age.text        = value.age.toString()
    }

}