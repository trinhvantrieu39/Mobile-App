package TaiKhoan;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import Button.*;
import NhanVien.DateLabelFormatter;
import net.sourceforge.jdatepicker.impl.*;

public class TaiKhoanGUI extends JPanel{
	private BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
	private JTable taikhoanTable = new JTable();
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane sp ;
	
	private Border border= BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	
	private JTextField tentk = new JTextField(15);
	private JTextField matkhau = new JTextField(15);
	
	private JComboBox maquyen;
	private JTextField manv = new JTextField(15);
	
	
public TaiKhoanGUI(){
	setLayout(layout);
	
	JPanel panel = CreateInfo();
	taikhoanTable.setModel(model);
	model.addColumn("Tên tài khoản");
	model.addColumn("Mật khẩu");
	model.addColumn("Mã NV");
	model.addColumn("Mã quyền");
	
	sp = new JScrollPane(taikhoanTable);
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
	tentk.setBorder(BorderFactory.createTitledBorder(border,"Mã hóa đơn"));
	 
	matkhau.setBorder(BorderFactory.createTitledBorder(border, "Mã khách hàng"));
	//lấy loại sản phẩm ở database vào
	String quyenlist[] = {"quyền 1", "quyền 2"};
	JLabel quyenlb = new JLabel("Loại sản phẩm: ");
	maquyen = new JComboBox(quyenlist);
	JPanel mqpanel = new JPanel();
	mqpanel.add(quyenlb);
	mqpanel.add(maquyen);
	
	JPanel lef = new JPanel();
	lef.add(tentk);
	lef.add(matkhau);
	lef.add(manv);
			
	center.add(lef);
	center.add(mqpanel);
	
	JButton them = new ButtonAdd();
	
	
	JButton sua = new ButtonChange();
	JButton xoa = new ButtonRemove();
	JPanel right = new JPanel();
	right.setLayout(new FlowLayout());
	right.add(them);
	right.add(sua);
	right.add(xoa);
	center.add(right);
	
	add(center);
	add(tim);
	return panel;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		JPanel p= new TaiKhoanGUI();
		
		f.add(p);
		f.pack();
		f.setVisible(true);
	}

}
