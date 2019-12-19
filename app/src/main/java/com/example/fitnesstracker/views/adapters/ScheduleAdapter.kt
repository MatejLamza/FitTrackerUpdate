package com.example.fitnesstracker.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstracker.R
import com.example.fitnesstracker.data.models.Schedule
import com.example.fitnesstracker.views.viewholders.ScheduleViewHolder

class ScheduleAdapter:RecyclerView.Adapter<ScheduleViewHolder>() {

    private var mSchedule:ArrayList<Schedule> = arrayListOf()

    fun loadSchedule(scheduleList:ArrayList<Schedule>){
        mSchedule = scheduleList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder
        = ScheduleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_schedule,parent,false))

    override fun getItemCount(): Int
        = mSchedule.size

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val currentEvent = mSchedule[position]

        //TODO Handle events
    }
}