package dev.woc.katengine.utils

import org.joml.Vector2i
import org.lwjgl.system.MemoryStack
import java.nio.IntBuffer

fun memVector2i(f: (IntBuffer, IntBuffer) -> Unit): Vector2i {
    MemoryStack.stackPush().use {
        val x = it.mallocInt(1).rewind()
        val y = it.mallocInt(1).rewind()

        f(x, y)

        return Vector2i(x.rewind().get(),y.rewind().get())
    }
}