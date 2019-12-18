package com.example.fitnesstracker.views.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import nl.psdcompany.duonavigationdrawer.views.DuoOptionView

class MenuAdapter: BaseAdapter() {
    private var options: ArrayList<String> = arrayListOf()
    private var optionViews: ArrayList<DuoOptionView> = arrayListOf()

    fun setOptions(mOptions:ArrayList<String>){
        options = mOptions
    }


    override fun getView(pos: Int, view: View?, parent: ViewGroup?): View {
        var option = options[pos]
        var optionView:DuoOptionView

        if (view == null){
            optionView = DuoOptionView(parent!!.context)
        } else{
            optionView = view as DuoOptionView
        }

        optionView.bind(option)

        optionViews.add(optionView)

        return optionView
    }

    override fun getItem(pos: Int): Any = options[pos]

    override fun getItemId(pos: Int): Long = pos.toLong()

    override fun getCount(): Int = options.size
}