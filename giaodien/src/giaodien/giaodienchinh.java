package giaodien;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import CuaHang.CuaHangGUI;
import NhapHang.NhapHangGUI;
import test.PhoneBook;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.StackWalker.Option;
import java.util.concurrent.CancellationException;



public class giaodienchinh extends JFrame {
private int height = 700;
private int width = 1300;
private JList<LeftMenuItem> list;
private BorderLayout mainLayout = new BorderLayout(0,0);

private JPanel content;
private JPanel top;
private JPanel left;

private JLabel luachon;
private JLabel donhangOut=new JLabel();
private JLabel donhangIn =new JLabel();

private JLabel logout;

private JPanel cuahang;
private JPanel nhaphang;
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
		JPanel panel = new JPanel(); //panel chinh	
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 18);
		panel.setLayout(new BorderLayout());
		
		ImageIcon iconOut = new ImageIcon();// icon dangxuat
		
		

		iconOut=new ImageIcon(getClass().getResource("/images/logout.png"));
		logout = new JLabel("Triều",iconOut,JLabel.CENTER);
		logout.setFont(font);
		
		//tennguoidung = new JLabel("")
		//dangxuat.add(logout);
		//dangxuat.add(tennguoidung);
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
                
                if(JOptionPane.showConfirmDialog(content, "Bạn có muốn đăng xuất?","Chú ý",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                	System.out.println("Đăng xuất");
                }
            }
		});
		
		luachon = new JLabel("", SwingConstants.CENTER);
		
		luachon.setFont(font);
		panel.add(logout,BorderLayout.WEST);
		panel.add(luachon,BorderLayout.CENTER);
		
		
		panel.setBorder(new EmptyBorder(10, 10, 10, 30));
		return panel;
	}
	private void addDonHangOut(JPanel top) {
		ImageIcon iconGH = new ImageIcon();
		iconGH = new ImageIcon(getClass().getResource("/images/shopping.png"));
		donhangOut = new JLabel("",iconGH,JLabel.CENTER);
		donhangOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				//đơn hàng
				JOptionPane.showMessageDialog(content, "Gio hang");
			}
		});
		top.add(donhangOut,BorderLayout.EAST);
	}
	private void addDonHangIn(JPanel top) {
		ImageIcon iconIn = new ImageIcon();
		iconIn = new ImageIcon(getClass().getResource("/images/import.png"));
		donhangIn = new JLabel ("",iconIn,JLabel.CENTER);
		donhangIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				JOptionPane.showMessageDialog(content, "don hang in");
			}
		});
		top.add(donhangIn,BorderLayout.EAST);
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
		model.addElement(new LeftMenuItem("Nhập hàng","checklist"));
		model.addElement(new LeftMenuItem("Sản phẩm","watch"));
		model.addElement(new LeftMenuItem("Hóa đơn","bill"));
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
		top.remove(donhangIn);
		top.remove(donhangOut);
		
		switch(nameAction){
			case "Cửa hàng":{
				luachon.setText("CỬA HÀNG");
				addDonHangOut(top);		//add logo gio hang
				
				cuahang = new CuaHangGUI();
				content.add(cuahang);
				break;
			}
			case "Hóa đơn":{
				luachon.setText("HÓA ĐƠN");
				logout.setText("Aka");
				break;
			}
			case "Sản phẩm":{
				luachon.setText("SẢN PHẨM");
				break;
			}
			case "Nhập hàng":{
				addDonHangIn(top);		//add logo nhap hang
				luachon.setText("NHẬP HÀNG");
				
				nhaphang = new NhapHangGUI();
				content.add(nhaphang);
				break;
			}
			case "Nhân viên":{
				luachon.setText("NHÂN VIÊN");
				break;
			}
			case "Khách hàng":{
				luachon.setText("KHÁCH HÀNG");
				break;
			}
			case "Nhà cung cấp":{
				luachon.setText("NHÀ CUNG CẤP");
				break;
			}
			case "Tài khoản":{
				luachon.setText("TÀI KHOẢN");
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
