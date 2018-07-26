package com.calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("all")
public class UserInterface extends JFrame
{
	final JLabel in;
	final JLabel footer;
	final JTabbedPane tabs;
	JPanel jp;
	public UserInterface()
	{
		System.out.println("Hello you are in the constructtor");
		tabs=new JTabbedPane();
		jp=new JPanel(new GridLayout(1,2));
		jp.add(tabs,0,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		in=new JLabel();
		footer=new JLabel();
		add(in,BorderLayout.NORTH);
		add(footer,BorderLayout.SOUTH);
		add(tabs,BorderLayout.CENTER);
	}
	public static void main(String[] args)throws Throwable
	{
		UserInterface f = new UserInterface();
		JFrame mini=new JFrame("numbers");
		f.getTabs().add("Common Operations",new CommonOperationsPanel(f));
		f.getTabs().add("The Is functions",new IsFunctionsPanel(f));
		f.getTabs().add("Trigonometry",new TrigonometricPanel(f));
		f.getTabs().add("Special",new SpecialFunctionsPanel(f));
		mini.add(new NumberPanel(f));
		mini.setSize(100,100);
		mini.setVisible(true);
		f.setVisible(true);
		f.setSize(400,300);
	}
	public JLabel getIn()
	{
		return in;
	}
	public JLabel getFooter()
	{
		return footer;
	}
	public void add(JPanel o) {
		super.add(o);
	}
	public JTabbedPane getTabs()
	{
		return tabs;
	}
}
