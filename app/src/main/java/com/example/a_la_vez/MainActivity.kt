package com.example.a_la_vez

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.a_la_vez.base.BaseActivity
import com.example.a_la_vez.databinding.ActivityMainBinding
import com.example.a_la_vez.feature.MainViewModel
import com.example.a_la_vez.feature.favoriteclub.ui.fragment.FavoriteFragment
import com.example.a_la_vez.feature.findclub.ui.fragment.FindclubFragment
import com.example.a_la_vez.feature.mypage.ui.fragment.MypageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override val vm : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.mainBottomNavigation.setOnNavigationItemSelectedListener(itemSelectedListener)
        setFragment()
    }

    private fun setFragment() {
        initFragment()
        observeEvent()
    }

    private val itemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            vm.tabSelectedItem.value = item.itemId
            true
        }
    private val findClubFragment = FindclubFragment()
    private val favoriteClubFragment = FavoriteFragment()
    private val myPageFragment = MypageFragment()
    private var activeFragment: Fragment = findClubFragment


    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, findClubFragment)
            .hide(findClubFragment).commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, favoriteClubFragment)
            .hide(favoriteClubFragment).commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, myPageFragment)
            .hide(myPageFragment).commit()
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().hide(activeFragment).show(fragment).commit()
        activeFragment = fragment
    }

    override fun observeEvent() {
        vm.tabSelectedItem.observe(this,{id->
            when (id) {
                R.id.menu_find_group -> {
                    changeFragment(findClubFragment)
                }
                R.id.menu_fav_group -> {
                    changeFragment(favoriteClubFragment)
                }
                R.id.menu_mypage -> {
                    changeFragment(myPageFragment)
                }
            }
        })
    }

}