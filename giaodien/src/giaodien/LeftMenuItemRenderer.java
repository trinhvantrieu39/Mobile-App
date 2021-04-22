package giaodien;
import java.awt.*;
import java.awt.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class LeftMenuItemRenderer extends JPanel implements ListCellRenderer<LeftMenuItem>{
	private JLabel icon = new JLabel();
	private JLabel name = new JLabel();
	private JPanel panelicon;
	private JPanel paneltext;
	public LeftMenuItemRenderer() {
		setLayout(new BorderLayout(0,0));
		//GridLayout layout = new GridLayout();
		//layout.set;
		paneltext = new JPanel(new GridLayout(0,1));
		paneltext.setBorder(new EmptyBorder(0,0,0,10));
		paneltext.add(name);
		
		panelicon = new JPanel();
		panelicon.add(icon);
		panelicon.setBorder(new EmptyBorder(10,2,5,10));
		add(panelicon, BorderLayout.WEST);
		add(paneltext, BorderLayout.CENTER);
	}
	@Override
	public Component getListCellRendererComponent(JList<? extends LeftMenuItem> list, LeftMenuItem LeftMenuItem, int index,
			boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		icon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/"+LeftMenuItem.getIconName() + ".png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
//		icon.setIcon((Icon) new ImageIcon(getClass().getResource("/images/"+LeftMenuItem.getIconName() + ".png")).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		name.setText(LeftMenuItem.getName());
		//set Opaque
		name.setOpaque(true);
		icon.setOpaque(true);
		//when selected item
		
		if(isSelected) {
			name.setBackground(list.getSelectionBackground());
			icon.setBackground(list.getSelectionBackground());
			setBackground(list.getSelectionBackground());
			panelicon.setBackground(list.getSelectionBackground());
			paneltext.setBackground(list.getSelectionBackground());
		}
		else {
		name.setBackground(list.getBackground());
		icon.setBackground(list.getBackground());
		setBackground(list.getBackground());
		panelicon.setBackground(list.getBackground());
		paneltext.setBackground(list.getBackground());
		}
		
		return this;
	}
	
}
