package com.example.ffgl5rdiceroller

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(), ChooseDice.DiceRollListener {

    var alertDialog: ChooseDice? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showRollType(button: View?) {
        var results = findViewById<LinearLayout>(R.id.dice_display)
        results.removeAllViewsInLayout()
        val fm: FragmentManager = supportFragmentManager
        alertDialog = ChooseDice.newInstance()
        alertDialog?.show(fm, "fragment_choose_dice")
    }

    override fun onFinishChoosingRollDialog(ring: Int, skill: Int) {
        var results = findViewById<LinearLayout>(R.id.dice_display)

        val fm: FragmentManager = supportFragmentManager
        alertDialog?.let { fm.beginTransaction().remove(it).commit() };
        for( i in 1..ring ){
            var button = ImageButton(applicationContext)
            button.setBackgroundResource(R.drawable.black)
            results.addView(button)
            var params = button.layoutParams;
            params.width = 64
            params.height = 64
            button.layoutParams = params
            button.setPadding(5, 10, 5, 10)

        }
    }
}
