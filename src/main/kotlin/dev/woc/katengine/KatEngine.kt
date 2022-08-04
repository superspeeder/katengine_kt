package dev.woc.katengine

import dev.woc.katengine.utils.Rect
import org.joml.Vector2i
import org.joml.Vector3f
import org.joml.Vector4f
import org.lwjgl.glfw.GLFW.*
import java.util.*
import org.lwjgl.opengl.GL46.*

object KatEngine {
    var debugging: Boolean = System.getenv("KATENGINE_DEBUG").lowercase(Locale.getDefault()) == "true"

    fun init() {
        glfwInit()
        if (debugging) {
            println("Debugging is enabled")
        }
    }

    fun cleanup() {
        glfwTerminate()
    }

    fun viewport(window: Window) {
        viewport(window.getFramebufferSize())
    }

    fun viewport(viewport: Vector2i) {
        viewport(Vector2i(0, 0), viewport)
    }

    fun viewport(position: Vector2i, size: Vector2i) {
        viewport(position.x, position.y, size.x, size.y)
    }

    fun viewport(rect: Rect) {
        viewport(rect.x.toInt(), rect.y.toInt(), rect.w.toInt(), rect.h.toInt())
    }

    fun viewport(x: Int, y: Int, w: Int, h: Int) {
        glViewport(x, y, w, h)
    }

    fun clear(color: Vector4f) {
        glClearColor(color.x, color.y, color.z, color.w)
        clear()
    }

    fun clear() {
        glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT or GL_STENCIL_BUFFER_BIT)
    }

    fun clear(color: Vector3f) {
        clear(Vector4f(color, 1.0f))
    }

    fun enableScissor() {
        glEnable(GL_SCISSOR_TEST)
    }

    fun disableScissor() {
        glDisable(GL_SCISSOR_TEST)
    }

    fun scissor(rect: Rect) {
        scissor(rect.x.toInt(), rect.y.toInt(), rect.w.toInt(), rect.h.toInt())
    }

    fun scissor(x: Int, y: Int, w: Int, h: Int) {
        glScissor(x, y, w, h)
    }

    fun scissor(window: Window) {
        scissor(Vector2i(0, 0), window.getFramebufferSize())
    }

    fun scissor(pos: Vector2i, size: Vector2i) {
        scissor(pos.x, pos.y, size.x, size.y)
    }


}