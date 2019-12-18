package com.example.fitnesstracker.views.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstracker.R
import com.example.fitnesstracker.data.models.Client
import com.example.fitnesstracker.views.adapters.ClientListAdapter

class ClientsFragment: Fragment() {

    var clients: ArrayList<Client> = arrayListOf()

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: LinearLayoutManager
    private lateinit var adapter: ClientListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_clients,container,false)

        generateTestData()
        initRecyclerView(view)

        adapter.loadClients(clients)
        adapter.notifyDataSetChanged()

        return view
    }

    //TODO Delete Testing purposes only
    private fun generateTestData(){
        val client1 = Client("Jovanka","Broz",34)
        val client2 = Client("Tudum","Srkic",27)
        val client3 = Client("Joko","Prdneuoko",73)

        clients.add(client1)
        clients.add(client2)
        clients.add(client3)

    }

    private fun initRecyclerView(view:View){
        recyclerView = view.findViewById(R.id.rec_all_clients)

        recyclerView.setHasFixedSize(true)

        manager = LinearLayoutManager(activity!!.applicationContext)
        adapter = ClientListAdapter()

        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }
}