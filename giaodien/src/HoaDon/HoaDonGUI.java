package HoaDon;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import Button.*;
import NhanVien.DateLabelFormatter;
import net.sourceforge.jdatepicker.impl.*;

public class HoaDonGUI extends JPanel{
	private BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
	private JTable nhanvienTable = new JTable();
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane sp ;
	
	private Border border= BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	
	private JTextField mahd = new JTextField(15);
	private JTextField manv = new JTextField(15);
	
	private JComboBox loaisp;
	private JTextField makh = new JTextField(15);
	private JTextField makm = new JTextField(15);
	private JTextField tongtien = new JTextField(15);
	private JDatePickerImpl date;// ngày sinh
	
	
public HoaDonGUI(){
	setLayout(layout);
	
	JPanel panel = CreateInfo();
	nhanvienTable.setModel(model);
	model.addColumn("Mã hóa đơn");
	model.addColumn("Mã NV");
	model.addColumn("Mã KH");
	model.addColumn("Mã khuyến mãi");
	model.addColumn("Loại sản phẩm");
	model.addColumn("Ngày lập");
	model.addColumn("Tổng tiền");
	
	
	sp = new JScrollPane(nhanvienTable);
	add(panel);
	add(sp);
}
private JPanel CreateInfo() {
	JPanel panel = new JPanel();
	
	JPanel  tim= new JPanel();
	JTextField timkiem = new JTextField(20);
	timkiem.setBorder(BorderFactory.createTitledBorder(border,"Tìm kiếm"));
	
	tim.add(timkiem);
	JPanel center = new JPanel();
	center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
	tongtien.setBorder(BorderFactory.createTitledBorder(border,"Tổng tiền"));
	manv.setBorder(BorderFactory.createTitledBorder(border,"Mã nhân viên"));
	mahd.setBorder(BorderFactory.createTitledBorder(border,"Mã hóa đơn"));
	
	JPanel ns = new JPanel();
	
	//ngaysinh.setEditable(false);
	date = cender();
	date.setBorder(BorderFactory.createTitledBorder(border,"Ngày lập"));
	 
	makh.setBorder(BorderFactory.createTitledBorder(border, "Mã khách hàng"));
	makm.setBorder(BorderFactory.createTitledBorder(border, "Mã khuyến mãi"));
	//lấy loại sản phẩm ở database vào
	String gt[] = {"lsp1", "lsp2"};
	JLabel gtl = new JLabel("Loại sản phẩm: ");
	loaisp = new JComboBox(gt);
	JPanel lsp = new JPanel();
	lsp.add(gtl);
	lsp.add(loaisp);
	
	JPanel lef = new JPanel();
	lef.add(mahd);
	lef.add(manv);
	lef.add(makh);
	lef.add(makm);
	lef.add(ns);
		
	center.add(lef);
	center.add(lsp);
	lef.add(tongtien);
	JButton them = new ButtonAdd();
	//lấy ngày sinh
/*
	them.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent me) {
			//đơn hàng
			int day = date.getModel().getDay();
			int month = date.getModel().getMonth();
			int year = date.getModel().getYear();
			JOptionPane.showMessageDialog(panel, day+"-"+month+"-"+year);
		}
	});
	*/
	JButton sua = new ButtonChange();
	JButton xoa = new ButtonRemove();
	JPanel right = new JPanel();
	right.setLayout(new FlowLayout());
	right.add(them);
	right.add(sua);
	right.add(xoa);
	center.add(right);
	
	ns.add(date);
	add(center);
	add(tim);
	return panel;
}
//hàm ngày sinh
private JDatePickerImpl cender() {
	
	UtilDateModel model = new UtilDateModel();
	JDatePanelImpl datePanel = new JDatePanelImpl(model);
	JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	datePicker.setBorder(BorderFactory.createTitledBorder(border,"Ngày sinh"));
	
	
	return datePicker;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		JPanel p= new HoaDonGUI();
		
		f.add(p);
		f.pack();
		f.setVisible(true);
	}

}
