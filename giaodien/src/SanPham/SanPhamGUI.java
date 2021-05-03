package SanPham;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import Button.*;

public class SanPhamGUI extends JPanel{
	private JTable sanphamTable = new JTable();
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane sp ;
	private JPanel text;
	private JPanel image;
	private JLabel ImageSP = new JLabel();
	private JTextField masp = new JTextField(20);
	private JTextField tensp = new JTextField(20);
	private JTextField loaisp = new JTextField(20);
	private JTextField dongia = new JTextField(20);
	private JTextField hinhanh = new JTextField(20);
	private JTextField timkiem = new JTextField(66);
	
	private SpinnerNumberModel soluong = new SpinnerNumberModel();	//cài số lượng tối đa -> get bên sản phẩm
	//private int soluongsp;
	
	
	public SanPhamGUI(){
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JPanel info = CreateInput();
		add(info);
		sanphamTable.setModel(model);
		model.addColumn("Mã SP");
		model.addColumn("Tên SP");
		model.addColumn("Loại SP");
		model.addColumn("Đơn Giá");
		model.addColumn("Hình ảnh");
		model.addColumn("Số lượng");
		
		model.addRow(new Object[] {"masp", "tensp", "loaisp", "200", "asd.png", "20"});
		
		sp = new JScrollPane(sanphamTable);
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
		
		p1.add(masp);
		
		loaisp.setBorder(BorderFactory.createTitledBorder(border,"Loại sản phẩm"));
		
		p1.add(loaisp);
		
		tensp.setBorder(BorderFactory.createTitledBorder(border,"Tên sản phẩm"));
		
		p1.add(tensp);
		
		JPanel p2 = new JPanel();
		dongia.setBorder(BorderFactory.createTitledBorder(border,"Đơn giá"));
		hinhanh.setBorder(BorderFactory.createTitledBorder(border,"Hình ảnh"));
		
		p2.add(dongia);
		p2.add(hinhanh);
		
		soluong = new SpinnerNumberModel(0, 0, 10, 1);	//get soluong san pham
		addModel("Số lượng",soluong,p2);
		
		JButton them =new ButtonAdd();
		JButton sua = new ButtonChange();
		sua.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				 
				Sua(me);
				
			}
		});
		JButton xoa = new ButtonRemove();
		
		JPanel p3 = new JPanel();
		p3.add(them);
		p3.add(sua);
		p3.add(xoa);
		
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
	private void Sua(MouseEvent me) {
		int i =sanphamTable.getSelectedRow();
		SanPhamDTO sp = new SanPhamDTO();
		if(i>=0) {
			sp.masp = masp.getText();
			sp.tensp = tensp.getText();
			sp.dongia = dongia.getText();
			sp.hinhanh = hinhanh.getText();
			sp.soluong = soluong.getNumber().toString();
			sp.maloai = loaisp.getText(); 
			
			if(masp.getText().equals("") || tensp.getText().equals("") || dongia.getText().equals("") || hinhanh.getText().equals("") || loaisp.getText().equals("") ) {
				JOptionPane.showMessageDialog(this, "Chưa điền đủ thông tin");
			}
			else {
			//if sửa được bên database
			model.setValueAt(sp.masp,i,0);
			model.setValueAt(sp.tensp, i, 1);
			model.setValueAt(sp.maloai, i, 2);
			model.setValueAt(sp.dongia, i, 3);
			model.setValueAt(sp.hinhanh,i,4);
			model.setValueAt(sp.soluong, i, 5);
			JOptionPane.showMessageDialog(this, "Sửa thành công");
			}
			
		}
		else {
			JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm để sửa");
		}
	}
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JPanel p = new SanPhamGUI();
		f.add(p);
		f.setVisible(true);
		f.pack();
	}
}
