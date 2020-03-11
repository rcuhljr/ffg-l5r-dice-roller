package com.example.ffgl5rdiceroller

import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.DialogFragment
import com.google.android.material.textfield.TextInputEditText

/**
 * A simple [Fragment] subclass.
 * Use the [ChooseDice.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChooseDice : DialogFragment(), View.OnClickListener {
    interface DiceRollListener{
        fun onFinishChoosingRollDialog(ring: Int, skill: Int)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_choose_dice, container, false)
        view.findViewById<Button>(R.id.done).setOnClickListener(this)
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ChooseDice().apply {
            }
    }

    override fun onClick(v: View?) {
        var ring = view?.findViewById<AppCompatEditText>(R.id.ringDice)?.text.toString()
        var skill = view?.findViewById<AppCompatEditText>(R.id.skillDice)?.text.toString()
        (activity as? DiceRollListener)?.onFinishChoosingRollDialog(ring.toInt(), skill.toInt())
    }
}
