package com.company;

import javax.swing.*;
public class PDApplication {

	public static void main(String[] args) {
		PDGUI frame = new PDGUI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
