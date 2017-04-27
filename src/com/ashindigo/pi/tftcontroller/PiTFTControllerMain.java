package com.ashindigo.pi.tftcontroller;

import java.io.IOException;

import javax.swing.JFrame;

import com.ashindigo.pi.tftcontroller.apps.MonitorThread;

/*
 * App notes
 * - Shutdown / Reboot
 * - Terminal
 * - Exit button
 * - Connection Manager
 * - Update
 * - Music Client
 * - Dialer (Needs FONA Module)
 * - Status Checker
 * - IRC/Chat client 
 * Allow for external apps to be loaded in a folder from jars
 */
public class PiTFTControllerMain {

	static JFrame mainFrame = new JFrame();

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
		AppLoader.loadExternal();
		AppLoader.loadInternal();
		new MonitorThread().start();
		mainFrame.setSize(320, 480);
		mainFrame.setLayout(null);
		//System.gc(); // Why? Why not?
		//mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Uncomment to make full screen
		//mainFrame.setUndecorated(true); // Removes window buttons
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AppList.setupList();
		setupButtons();
	}
	
	private static void setupButtons() {
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
			//System.out.println(i + ": " + y);
			
		}
	}

}
