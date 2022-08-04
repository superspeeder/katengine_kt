package dev.woc.katengine.utils

import org.joml.Vector2f
import org.joml.Vector2i

class Rect(var x: Float, var y: Float, var w: Float, var h: Float) {
    constructor(pos: Vector2i, size: Vector2i) : this(pos.x.toFloat(), pos.y.toFloat(), size.x.toFloat(), size.y.toFloat())
    constructor(pos: Vector2f, size: Vector2f) : this(pos.x, pos.y, size.x, size.y)

    fun inset(amount: Float): Rect {
        return Rect(x + amount, y + amount, w - amount * 2, h - amount * 2)
    }

    override fun toString(): String {
        return "Rect($x, $y  $w x $h)"
    }

    fun translate(x: Float, y: Float): Rect {
        return Rect(this.x + x, this.y + y, w, h)
    }


}
