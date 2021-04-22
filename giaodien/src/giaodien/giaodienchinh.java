package giaodien;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import CuaHang.CuaHangGUI;
import test.PhoneBook;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.StackWalker.Option;
import java.util.concurrent.CancellationException;



public class giaodienchinh extends JFrame {
private int height = 700;
private int width = 1200;
private JList<LeftMenuItem> list;
private BorderLayout mainLayout = new BorderLayout(0,0);
private JPanel panelmain;
private JPanel content;
private JPanel top;
private JPanel left;
private JPanel cuahang;

public giaodienchinh() {
	
	//setLayout(mainLayout);
	setSize(width,height);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	top =CreateTopPanel();
	
	left = CreateLeftPanel();
	
	content = new JPanel();
	content.setLayout(new BorderLayout());
	
	
	
	JPanel container = new JPanel();
	container.setLayout(mainLayout);
	container.add(top,BorderLayout.NORTH);
	container.add(left,BorderLayout.WEST);
	container.add(content,BorderLayout.CENTER);
	container.setBorder(new EmptyBorder(0,10,10,10));
	add(container);
	setVisible(true);
	/*
	//thiet lap giua man hin
	//setLocationRelativeTo(null);
	setVisible(true);
	
	//khoa thay doi kich thuoc
	//setResizable(false);
	//full man hinh
	//setExtendedState(JFrame.MAXIMIZED_BOTH);
	*/
}

	public JPanel CreateTopPanel() {
		JPanel panel = new JPanel();		
		panel.setLayout(new BorderLayout());
		ImageIcon iconOut = new ImageIcon();
		
		String TenNguoiDung="trieu";
		iconOut=new ImageIcon(getClass().getResource("/images/logout.png"));
		JLabel logout = new JLabel(TenNguoiDung,iconOut,JLabel.CENTER);
		
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
                
                if(JOptionPane.showConfirmDialog(logout, "Bạn có muốn đăng xuất?")==JOptionPane.YES_OPTION) {
                	System.out.println("Đăng xuất");
                }
            }
		});
		ImageIcon iconGH = new ImageIcon();
		iconGH = new ImageIcon(getClass().getResource("/images/shopping.png"));
		JLabel donhang = new JLabel("",iconGH,JLabel.CENTER);
		donhang.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				//đơn hàng
			}
		});
		
		JLabel luachon = new JLabel("Cửa hàng");
		
		panel.add(logout,BorderLayout.WEST);
		panel.add(donhang,BorderLayout.EAST);
		
		panel.setBorder(new EmptyBorder(10, 10, 10, 30));
		return panel;
	}
	public JPanel CreateLeftPanel() {
		
		JPanel panel = new JPanel(new BorderLayout());
		JScrollPane sp = new JScrollPane(list = createList());
		panel.add(sp,BorderLayout.CENTER);
		return panel;
	}
	
	private JList<LeftMenuItem> createList() {
		DefaultListModel<LeftMenuItem> model = new DefaultListModel<>();
		model.addElement(new LeftMenuItem("Cửa hàng","shop"));
		model.addElement(new LeftMenuItem("Hóa đơn","bill"));
		model.addElement(new LeftMenuItem("Sản phẩm","watch"));
		model.addElement(new LeftMenuItem("Nhập hàng","checklist"));
		model.addElement(new LeftMenuItem("Nhân viên","employee"));
		model.addElement(new LeftMenuItem("Khách hàng","user"));
		model.addElement(new LeftMenuItem("Nhà cung cấp","company"));
		model.addElement(new LeftMenuItem("Tài khoản","account"));
		
		list = new JList<LeftMenuItem>(model);
		list.setCellRenderer(new LeftMenuItemRenderer());
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				LeftSelec();
			}
		});
		return list;
	}
	private void LeftSelec() {
		String nameAction=String.valueOf(list.getSelectedValue());
		//JOptionPane.showConfirmDialog(this, nameAction);
		content.removeAll();
		switch(nameAction){
			case "Cửa hàng":{
				cuahang = new CuaHangGUI();
				content.add(cuahang);
				break;
			}
			case "Nhân viên":{
			
				break;
			}
		}

		revalidate();
		repaint();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new giaodienchinh() ;
		 
		
	}

}
