package com.ashindigo.pi.tftcontroller;

import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 * Button that launches an IApplication when clicked
 * @author Ash Indigo
 *
 */
public class ButtonApp extends JButton {
	
	public IApplication app;

	private static final long serialVersionUID = 1779035157700614366L;

	public ButtonApp(Icon icon, IApplication app) {
		super(icon);
		this.app = app;
	}

	public ButtonApp(String text, IApplication app) {
		super(text);
		this.app = app;
		this.setMargin(new Insets(0,0,0,0));
	}

	public ButtonApp(String text, Icon icon, IApplication app) {
		super(text, icon);
		this.app = app;
		this.setMargin(new Insets(0,0,0,0));
	}

}
