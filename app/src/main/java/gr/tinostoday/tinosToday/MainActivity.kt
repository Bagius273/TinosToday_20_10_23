package gr.tinostoday.tinosToday


import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide the system navigation bar (immersive mode)
        val decorView = window.decorView
        val uiOptions = (
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_FULLSCREEN
                )
        decorView.systemUiVisibility = uiOptions

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        val pagerAdapter = MyPagerAdapter(supportFragmentManager)

        // Add WebViewFragment instances to the adapter
        pagerAdapter.addFragment(fragment1(), "ΑΡΧΙΚΗ")
        pagerAdapter.addFragment(fragment2(), "ΦΑΡΜΑΚΕΙΟ")
        pagerAdapter.addFragment(fragment3(), "ΒΕΝΖΙΝΑΔΙΚΟ")
        pagerAdapter.addFragment(fragment4(), "ΔΙΑΦΗΜΙΣΗ")

        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)

        val tabTitles = arrayOf("ΑΡΧΙΚΗ", "ΦΑΡΜΑΚΕΙΟ", "ΒΕΝΖΙΝΑΔΙΚΟ", "ΔΙΑΦΗΜΙΣΗ")
        val tabIcons = arrayOf(
            R.drawable.home_icon_black,  // Replace with the actual icon resource IDs
            R.drawable.pharmacy___black,
            R.drawable.gas_station_black,
            R.drawable.pngegg_black
        )

        for (i in 0 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            val customTabView = layoutInflater.inflate(R.layout.custom_tab, null)
            val tabTitle = customTabView.findViewById<TextView>(R.id.tab_title)
            val tabIcon = customTabView.findViewById<ImageView>(R.id.tab_icon)

            tabTitle.text = tabTitles[i]
            tabIcon.setImageResource(tabIcons[i])

            tab?.customView = customTabView
        }
    }
}
