package com.mtl.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by MTL on 2019/11/25
 */
public class WinUtil {

    public static void sendNotification(String title1, String subtitle1, String pathToIcon1) {
        sendNotification(title1, subtitle1, pathToIcon1, 7000);
    }

    public static void sendNotification(String title1, String subtitle1, String pathToIcon1, long sleepTime1) {

        final String title = title1;
        final String subtitle = subtitle1;
        final String pathToIcon = pathToIcon1;
        final long sleepTime = sleepTime1;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                SystemTray mainTray = SystemTray.getSystemTray();
                Image trayIconImage = ImageIO.read(new File(pathToIcon));

                TrayIcon mainTrayIcon = new TrayIcon(trayIconImage);
                mainTrayIcon.setImageAutoSize(true);
                    mainTray.add(mainTrayIcon);
                    mainTrayIcon.displayMessage(title,  subtitle, TrayIcon.MessageType.NONE);

                    Thread.sleep(sleepTime);
                    mainTray.remove(mainTrayIcon);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
