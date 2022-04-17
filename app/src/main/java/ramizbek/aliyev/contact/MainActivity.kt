package ramizbek.aliyev.contact

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import ramizbek.aliyev.contact.utils.MySharedPreference

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        MySharedPreference.init(this)

        main_layout.removeAllViews()

        for (user in MySharedPreference.list) {
            val textView = TextView(this)
            textView.textSize = 20f
            textView.setText("${user.name}\n${user.number}")
            textView.setOnClickListener {
                startActivity(Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:${user.number}")))
            }
            main_layout.addView(textView)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startActivity(Intent(this, AddActivity::class.java))
        return super.onOptionsItemSelected(item)
    }
}