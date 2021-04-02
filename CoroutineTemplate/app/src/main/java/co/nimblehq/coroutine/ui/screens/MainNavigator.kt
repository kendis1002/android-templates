package co.nimblehq.coroutine.ui.screens

import androidx.fragment.app.FragmentActivity
import co.nimblehq.coroutine.R
import co.nimblehq.coroutine.ui.base.*
import co.nimblehq.coroutine.ui.screens.home.HomeFragmentDirections.Companion.actionHomeFragmentToSecondFragment
import co.nimblehq.coroutine.ui.screens.second.SecondBundle
import javax.inject.Inject

interface MainNavigator : BaseNavigator

class MainNavigatorImpl @Inject constructor(
    activity: FragmentActivity
) : BaseNavigatorImpl(activity), MainNavigator {

    override val navHostFragmentId = R.id.navHostFragment

    override fun navigate(event: NavigationEvent) {
        when (event) {
            is NavigationEvent.Second -> navigateToSecond(event.bundle)
        }
    }

    private fun navigateToSecond(bundle: SecondBundle) {
        val navController = findNavController()
        when (navController?.currentDestination?.id) {
            R.id.homeFragment -> navController.navigate(
                actionHomeFragmentToSecondFragment(bundle)
            )
            else -> unsupportedNavigation()
        }
    }
}
