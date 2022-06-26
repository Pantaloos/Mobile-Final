package com.example.mobile_final

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.mobile_final.MainActivity.Companion.Brush
import com.example.mobile_final.MainActivity.Companion.path

class PaintView : View {

    var params : ViewGroup.LayoutParams? = null

    companion object{
        var pathList = ArrayList<Path>() //stores our drown lines
        var colorList = ArrayList<Int>()
        var currentBrush = Color.BLACK
    }

    constructor( context: Context) : this(context, null){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super (context, attrs, defStyleAttr){
        init()
    }

    private fun init(){
        Brush.isAntiAlias = true
        Brush.color = currentBrush
        Brush.style = Paint.Style.STROKE
        Brush.strokeJoin = Paint.Join.ROUND
        Brush.strokeWidth = 10f
        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
    //lines' logical drawing
    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x
        var y = event.y

        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x,y)
                return true
            }
            MotionEvent.ACTION_MOVE ->{
                path.lineTo(x,y)
                pathList.add(path)
                colorList.add(currentBrush)
            }
            else -> return false
        }
        postInvalidate() //inform that changes have been made in UI
        return false
    }
    //lines' UI drawing
    override fun onDraw(canvas: Canvas) {
        for (i in pathList.indices){
            Brush.setColor(colorList[i])
            canvas.drawPath(pathList[i], Brush)
            invalidate() //inform that changes have been made in UI
        }
    }

}