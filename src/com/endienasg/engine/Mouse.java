package com.endienasg.engine;

import com.endienasg.engine.window.EngineWindow;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;

public class Mouse {
    private static boolean[] buttons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];

    public static float mouseX;
    public static float mouseY;

    public static boolean buttonDown(int keyId){
        return GLFW.glfwGetMouseButton(EngineWindow.getWindow().id, keyId) == 1;
    }
    public static boolean buttonPressed(int keyId){
        return buttonDown(keyId) && !buttons[keyId];
    }

    public static void setMouseCallbacks(long id){
        setCursorPositionCallback(id);
    }
    public static  void setCursorPositionCallback(long id){
        GLFW.glfwSetCursorPosCallback(id, new GLFWCursorPosCallback() {
            @Override
            public void invoke(long window, double xpos, double ypos) {
                mouseX = (float)xpos;
                mouseY = (float)ypos;
            }
        });
    }


    public static boolean buttonReleased(int keyId){
        return !buttonDown(keyId) && buttons[keyId];
    }
    public static void handleMouseInput(){
        for(int i = 0; i < GLFW.GLFW_MOUSE_BUTTON_LAST; i++){
            buttons[i] = buttonDown(i);
        }

    }
}
