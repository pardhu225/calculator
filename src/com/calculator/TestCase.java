package com.calculator;

import java.io.File;
import java.lang.reflect.Method;

import javax.swing.JPanel;

public class TestCase
{
	public static void main(String[] args) throws Throwable
	{
		UserInterface ui=new UserInterface();
		String[] files=new File("F:\\Eclipse 4.2.1\\eclipse\\workspace\\Calculator\\bin\\com\\calculator").list();
		for(String x:files)
		{
			if(x.endsWith(".class")&&!x.endsWith("$1.class"))
			{
				String t=new File("F:\\eclipse\\workspace\\Calculator\\bin\\com\\calculator\\src\\"+x).getName();
				StringBuffer bf=new StringBuffer(t);
				String className="com.calculator."+bf.delete(bf.lastIndexOf("."),bf.length());
				Class<?> c=Class.forName(className);
				int itr=0;
				//System.out.print(className);
				for(Class<?> i:c.getInterfaces())
				{
					if(i.toString().equals("interface com.calculator.interfaces.Initializable"))
					{
						//System.out.print(" Initializable");
						Object o=c.newInstance();
						Method m=c.getMethod("init",UserInterface.class);
						m.invoke(o,ui);
						ui.getTabs().add(String.valueOf(++itr),(JPanel)o);
						break;
					}
				}
				//System.out.println();
			}
		}
		ui.pack();
		ui.setVisible(true);
	}
}
