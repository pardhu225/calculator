package com.calculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.calculator.interfaces.CalComponent;

public class IsFunctionsPanel extends JPanel implements ActionListener,CalComponent<IsFunctionsPanel>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton isprime;
	JButton isarms;
	JButton iseven;
	JButton isodd;
	JButton iscomposite;
	JButton is;
	UserInterface i;

	public IsFunctionsPanel(UserInterface o)
	{
		setLayout(new GridLayout(3,2));
		i=o;
		isprime=new JButton("Prime test");
		isprime.setBorder(new EtchedBorder(10));
		isprime.addActionListener(this);
		add(isprime);
		isarms=new JButton("Armstrong test");
		isarms.setBorder(new EtchedBorder(10));
		isarms.addActionListener(this);
		add(isarms);
		iseven=new JButton("Even test");
		iseven.setBorder(new EtchedBorder(10));
		iseven.addActionListener(this);
		add(iseven);
		isodd=new JButton("Odd test");
		isodd.setBorder(new EtchedBorder(10));
		isodd.addActionListener(this);
		add(isodd);
		iscomposite=new JButton("Composite test");
		iscomposite.setBorder(new EtchedBorder(10));
		iscomposite.addActionListener(this);
		add(iscomposite);

	}

	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		case "Prime test":
		{
			int num=(int)Double.parseDouble(i.getIn().getText());
			int c=0;
			for(int i=1;i<=num;i++)
			{
				if(num%i==0)
					c++;
			}
			i.getFooter().setText((c==2)?"This is prime":"This is not prime");
		}
		break;
		case "Armstrong test":
		{
			int num=(int)Double.parseDouble(i.getIn().getText());
			int m=num;
			int sum=0,rem=0;
			while(num!=0)
			{
				rem=num%10;
				sum+=(Math.pow(rem,3));
				num/=10;
			}
			i.getFooter().setText((sum==m)?"This is a armstrong":"This is not armstrong");
		}
		break;
		case "Even test":
			i.getFooter().setText((((int)Double.parseDouble(i.getIn().getText()))%2==0)?"Its even":"Its odd");
			break;
		case "Odd test":
			i.getFooter().setText((((int)Double.parseDouble(i.getIn().getText()))%2!=0)?"Its odd":"Its even");
			break;
		case "Composite test":
		{
			int num=(int)Double.parseDouble(i.getIn().getText());
			int c=0;
			for(int i=1;i<=num;i++)
			{
				if(num%i==0)
					c++;
			}
			i.getFooter().setText((c!=2)?"This is composite":"This is not composite");
		}
		break;
		}
	}

	@Override
	public IsFunctionsPanel init(UserInterface f)
	{
		return new IsFunctionsPanel(f);
	}
}
