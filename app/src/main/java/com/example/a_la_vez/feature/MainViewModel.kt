package com.example.a_la_vez.feature

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a_la_vez.R

class MainViewModel(): ViewModel() {

    val tabSelectedItem = MutableLiveData<Int>(R.id.menu_find_group)

}