package test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhoneBook extends JPanel {
	private JLabel lb;
	private JButton bt1,bt2;
	private JTable tb1;
	//private JFrame f;
	DefaultTableModel model = new DefaultTableModel();
	int[] list;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PhoneBook phone = new PhoneBook();
		f.add(phone);
		f.setVisible(true);
		f.setSize(700, 650);
	}
	public PhoneBook() {
		//f = new JFrame("Phone Book");
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		DefaultTableModel model = new DefaultTableModel();
		
		JPanel panel1= new JPanel();
		lb = new JLabel("Phonebook");
		panel1.add(lb);
		
		tb1 = new JTable();
		tb1.setModel(model);
		
		model.addColumn("Name");
		model.addColumn("Phone no");
		
		
		
		JScrollPane sp = new JScrollPane(tb1);
		bt1= new JButton("Add Contact");
		bt2= new JButton("Delete Contact");
		
		JPanel panel3 = new JPanel();
		panel3.add(bt1);
		panel3.add(bt2);
		
		
		
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				model.addRow(new Object[] {JOptionPane.showInputDialog("name"),JOptionPane.showInputDialog("phone")});
			
			}
			
		});
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int i =tb1.getSelectedRow();
				if(i>=0) {
					model.removeRow(tb1.getSelectedRow());
				}
				
				
				
			}
			
		});
		
		
		add(panel1);
		add(sp);
		add(panel3);
		
		
		
	}
	

}

