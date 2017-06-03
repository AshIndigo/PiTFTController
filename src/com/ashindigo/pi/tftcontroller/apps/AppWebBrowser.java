package com.ashindigo.pi.tftcontroller.apps;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.ashindigo.pi.tftcontroller.EnumRotate;
import com.ashindigo.pi.tftcontroller.IApplication;
import com.ashindigo.pi.tftcontroller.PiTFTControllerMain;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

public class AppWebBrowser implements IApplication {
	
	static JFrame appFrame = new JFrame();
	static JTextField urlBox = new JTextField();
	static JButton tabButton = new JButton();

	@Override
	public void open() {
		if (PiTFTControllerMain.fullScreen) {
			appFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			appFrame.setUndecorated(true);
		}
		JFXPanel jfxPanel = new JFXPanel();
		appFrame.add(jfxPanel);

		Platform.runLater(() -> {
		    WebView webView = new WebView();
		    jfxPanel.setScene(new Scene(webView));
		    webView.getEngine().setJavaScriptEnabled(true);
		    webView.getEngine().setUserAgent("Mozilla/5.0 (Linux; Android 6.0.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile");
		    webView.getEngine().load("https://html5test.com");
		});
		
		rotate(PiTFTControllerMain.rotationMode);
		appFrame.add(urlBox);
		appFrame.add(tabButton);
		appFrame.setVisible(true);
	}

	@Override
	public void exit() {
		appFrame.dispose();	
	}

	@Override
	public String getName() {
		return "Web";
	}

	@Override
	public void rotate(EnumRotate rotation) {
		if (rotation == EnumRotate.VERTICAL) {
			appFrame.setSize(320, 480);
		} else if (rotation == EnumRotate.HORIZONTAL) {
			appFrame.setSize(480, 320);
			urlBox.setSize(440, 25);
		}
		
	}

}
