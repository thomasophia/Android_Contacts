package at.fh.anda_contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e(MainActivity::class.simpleName, "onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.e("mainActivity", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.e("mainActivity", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.e("mainActivity", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.e("mainActivity", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("mainActivity", "onDestroy()")
    }
}