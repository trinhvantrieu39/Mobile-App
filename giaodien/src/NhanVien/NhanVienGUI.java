package NhanVien;
import java.awt.TextField;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import Button.*;

public class NhanVienGUI extends JPanel{
	private BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
	private JTable nhanvienTable = new JTable();
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane sp ;
	private JPanel info;
	private JPanel bot;
	private Border border= BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	
public NhanVienGUI(){
	setLayout(layout);
	nhanvienTable.setModel(model);
	model.addColumn("Mã NV");
	model.addColumn("Tên NV");
	model.addColumn("Ngày sinh");
	model.addColumn("Giới tính");
	model.addColumn("Địa chỉ");
	model.addColumn("Số điện thoại");
}
private JPanel CreateInfo() {
	JPanel panel = new JPanel();
	
	JButton them = new ButtonAdd();
	JButton sua = new ButtonChange();
	JButton xoa = new ButtonRemove();
	panel.add(them);
	panel.add(sua);
	panel.add(xoa);
	JPanel  tim= new JPanel();
	JTextField timkiem = new JTextField(20);
	timkiem.setBorder(BorderFactory.createTitledBorder(border,"Tìm kiếm"));
	tim.add(timkiem);
	add(tim);
	return panel;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
