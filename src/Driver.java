/*
 * Author: 		Chenxin Lin
 * Description: Converter method class
 * Copyright:	Chenxin Lin @2015
 */

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Driver {
	// The entry main() method
	public static void main(final String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {

		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

		GUI userGUI = new GUI();
		userGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userGUI.setSize(1000, 650); // set frame size
		userGUI.setLocationRelativeTo(null);
		userGUI.setVisible(true); // display frame

		System.out.println("Program is running");
	}
}
