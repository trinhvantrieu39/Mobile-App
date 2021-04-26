package NhapHang;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import Button.ButtonAdd;

public class NhapHangGUI extends JPanel{
	private JTable nhaphangTable = new JTable();
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane sp ;
	private JPanel text;
	private JPanel image;
	private JLabel ImageSP = new JLabel();
	private JTextField masp = new JTextField(20);
	private JTextField tensp = new JTextField(20);
	private JTextField loaisp = new JTextField(20);
	private JTextField dongia = new JTextField(20);
	private JTextField timkiem = new JTextField(66);
	private SpinnerNumberModel soluong = new SpinnerNumberModel();	//cài số lượng tối đa -> get bên sản phẩm
	//private int soluongsp;
	
	
	public NhapHangGUI(){
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JPanel info = CreateInput();
		add(info);
		nhaphangTable.setModel(model);
		model.addColumn("Mã SP");
		model.addColumn("Tên SP");
		model.addColumn("Loại SP");
		model.addColumn("Đơn Giá");
		
		sp = new JScrollPane(nhaphangTable);
		add(sp);
	}
	private JPanel CreateInput(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		setBorder(border);
				
		image = new JPanel();
		image.setBorder(border);
		image.setPreferredSize(new Dimension(250, 250));
		image.add(ImageSP);
		
		text = new JPanel();
		text.setPreferredSize(new Dimension(500,250));
		text.setLayout(new BoxLayout(text,BoxLayout.Y_AXIS));
		
		JPanel p0 = new JPanel();
		timkiem.setBorder(BorderFactory.createTitledBorder(border,"Tìm kiếm"));
		p0.add(timkiem);
		
		JPanel p1 = new JPanel();
		masp.setBorder(BorderFactory.createTitledBorder(border,"Mã sản phẩm"));
		masp.setEditable(false);
		p1.add(masp);
		
		loaisp.setBorder(BorderFactory.createTitledBorder(border,"Loại sản phẩm"));
		loaisp.setEditable(false);
		p1.add(loaisp);
		
		tensp.setBorder(BorderFactory.createTitledBorder(border,"Tên sản phẩm"));
		tensp.setEditable(false);
		p1.add(tensp);
		
		JPanel p2 = new JPanel();
		dongia.setBorder(BorderFactory.createTitledBorder(border,"Đơn giá"));
		dongia.setEditable(false);
		p2.add(dongia);
		
		soluong = new SpinnerNumberModel(0, 0, 10, 1);	//get soluong san pham
		addModel("Số lượng",soluong,p2);
		
		JButton them =new ButtonAdd();
		JPanel p3 = new JPanel();
		p3.add(them);
		
		text.add(p0);
		text.add(p1);
		text.add(p2);
		text.add(p3);
		
		panel.add(text,BorderLayout.CENTER);
		panel.add(image,BorderLayout.WEST);
		
		text.setBorder(new EmptyBorder(20, 0, 0, 0));
		return panel;
	}
	private void addModel(String title, SpinnerNumberModel model, JPanel ptext) {
		
		//soluongsp = soluong.getNumber().intValue();
		ptext.add(new JLabel(title));
		JSpinner spinner = new JSpinner(model);
		spinner.setPreferredSize(new Dimension(80,30));
		
		ptext.add(spinner);
	}
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JPanel p = new NhapHangGUI();
		f.add(p);
		f.setVisible(true);
		f.pack();
	}
}
