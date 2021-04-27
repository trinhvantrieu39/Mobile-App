package NhanVien;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import Button.*;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.*;

public class NhanVienGUI extends JPanel{
	private BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
	private JTable nhanvienTable = new JTable();
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane sp ;
	private JPanel info;
	private JPanel bot;
	private Border border= BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	
	private JTextField manv = new JTextField(15);
	private JTextField tennv = new JTextField(15);
	private JTextField ngaysinh = new JTextField(15);
	private JComboBox gioitinh = new JComboBox();
	private JTextField diachi = new JTextField(15);
	private JTextField sdt = new JTextField(15);
	private JDatePicker date;
	
	
public NhanVienGUI(){
	setLayout(layout);
	
	JPanel panel = CreateInfo();
	nhanvienTable.setModel(model);
	model.addColumn("Mã NV");
	model.addColumn("Tên NV");
	model.addColumn("Ngày sinh");
	model.addColumn("Giới tính");
	model.addColumn("Địa chỉ");
	model.addColumn("Số điện thoại");
	
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
	
	manv.setBorder(BorderFactory.createTitledBorder(border,"Mã nhân viên"));
	tennv.setBorder(BorderFactory.createTitledBorder(border,"Tên nhân viên"));
	
	JPanel ns = new JPanel();
	ngaysinh.setBorder(BorderFactory.createTitledBorder(border,"Ngày sinh"));
	ngaysinh.setEditable(false);
	JDatePickerImpl date = cender();
	 
	diachi.setBorder(BorderFactory.createTitledBorder(border, "Địa chỉ"));
	sdt.setBorder(BorderFactory.createTitledBorder(border, "Số điện thoại"));
	
	String gt[] = {"Nam", "Nữ"};
	JLabel gtl = new JLabel("Giới tính: ");
	gioitinh = new JComboBox(gt);
	JPanel gtinh = new JPanel();
	gtinh.add(gtl);
	gtinh.add(gioitinh);
	JPanel lef = new JPanel();
	lef.add(manv);
	lef.add(tennv);
	lef.add(ns);
	lef.add(diachi);
	lef.add(sdt);
	
	
	
	
	center.add(lef);
	center.add(gtinh);
	JButton them = new ButtonAdd();
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
		JPanel p= new NhanVienGUI();
		
		f.add(p);
		f.pack();
		f.setVisible(true);
	}

}
