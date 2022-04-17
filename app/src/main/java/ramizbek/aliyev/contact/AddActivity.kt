package ramizbek.aliyev.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*
import ramizbek.aliyev.contact.models.User
import ramizbek.aliyev.contact.utils.MySharedPreference

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        MySharedPreference.init(this)
        val list = MySharedPreference.list

        btn_save.setOnClickListener {
            val name = edt_name.text.toString().trim()
            val number = edt_number.text.toString().trim()

            if (name!="" && number!= "") {

                val user = User(name, number)
                list.add(user)
                MySharedPreference.list = list
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}