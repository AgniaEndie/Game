package com.endienasg.engine;

import com.endienasg.engine.window.EngineWindow;
import org.lwjgl.glfw.GLFW;

public class Keyboard {
    private static boolean[] keys = new boolean[GLFW.GLFW_KEY_LAST];

    public static boolean keyDown(int keyId){
        return GLFW.glfwGetKey(EngineWindow.getWindow().id, keyId) == 1;
    }
    public static boolean keyPressed(int keyId){
        return keyDown(keyId) && !keys[keyId];
    }
    public static boolean keyReleased(int keyId){
        return !keyDown(keyId) && keys[keyId];
    }
    public static void handleKeyboardInput(){
        for(int i = 0; i < GLFW.GLFW_KEY_LAST; i++){
            keys[i] = keyDown(i);
        }

    }
}
