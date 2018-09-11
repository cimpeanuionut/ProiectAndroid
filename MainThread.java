package com.example.gabriel.myfirstgame;

import android.graphics.Canvas;
import android.provider.Settings;
import android.view.SurfaceHolder;

/**
 * Created by gabriel on 04/01/2017.
 */

public class MainThread extends Thread {
    private int FPS=30;
    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private  GamePanel gamePanel;
    private boolean running;
    public  static Canvas canvas;

    public  MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel)
    {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }

    @Override
    public  void run() {
        long starTime;
        long timeMilles;
        long waitTime;
        long totalTime = 0;
        int frameCount = 0;
        long targetTime = 1000 / FPS;

        while (running) {
            starTime = System.nanoTime();
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
                }
            } catch (Exception e) {
            }
            finally {
                if (canvas!=null)
                {
                    try{
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }catch (Exception e){e.printStackTrace();}
                }
            }


            timeMilles = (System.nanoTime() - starTime) / 1000000;
            waitTime = targetTime-timeMilles;

            try{
                this.sleep(waitTime);
            }catch (Exception e){}

            totalTime +=System.nanoTime() - starTime;
            frameCount++;
            if(frameCount == FPS)
            {
                averageFPS = 1000/((totalTime/frameCount)/1000000);
                frameCount = 0;
                totalTime = 0;
                System.out.println(averageFPS);
            }

        }
    }

    public void  setRunning(boolean b)
    {
        running=b;
    }

}
