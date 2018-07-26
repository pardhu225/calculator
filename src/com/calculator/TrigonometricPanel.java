package com.calculator;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.calculator.interfaces.CalComponent;

public class TrigonometricPanel extends JPanel implements ActionListener,CalComponent<TrigonometricPanel>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserInterface i;
	JButton[] b=
		{
			new JButton("Sin"),
			new JButton("Cos"),
			new JButton("Tan"),
			new JButton("Cot"),
			new JButton("Sec"),
			new JButton("Cosec"),
			new JButton("Angular sin"),
			new JButton("Angular cos"),
			new JButton("Angular tan"),
			new JButton("Hyperbolic sin"),
			new JButton("Hyperbolic cos"),
			new JButton("Hyperbolic tan")
		};
	CheckboxGroup cbg;
	Checkbox rad;
	Checkbox deg;
	public TrigonometricPanel()
	{
		this(null);
	}
	public TrigonometricPanel(UserInterface d)
	{
		i=d;
		setLayout(new BorderLayout());
		JPanel p=new JPanel();
		for(JButton b:this.b)
		{
			b.setBorder(new EtchedBorder(10));
			b.addActionListener(this);
			p.add(b);
		}
		add(p,BorderLayout.CENTER);
		cbg=new CheckboxGroup();
		rad=new Checkbox("Radians",false,cbg);
		deg=new Checkbox("Degrees",false,cbg);
		JPanel temp=new JPanel();
		temp.setLayout(new GridLayout(3,1));
		temp.add(new JLabel("Input as:"));
		temp.add(rad);
		temp.add(deg);
		add(temp,BorderLayout.WEST);
	}
	
	public TrigonometricPanel init(UserInterface f)
	{
		return new TrigonometricPanel(f);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		case "Sin":
			i.getIn().setText(String.valueOf(Math.sin(correct(Double.parseDouble(i.getIn().getText())))));
			break;
		case "Cos":
			i.getIn().setText(String.valueOf(Math.cos(correct(Double.parseDouble(i.getIn().getText())))));
			break;
		case "Tan":
			i.getIn().setText(String.valueOf(Math.tan(correct(Double.parseDouble(i.getIn().getText())))));
			break;
		case "Cot":
			i.getIn().setText(String.valueOf(1/Math.tan(correct(Double.parseDouble(i.getIn().getText())))));
			break;
		case "Sec":
			i.getIn().setText(String.valueOf(1/Math.cos(correct(Double.parseDouble(i.getIn().getText())))));
			break;
		case "Cosec":
			i.getIn().setText(String.valueOf(1/Math.sin(correct(Double.parseDouble(i.getIn().getText())))));
			break;
		case "Angular sin":
			i.getIn().setText(String.valueOf(Math.asin(correct(Double.parseDouble(i.getIn().getText())))));
			break;
		case "Angular cos":
			i.getIn().setText(String.valueOf(Math.acos(correct(Double.parseDouble(i.getIn().getText())))));
			break;
		case "Angular tan":
			i.getIn().setText(String.valueOf(Math.atan(correct(Double.parseDouble(i.getIn().getText())))));
			break;
		case "Hyperbolic tan":
			i.getIn().setText(String.valueOf(Math.tanh(correct(Double.parseDouble(i.getIn().getText())))));
			break;
		case "Hyperbolic cos":
			i.getIn().setText(String.valueOf(Math.cosh(correct(Double.parseDouble(i.getIn().getText())))));
			break;
		case "Hyperbolic sin":
			i.getIn().setText(String.valueOf(Math.sinh(correct(Double.parseDouble(i.getIn().getText())))));
			break;
		}
	}

	private double correct(double d)
	{
		if(cbg.getSelectedCheckbox()==deg)
			return Math.toRadians(d);
		return d;
	}
}
