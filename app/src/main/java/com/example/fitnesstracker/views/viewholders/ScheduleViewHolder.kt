package com.example.fitnesstracker.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstracker.data.models.Schedule
import kotlinx.android.synthetic.main.item_list_schedule.view.*

class ScheduleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    var schedule:Schedule? = null

    set(value) {
        field = value

        itemView.schedule_item_client_name.text = schedule!!.clientFullName
        itemView.schedule_item_description.text = schedule!!.description
        itemView.schedule_item_time.text = schedule!!.time
        itemView.schedule_item_location.text = schedule!!.location
    }
}