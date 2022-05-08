package com.example.mobilemidterm

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_blank, container, false)

        val btn = v.findViewById(R.id.button1) as ImageButton
        val accBtn = v.findViewById(R.id.accountbtn) as ImageButton
        val textedit = v.findViewById(R.id.editText) as EditText

        val blankFragment2 = BlankFragment2()

        btn.setOnClickListener(View.OnClickListener {
            val fragmentManager = this@BlankFragment.parentFragmentManager
            val sharedtext = this.requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)
            fragmentManager.beginTransaction().apply {
                if (textedit.text.isNotBlank())
                    sharedtext.edit().putString("personname", textedit.text.toString()).apply()
                if (textedit.text.isBlank())
                    sharedtext.edit().putString("personname", " your name").apply()
                replace(com.example.mobilemidterm.R.id.fragment_container_view, blankFragment2)
                commit()
            }
        })

        accBtn.setOnClickListener(View.OnClickListener {
            val fragmentManager = this@BlankFragment.parentFragmentManager
            val sharedtext = this.requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)
            fragmentManager.beginTransaction().apply {
                replace(com.example.mobilemidterm.R.id.fragment_container_view, blankFragment2)
                commit()
            }
        })

        return v
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}