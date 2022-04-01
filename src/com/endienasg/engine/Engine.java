package com.endienasg.engine;

import com.endienasg.engine.window.EngineWindow;
import org.lwjgl.glfw.GLFW;

public class Engine {


    public static final int WIDTH = 640;
    public static final int HEIGHT = 360;
    public static final String TITLE = "Game";
    private EngineWindow engineWindow;


    public  void run(){
        this.init();

    }
    public void init(){
        this.engineWindow = new EngineWindow(WIDTH,HEIGHT,TITLE);
        this.engineWindow.create();
        this.update();
    }
    public void update(){
        while(!this.engineWindow.isCloseRequest()){
           //render
            if(Keyboard.keyPressed(GLFW.GLFW_KEY_A)){
                System.out.println("A is Pressed");
            }
            if(Keyboard.keyPressed(GLFW.GLFW_KEY_D)){
                System.out.println("D is Pressed");
            }
            if(Keyboard.keyPressed(GLFW.GLFW_KEY_W)){
                System.out.println("W is Pressed");
            }
            if(Keyboard.keyPressed(GLFW.GLFW_KEY_S)){
                System.out.println("S is Pressed");
            }



            if (Mouse.buttonPressed(0)) {
                System.out.println("Mouse 0 is Pressed");
            }
            else if(Mouse.buttonReleased(0)){
                System.out.println("Mouse 0 is Released");
            }
            System.out.println("x" + Mouse.mouseX + ", y:" + Mouse.mouseY);


            Keyboard.handleKeyboardInput();
            Mouse.handleMouseInput();
            this.engineWindow.update();

        }
        this.engineWindow.destroy();
    }

    public EngineWindow getEngineWindow() {
        return this.engineWindow;
    }
}
