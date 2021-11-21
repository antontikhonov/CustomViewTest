package ru.antontikhonov.android.customviewedu

import android.content.Context
import android.graphics.*
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import android.widget.TextView

class CustomView(context: Context, attr: AttributeSet? = null) : View(context, attr) {

    private val paint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.FILL_AND_STROKE
    }
    
    private val textPaint = Paint().apply {
        color = Color.WHITE
        textSize = 200f
    }



    private val path = Path().apply {
        lineTo(550f, 0f)
        lineTo(550f, 550f)
        close()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val mode = MeasureSpec.getMode(widthMeasureSpec)
        setMeasuredDimension(400, 300)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        with(canvas!!) {
            canvas.save()
            canvas.clipPath(path)
            canvas.drawLine(0f, 0f, width / 2f, height /2f, paint)
            canvas.drawLine(width.toFloat(), 0f, width / 2f, height /2f, paint)
            canvas.drawLine(0f, height.toFloat(), width / 2f, height /2f, paint)
            canvas.restore()
            canvas.rotate(20f)


            canvas.drawLine(width.toFloat(), height.toFloat(), width / 2f, height /2f, paint)
            canvas.drawText("Hi", 0, 2, width / 2f, height / 2f, textPaint)
            canvas.drawCircle(width / 2f, height / 2f, 100f, paint)

        }
    }
}