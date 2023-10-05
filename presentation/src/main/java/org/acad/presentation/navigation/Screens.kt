package org.acad.presentation.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.acad.presentation.screens.phone.PhoneFragment

/**
 * Created by Acad Bek on 10/5/2023.
 */
object Screens {
    fun phone() = FragmentScreen { PhoneFragment() }
}