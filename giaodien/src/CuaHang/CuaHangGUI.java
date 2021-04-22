package CuaHang;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class CuaHangGUI extends JPanel{
	private JTable banhangTable = new JTable();
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane sp ;
	private JPanel text;
	private JPanel image;
	private JLabel ImageSP = new JLabel();
	private JTextField masp = new JTextField(20);
	private JTextField tensp = new JTextField(20);
	private JTextField loaisp = new JTextField(20);
	private JTextField dongia = new JTextField(20);
	private SpinnerNumberModel soluong = new SpinnerNumberModel();	//cài số lượng tối đa -> get bên sản phẩm
	//private int soluongsp;
	
	
	public CuaHangGUI(){
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JPanel info = CreateInput();
		add(info);
		banhangTable.setModel(model);
		model.addColumn("Mã SP");
		model.addColumn("Tên SP");
		model.addColumn("Loại SP");
		model.addColumn("Đơn Giá");
		
		sp = new JScrollPane(banhangTable);
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
		
		masp.setBorder(BorderFactory.createTitledBorder(border,"Mã sản phẩm"));
		masp.setEditable(false);
		text.add(masp);
		
		loaisp.setBorder(BorderFactory.createTitledBorder(border,"Loại sản phẩm"));
		loaisp.setEditable(false);
		text.add(loaisp);
		
		tensp.setBorder(BorderFactory.createTitledBorder(border,"Tên sản phẩm"));
		tensp.setEditable(false);
		text.add(tensp);
		
		dongia.setBorder(BorderFactory.createTitledBorder(border,"Đơn giá"));
		dongia.setEditable(false);
		text.add(dongia);
		
		soluong = new SpinnerNumberModel(0, 0, 10, 1);
		addModel("Số lượng",soluong);
		
		panel.add(text,BorderLayout.CENTER);
		panel.add(image,BorderLayout.WEST);
		text.setBorder(new EmptyBorder(40, 0, 0, 0));
		return panel;
	}
	private void addModel(String title, SpinnerNumberModel model) {
		
		//soluongsp = soluong.getNumber().intValue();
		text.add(new JLabel(title));
		JSpinner spinner = new JSpinner(model);
		spinner.setPreferredSize(new Dimension(80,30));
		
		text.add(spinner);
	}
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JPanel p = new CuaHangGUI();
		f.add(p);
		f.setVisible(true);
		f.pack();
	}
}
