package maxwell.app.RxPlayground

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setupActivityList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupActivityList() {
        val debouncer = findViewById<TextView>(R.id.debouncer)
        debouncer.setOnClickListener {
            val intent = Intent(this, DebouncerActivity::class.java)
            startActivity(intent)
        }
        val rxDebouncer = findViewById<TextView>(R.id.rx_debouncer)
        rxDebouncer.setOnClickListener {
            val intent = Intent(this, RxDebouncerActivity::class.java)
            startActivity(intent)
        }
    }
}
