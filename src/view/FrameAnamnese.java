package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;


import javax.swing.*;

public class FrameAnamnese 
{
	JFrame frame;
	JPanel pcol1, pcol2, pcol3, pcols, pot1, pot2;
	JRadioButton bt21, bt22, bt31, bt32, bt41, bt42;
	ButtonGroup bg2, bg3, bg4;
	JTextField tfdoencas, tfalergias;
	
	public FrameAnamnese() 
	{
		frame = new JFrame("Anamnese");
		tfalergias = new JTextField(23);
		tfdoencas = new JTextField(15);
		
		pcol1 = new JPanel(new GridLayout(4, 1, 15 , 15));
		pcol1.add(new JLabel("DOENÇA"));
		pcol1.add(new JLabel("INFARTO"));
		pcol1.add(new JLabel("HIPERTENSÃO ARTERIAL"));
		pcol1.add(new JLabel("ASMA"));
		
		bg2 = new ButtonGroup();
		bg3 = new ButtonGroup();
		bg4 = new ButtonGroup();
		bt21 = new JRadioButton();
		bt22 = new JRadioButton();
		bt31 = new JRadioButton();
		bt32 = new JRadioButton();
		bt41 = new JRadioButton();
		bt42 = new JRadioButton();
		bg2.add(bt21); bg3.add(bt22);
		bg3.add(bt31); bg3.add(bt32);
		bg4.add(bt41); bg4.add(bt42);
		
		pcol2 = new JPanel(new GridLayout(4, 1, 10 , 10));
		pcol2.add(new JLabel("SIM"));
		pcol2.add(bt21); pcol2.add(bt31); pcol2.add(bt41);
		
		pcol3 = new JPanel(new GridLayout(4, 1, 10 , 10));
		pcol3.add(new JLabel("NÃO"));
		pcol3.add(bt22); pcol3.add(bt32); pcol3.add(bt42);
		
		pcols = new JPanel(new FlowLayout(FlowLayout.LEFT, 10 ,10));
		pcols.add(pcol1);
		pcols.add(pcol2);
		pcols.add(pcol3);
		
		pot1 = new JPanel(new FlowLayout());
		pot1.add(new  JLabel("QUAL?"));
		pot1.add(tfalergias);
		
		pot2 = new JPanel(new FlowLayout());
		pot2.add(new  JLabel("OUTRAS DOENÇAS?"));
		pot2.add(tfdoencas);
		
		frame.setLayout(new BorderLayout(10,5));
		frame.add(pcols, BorderLayout.NORTH);
		frame.add(pot1, BorderLayout.WEST);
		frame.add(pot2, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
	}
}
