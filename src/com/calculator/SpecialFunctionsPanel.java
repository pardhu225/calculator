package com.calculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.calculator.interfaces.CalComponent;

public class SpecialFunctionsPanel extends JPanel implements ActionListener,CalComponent<SpecialFunctionsPanel>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserInterface i;
	JButton[] b=
		{
			new JButton("Square root"),
			new JButton("Cube root"),
			new JButton("Absolute value"),
			new JButton("Round to the smallest real"),
			new JButton("Round to the largest real")
		};
	
	public SpecialFunctionsPanel(UserInterface o)
	{
		i=o;
		setLayout(new FlowLayout(FlowLayout.CENTER));
		for(JButton b:this.b)
		{
			b.addActionListener(this);
			b.setBorder(new EtchedBorder(10));
			add(b);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		case "Square root":
			i.getIn().setText(String.valueOf(Math.sqrt(Double.parseDouble(i.getIn().getText()))));
			break;
		case "Cube root":
			i.getIn().setText(String.valueOf(Math.cbrt(Double.parseDouble(i.getIn().getText()))));
			break;
		case "Absolute value":
			i.getIn().setText(String.valueOf(Math.abs(Double.parseDouble(i.getIn().getText()))));
			break;
		case "Round to the smallest real":
			i.getIn().setText(String.valueOf(Math.floor(Double.parseDouble(i.getIn().getText()))));
			break;
		case "Round to the largest real":
			i.getIn().setText(String.valueOf(Math.ceil(Double.parseDouble(i.getIn().getText()))));
			break;
		}
	}

	@Override
	public SpecialFunctionsPanel init(UserInterface f)
	{
		return new SpecialFunctionsPanel(f);
	}
}
