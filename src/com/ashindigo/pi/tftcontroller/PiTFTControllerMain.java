package com.ashindigo.pi.tftcontroller;

import java.io.IOException;
import javax.swing.JFrame;

import com.ashindigo.pi.tftcontroller.apps.MonitorThread;

/*
 * App notes
 * - Shutdown / Reboot - Done
 * - Terminal - Just go back to shell
 * - Connection Manager for bluetooth and WiFi
 * - Update 
 * - Music Client - 
 * - Dialer (Needs FONA Module) - Need to add dial function
 * - Status Checker - Need heat checker
 * - IRC/Chat client - Need to add multi network and multi channel support
 * - Retropie! - Launches emulationstation and maybe kills off the xserver
 * - Web browser
 * - File manager - Could just use the terminal instead though
 * Allow for external apps to be loaded in a folder from jars - Done
 * Rotate based on gyroscope.
 */
public class PiTFTControllerMain {

	static JFrame mainFrame = new JFrame();
	public static EnumRotate rotationMode = EnumRotate.VERTICAL;
	public static boolean fullScreen = false;

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
		mainFrame.setSize(320, 480);
		if (args.length > 0) {
			switch (Integer.parseInt(args[0])) {
			case 0: rotationMode = EnumRotate.VERTICAL; mainFrame.setSize(320, 480); break;
			case 1: rotationMode = EnumRotate.HORIZONTAL; mainFrame.setSize(480, 320); break;
			}
			switch (Integer.parseInt(args[1])) {
			case 0: fullScreen = false; break;
			case 1: fullScreen = true; break;
			}
		}
		AppLoader.loadExternal();
		AppLoader.loadInternal();
		new MonitorThread().start();
		mainFrame.setLayout(null);
		if (PiTFTControllerMain.fullScreen) {
			mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Uncomment to make full screen
			mainFrame.setUndecorated(true); // Removes window buttons
		}
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AppList.setupList();
		setupButtons();
	}
	
	private static void setupButtons() {
		if (rotationMode == EnumRotate.VERTICAL) {
			int x = 9;
			int y = 7;
			int xC = 0;
			for (int i = 0; AppList.appList.size() > i; i++) {
				if (xC == 4) {
					y += 69;
					xC = 0;
					x = 9;
				}
				mainFrame.add(AppList.appList.get(i)).setLocation(x, y);
				x += 73;
				xC++;

			}
		} else if (rotationMode == EnumRotate.HORIZONTAL) {
			int y = 9;
			int x = 7;
			int xC = 0;
			for (int i = 0; AppList.appList.size() > i; i++) {
				if (xC == 6) {
					x += 69;
					xC = 0;
					y = 9;
				}
				mainFrame.add(AppList.appList.get(i)).setLocation(y, x);
				y += 73;
				xC++;
			}
		}
	}

}
