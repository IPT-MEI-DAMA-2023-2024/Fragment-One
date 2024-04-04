package pt.ipt.dama2024.fragmentone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM_TXT_LABEL = ""
private const val ARG_PARAM_TXT_BUTTON = ""
private const val ARG_PARAM_FRAG_ID = "0"

/**
 * A simple [Fragment] subclass.
 * Use the [MyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyFragment : Fragment() {
    private var txtLabel: String? = null
    private var txtButton: String? = null
    private var fragID: Byte = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            txtLabel = it.getString(ARG_PARAM_TXT_LABEL)
            txtButton = it.getString(ARG_PARAM_TXT_BUTTON)
            fragID = it.getByte(ARG_PARAM_FRAG_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_my, container, false)

        // look for objects of fragment
        val aux_txt: TextView = view.findViewById(R.id.frag_textView)
        val aux_bt = view.findViewById<Button>(R.id.frag_button)

        // assign parameters values to objects from fragment
        aux_txt.text = txtLabel
        aux_bt.text = txtButton

        // add some action to button
        aux_bt.setOnClickListener {
            if (fragID % 2 != 0) {
                Toast.makeText(
                    this.context, "you pressed the button \"$txtButton\"",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Snackbar.make(
                    view, "you pressed the button \"$txtButton\"",
                    Snackbar.LENGTH_LONG
                ).show()
            }
            /*
            "you pressed the button " + param2
            <=> "you pressed the button $param2"
             */
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param txtLabel text to be assigned to fragment label.
         * @param txtButton text to be assigned to fragment button.
         * @param fragID fragment number
         * @return A new instance of fragment MyFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(txtLabel: String, txtButton: String, fragID: Byte) =
            MyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM_TXT_LABEL, txtLabel)
                    putString(ARG_PARAM_TXT_BUTTON, txtButton)
                    putByte(ARG_PARAM_FRAG_ID, fragID)
                }
            }
    }
}