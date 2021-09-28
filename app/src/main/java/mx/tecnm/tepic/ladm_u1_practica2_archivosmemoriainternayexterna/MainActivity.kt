package mx.tecnm.tepic.ladm_u1_practica2_archivosmemoriainternayexterna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.*
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Btnguardar.setOnClickListener {
                if (guardarEnMemoriaInterna() == true) {
                    AlertDialog.Builder(this).setTitle("ATENCION")
                        .setMessage("SE GUARDO M Interna")
                        .setPositiveButton("Ok") { d, i -> d.dismiss() }
                        .show()
                } else {
                    AlertDialog.Builder(this).setTitle("ERROR")
                        .setPositiveButton("Ok") { d, i -> d.dismiss() }
                        .show()
                }
            }
    }

    private fun guardarEnMemoriaInterna(): Boolean {
        try {
            var flujoSalida =
                OutputStreamWriter(openFileOutput(text1.text.toString(), MODE_PRIVATE))
            var data = text2.text.toString()
            flujoSalida.write(data)
            flujoSalida.flush()
            flujoSalida.close()
        }catch (io: IOException){
            return false
        }

        return true;
    }


}