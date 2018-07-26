package com.calculator;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CommonOperationsPanel extends JPanel implements ActionListener
{
	double a;
	JButton plus;
	JButton minus;
	JButton mul;
	JButton div;
	JButton mod;
	JButton exp;
	JButton eq;
	UserInterface i;
	String op="null";
	public CommonOperationsPanel(final UserInterface i)
	{
		JPanel jp=new JPanel(new GridLayout(3,1));
		JPanel holder1=new JPanel(new FlowLayout());;
		JPanel holder2=new JPanel(new FlowLayout());;
		JPanel holder3=new JPanel(new FlowLayout());
		this.i=i;

		plus=new JButton("+");
		minus=new JButton("-");
		mul=new JButton("x");
		holder1.add(plus);
		holder1.add(minus);
		holder1.add(mul);

		div=new JButton(String.valueOf((char)247));
		mod=new JButton("mod");
		exp=new JButton("^");
		holder2.add(div);
		holder2.add(mod);
		holder2.add(exp);

		eq=new JButton("=");
		holder3.add(eq);
		jp.add(holder1);
		jp.add(holder2);
		jp.add(holder3);

		plus.addActionListener(this);
		minus.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		mod.addActionListener(this);
		exp.addActionListener(this);
		eq.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					Process p=java.lang.Runtime.getRuntime().exec("F:\\eclipse\\workspace\\Calculator\\bin\\com\\calculator\\Parser.exe "+purify(i.getIn().getText()));
					InputStream in=p.getInputStream();
					BufferedReader br=new BufferedReader(new InputStreamReader(in));
					i.getIn().setText(br.readLine());
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}

			private String purify(String exp)
			{
				return exp;
			}
		});

		jp.setBounds(50,50,100,100);
		add(jp);
	}

	public void actionPerformed(ActionEvent e)
	{
		i.getIn().setText(i.getIn().getText()+e.getActionCommand());
	}
}