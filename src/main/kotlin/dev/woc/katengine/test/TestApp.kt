package dev.woc.katengine.test

import dev.woc.katengine.KatEngine
import dev.woc.katengine.Window
import dev.woc.katengine.utils.Rect
import org.joml.Vector2i
import org.joml.Vector4f
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    KatEngine.init()

    val window = Window(Vector2i(800, 800), "Window")

    println(window.getFramebufferSize())

    println(Rect(Vector2i(0, 0), window.getFramebufferSize()).inset(200f))

    KatEngine.enableScissor()

    window.whileOpen {
        KatEngine.viewport(window)
        KatEngine.scissor(window)

        KatEngine.clear(Vector4f(0.0f,0.0f,0.0f,1.0f))

        KatEngine.scissor(Rect(Vector2i(0, 0), window.getFramebufferSize())
            .inset(200f)
            .translate((sin(Window.getTime()) * 200f).toFloat(), (cos(Window.getTime()) * 200f).toFloat()
        ))

        KatEngine.clear(Vector4f(1.0f,1.0f,0.0f,1.0f))
    }

    KatEngine.cleanup()
}