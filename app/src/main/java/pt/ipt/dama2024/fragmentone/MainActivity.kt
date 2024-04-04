package pt.ipt.dama2024.fragmentone

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // add reference to the fragments that we need to use
    lateinit var f1:MyFragment
    lateinit var f2:MyFragment
    lateinit var f3:MyFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        f1= MyFragment.newInstance("Fragmento um","botão um")
        f2= MyFragment.newInstance("Fragmento Dois","botão Dois")
        f3= MyFragment.newInstance("Fragmento TRÊS","botão TRÊS")

        // assign the fragments to the interface
        val fragmentTransaction=supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frag1,f1)
        fragmentTransaction.add(R.id.frag2,f2)
        fragmentTransaction.add(R.id.frag3,f3)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()


    }
}