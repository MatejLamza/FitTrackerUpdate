package com.example.fitnesstracker.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstracker.R
import com.example.fitnesstracker.data.models.Client
import com.example.fitnesstracker.views.viewholders.ClientListViewHolder

class ClientListAdapter:RecyclerView.Adapter<ClientListViewHolder>() {

    private var mClients:ArrayList<Client> = arrayListOf()

    fun loadClients(clients:ArrayList<Client>){
        mClients = clients
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientListViewHolder
    = ClientListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_client,parent,false))

    override fun getItemCount(): Int = mClients.size

    override fun onBindViewHolder(holder: ClientListViewHolder, position: Int) {
       holder.client = mClients[position]
        //TODO Add icons to delete and edit client info
    }
}