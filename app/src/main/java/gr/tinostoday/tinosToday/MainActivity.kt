package gr.tinostoday.tinosToday


import android.os.Bundle
import android.view.View
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
        pagerAdapter.addFragment(fragment1(), "Αρχική")
        pagerAdapter.addFragment(fragment2(), "Φαρμακείο")
        pagerAdapter.addFragment(fragment3(), "Βενζινάδικο")
        pagerAdapter.addFragment(fragment4(), "Διαφήμιση")

        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)

        val tabTitles = arrayOf("Αρχική", "Φαρμακείο", "Βενζινάδικο", "Διαφήμιση")
        for (i in 0 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            val customTabView = layoutInflater.inflate(R.layout.custom_tab, null)
            val tabTitle = customTabView.findViewById<TextView>(R.id.tab_title)
            tabTitle.text = tabTitles[i] // Set the correct tab title here
            tab?.customView = customTabView




        }
    }
}

