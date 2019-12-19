package com.example.fitnesstracker.views.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstracker.R
import com.example.fitnesstracker.data.models.Schedule
import com.example.fitnesstracker.views.adapters.ScheduleAdapter
import kotlinx.android.synthetic.main.fragment_schedule.*

class ScheduleFragment: Fragment() {

    var scheduleList: ArrayList<Schedule> = arrayListOf()

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: LinearLayoutManager
    private lateinit var adapter: ScheduleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_schedule,container,false)

        initRecyclerView(view)
        generateTestData()

        adapter.loadSchedule(scheduleList)
        adapter.notifyDataSetChanged()


        return view
    }

    private fun generateTestData(){
        val schedule1 = Schedule("11:00","Gal Gadot","Play Fitness","Private session")
        val schedule2 = Schedule("12:00","Mischelle Lewin","Play Fitness","Group Training")
        val schedule3 = Schedule("14:00","Eva Andressa","Play Fitness","Private session")

        scheduleList.add(schedule1)
        scheduleList.add(schedule2)
        scheduleList.add(schedule3)
    }

    private fun initRecyclerView(view:View){
        recyclerView = view.findViewById(R.id.rec_schedule_events)

        recyclerView.setHasFixedSize(true)

        manager = LinearLayoutManager(activity!!.applicationContext)
        adapter = ScheduleAdapter()

        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }
}