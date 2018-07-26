package com.calculator;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public final class ErrorMessageDialog
{
	private ErrorMessageDialog()
	{
		
	}
	public static void display(String s)
	{
		JFrame f=new JFrame("Error");
		f.setLayout(new FlowLayout());
		f.add(new JLabel(new ImageIcon("error.jpg")));
		f.add(new JLabel(s));
		f.pack();
		f.setVisible(true);
	}
}
