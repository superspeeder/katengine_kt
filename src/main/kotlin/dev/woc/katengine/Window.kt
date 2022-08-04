package dev.woc.katengine

import dev.woc.katengine.utils.memVector2i
import org.joml.Vector2i
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.opengl.GL

class Window(size: Vector2i, title: String) : AutoCloseable {

    private val window: Long

    init {
        glfwDefaultWindowHints()
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE)
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4)
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 6)
        glfwWindowHint(GLFW_OPENGL_DEBUG_CONTEXT, if (KatEngine.debugging) GLFW_TRUE else GLFW_FALSE)
        window = glfwCreateWindow(size.x, size.y, title, 0L, 0L)

        glfwMakeContextCurrent(window)
        GL.createCapabilities()
    }

    override fun close() {
        glfwDestroyWindow(window)
    }

    fun update() {
        glfwSwapBuffers(window)
    }

    fun isOpen(): Boolean {
        return !glfwWindowShouldClose(window)
    }

    fun whileOpen(func: () -> Unit) {
        while (isOpen()) {
            updateEvents()

            func()

            update()
        }
        close()
    }

    fun getFramebufferSize(): Vector2i {
        return memVector2i { x, y ->
            glfwGetFramebufferSize(window, x, y)
        }
    }

    companion object {
        fun updateEvents() {
            glfwPollEvents()
        }

        fun getTime(): Double {
            return glfwGetTime()
        }
    }
}