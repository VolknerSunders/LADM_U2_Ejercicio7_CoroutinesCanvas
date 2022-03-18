package mx.tecnm.tepic.ladm_u2_ejercicio7_coroutinescanvas

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lienzo(este:MainActivity) : View(este) {
    val este = este
    val circulos = Array<Circulo>(50,{Circulo(this)})

    val coroutina = GlobalScope.launch {
        while(true){
            este.runOnUiThread{
                invalidate()
            }
            delay(20L)
        }
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()
        c.drawColor(Color.BLACK)
        /*
        for(circ in circulos){
            circ.mover()
            circ.pintar(c)
        }
        */
        (0..circulos.size-1).forEach {
            circulos[it].mover()
            circulos[it].pintar(c)
        }

    }
}