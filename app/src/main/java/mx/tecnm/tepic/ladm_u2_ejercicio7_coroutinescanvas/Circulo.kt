package mx.tecnm.tepic.ladm_u2_ejercicio7_coroutinescanvas

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Circulo(l:Lienzo) {
    val l = l
    var x = 0f
    var y = 0f
    var movX = 0f
    var movY = 0f
    var color = Color.BLACK

    init {
        x = rand(1000)
        y = rand(1900)
        movX = rand(6)+2
        movY = rand(6)+2
        if (rand(100)<50f){
            movX *= -1
        }
        if (rand(100)<50f){
            movY *= -1
        }

        color = Color.rgb(rand(255).toInt(),rand(255).toInt(),rand(255).toInt())
    }

    private fun rand(hasta:Int) : Float {
        return Random.nextInt(hasta).toFloat()
    }

    fun mover(){
        x+=movX
        y+=movY
        if(x<0 || x>l.width){
            movX *= -1
        }
        if(y<0 || y>l.width){
            movY *= -1
        }
    }

    fun pintar(canvas: Canvas){
        var p = Paint()
        p.color = color
        canvas.drawCircle(x,y,50f,p)

    }
}