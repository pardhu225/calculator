package com.calculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.calculator.interfaces.CalComponent;

public class NumberPanel extends JPanel implements ActionListener,CalComponent<NumberPanel>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton c;
	UserInterface i;
	JButton[] nums= {
			new JButton("0"),
			new JButton("1"),
			new JButton("2"),
			new JButton("3"),
			new JButton("4"),
			new JButton("5"),
			new JButton("6"),
			new JButton("7"),
			new JButton("8"),
			new JButton("9")
			};
	public NumberPanel(final UserInterface io)
	{
		this.i=io;
		setLayout(new GridLayout(3,3));
		for(JButton n:nums)
		{
			n.setBorder(new EtchedBorder(25));
			n.addActionListener(this);
			add(n);
		}
		c=new JButton("C");
		c.setBorder(new EtchedBorder(10));
		add(c);
		c.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				i.getIn().setText("");
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		i.getIn().setText(i.getIn().getText()+e.getActionCommand());
	}

	@Override
	public NumberPanel init(UserInterface f)
	{
		return new NumberPanel(f);
	}

}
