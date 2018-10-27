package maxwell.app.RxPlayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_debouncer.*
import org.w3c.dom.Text
import java.util.*

class DebouncerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debouncer)
        var timer = Timer()

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                timer = Timer()
                // After a second has passed, set the text field's value to be the text that the user entered
                timer.schedule(
                    object: TimerTask() {
                        override fun run() {
                            runOnUiThread { textView.text = editText.text }
                        }
                    },
                    1000
                )
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Reset the timer
                timer.cancel()
            }
        })
    }
}
