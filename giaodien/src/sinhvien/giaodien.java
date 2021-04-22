package sinhvien;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
public class giaodien {
	private JTextField tx1, tx2, tx3, tx4, tx5, tx6;
	private JLabel lb1, masv, hoten, malop, diemlt, diemth, diemtb, ketqua;
	private JComboBox cb;
	private String combo[] = { "NCTH6A", "NCTH6B", "NCTH7A", 
	"NCTH7B"};
	private String soN="[1-9][\\d]*";
	private JButton btketqua, btthem, btclear, btluu, btxoa, btsua, bttim;
	private DefaultTableModel model;
	private JTable table;
	private JFrame f;
	private DanhSachSinhVien dssv;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new giaodien();
	}
	giaodien(){
		//danh sach
		dssv =new DanhSachSinhVien();
		 f = new JFrame();
		 model = new DefaultTableModel(); 
		 table = new JTable();
		
		/*left*/
		lb1 = new JLabel("THÔNG TIN SINH VIÊN");
		masv = new JLabel("Mã sinh viên ");
		hoten = new JLabel ("Họ và tên");
		malop = new JLabel("Mã lớp");
		diemlt= new JLabel ("Điểm lý thuyết");
		diemth= new JLabel ("Điểm thực hành");
		diemtb= new JLabel ("Điểm trung bình");
		ketqua =  new JLabel("Kết quả");
		tx1 = new JTextField(20);
		tx2 = new JTextField(20);
		tx3 = new JTextField(20);
		tx4 = new JTextField(20);
		tx5 = new JTextField(20);
		tx5.setEditable(false);
		tx6 = new JTextField(20);
		tx6.setEditable(false);
		//combobox
		cb = new JComboBox(combo);
		JPanel left = new JPanel();
		
		left.setLayout(new BoxLayout(left,BoxLayout.Y_AXIS));
		
			
		left.add(lb1);
		left.add(masv);			
		left.add(tx1);			
		left.add(hoten);			
		left.add(tx2);				
		left.add(malop);			
		left.add(cb);			
		left.add(diemlt);			
		left.add(tx3);			
		left.add(diemth);			
		left.add(tx4);			
		left.add(diemtb);			
		left.add(tx5);			
		left.add(ketqua);			
		left.add(tx6);
		
		
		//button
		btketqua = new JButton("Kết quả");
		btthem = new JButton("Thêm");
		btclear = new JButton("Clear");
		btluu = new JButton("Lưu");
		btxoa = new JButton("Xóa");
		btsua = new JButton ("Sửa");
		bttim = new JButton("Tìm");
		
		JPanel bt1 =  new JPanel();
		JPanel bt2 =  new JPanel();
		
		bt1.add(btketqua);
		bt1.add(btthem);
		bt1.add(btclear);
		bt2.add(btluu);
		bt2.add(btxoa);
		bt2.add(btsua);
		bt2.add(bttim);
		
		left.add(bt1);
		left.add(bt2);
		
		btketqua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				showketqua(evt);
			}
			
		});
		
		btthem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				them(evt);
			}
		});
		
		btclear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				clear(evt);
			}
		});
		
		btxoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				xoa(evt);
			}
		});
		btsua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				sua(evt);
			}
		});
		bttim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				tim(evt);
			}
		});
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent evt) {
				// TODO Auto-generated method stub
				click(evt);
			}
		});
		btluu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					ghifile(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		//end left
		//right
		 
		table.setModel(model);
		model.addColumn("Mã SV");
		model.addColumn("Họ tên");
		model.addColumn("Lớp");
		model.addColumn("Lý thuyết");
		model.addColumn("Thực hành");
		model.addColumn("Trung bình");
		model.addColumn("Kết quả");
		
		JScrollPane sp = new JScrollPane(table);
		JPanel right = new JPanel();
		right.add(sp);
		
		 try {
				docfile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		f.setLayout(new FlowLayout());
		f.add(left);
		f.add(right);
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public boolean soN(String s) {
		return Pattern.matches(soN, s);
	}
	private void showketqua(ActionEvent evt) {
		String masv=tx1.getText();
		String hoten = tx2.getText();
		String malop= (String) cb.getSelectedItem();
		String lt = tx3.getText();
		if(!soN(lt)) {
			JOptionPane.showMessageDialog(f,"Ô nhập điểm phải là số");
			return;
		}
		String th = tx4.getText();
		if(!soN(th)) {
			JOptionPane.showMessageDialog(f,"Ô nhập điểm phải là số");
			return;
		}
		SinhVien sv= new SinhVien(masv, hoten, malop, Double.parseDouble(lt), Double.parseDouble(th));
		tx5.setText(String.valueOf(sv.diemTB()));
		tx6.setText(String.valueOf(sv.ketqua()));
		
	}
	private void them(ActionEvent evt) {
		String masv=tx1.getText();
		String hoten = tx2.getText();
		String malop= (String) cb.getSelectedItem();
		String lt = tx3.getText();
		String th = tx4.getText();
		if(masv.equals("")) {
			JOptionPane.showMessageDialog(f, "Chưa điền mã sinh viên!!!");
			return;
		}
		if(hoten.equals("")) {
			JOptionPane.showMessageDialog(f, "Chưa điền họ tên!!!");
			return ;
		}
		if(lt.equals("")) {
			JOptionPane.showMessageDialog(f, "Chưa điền điểm lý thuyết!!!");
			return ;
		}
		if(th.equals("")) {
			JOptionPane.showMessageDialog(f, "Chưa điền điểm thực hành!!!");
			return;
		}
		if(!soN(lt)) {
			JOptionPane.showMessageDialog(f, "Điểm không phải là số!!!");
			return;
		}
		if(!soN(th)) {
			JOptionPane.showMessageDialog(f, "Điểm không phải là số!!!");
			return;
		}
		SinhVien sv= new SinhVien(masv, hoten, malop, Double.parseDouble(lt), Double.parseDouble(th));
		String tb = String.valueOf(sv.diemTB());
		String kq = String.valueOf(sv.ketqua());
		
		if(!dssv.themSinhVien(sv)) {
			JOptionPane.showMessageDialog(f, "Trùng mã sinh viên!!!");
			return;
		}else {
			
			model.addRow(new Object[] {masv, hoten, malop, lt, th, tb, kq});
		}
		//dssv.print();
		/*
		int row =model.getRowCount();
		for(int i=row-1;i>=0;i--) {
			System.out.println(model.getValueAt(i, 0));
		}
		*/

	}
	
	
	private void clear(ActionEvent evt) {
		tx1.setText("");
		tx2.setText("");
		tx3.setText("");
		tx4.setText("");
		tx5.setText("");
		tx6.setText("");
		cb.setSelectedItem("NCTH6A");
	}
	
	private void xoa(ActionEvent evt) {
		/*	xoa sv theo mssv nhap trong textfield
		String masv = tx1.getText();
		if(dssv.xoaSinhVien(masv)) {
			int row =model.getRowCount();
			for(int i=row-1;i>=0;i--) {
				if(model.getValueAt(i, 0).equals(masv))
					model.removeRow(i);
			}
		}
		//dssv.print();
		 */
		//xoa  sv nhap vao dialog
		String masv = JOptionPane.showInputDialog("Nhập mã sinh viên cần xóa");
		boolean check = false;	//checck masv có tìm thấy k
		for(int i=0;i<model.getRowCount();i++) {
			if(model.getValueAt(i, 0).equals(masv))
				check =true;
		}
		if(check) {
			if(JOptionPane.showConfirmDialog(f, "Bạn chắc chắn muốn xóa?")==0) {
				if(dssv.xoaSinhVien(masv)) {
					int row =model.getRowCount();
					for(int i=row-1;i>=0;i--) {
						if(model.getValueAt(i, 0).equals(masv))
							model.removeRow(i);
					}
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(f,"Không có mã sinh viên muốn xóa!!!");
		}
		
	}
	private void sua(ActionEvent evt) {
		String masv = tx1.getText();
		String hoten = tx2.getText();
		String malop= (String) cb.getSelectedItem();
		String lt = tx3.getText();
		String th = tx4.getText();
		String tb = String.valueOf((Double.parseDouble(lt)+Double.parseDouble(th))/2);
		String kq = Double.parseDouble(tb)>=5 ? "Đậu":"Rớt";
		int i = table.getSelectedRow();
		//xoa trong vector
		SinhVien sv= new SinhVien(masv, hoten, malop, Double.parseDouble(lt), Double.parseDouble(th));
		dssv.suaSinhVien(masv, sv);
		if(i>=0) {
			model.setValueAt(hoten, i, 1);
			model.setValueAt(malop,i, 2);
			model.setValueAt(lt, i, 3);
			model.setValueAt(th, i, 4);
			model.setValueAt(tb, i, 5);
			model.setValueAt(kq,i,6);
		}
	}
	private void tim(ActionEvent evt) {
		String masv = JOptionPane.showInputDialog("Nhập mã sinh viên cần tìm kiếm");
		for(int i=0;i<model.getRowCount();i++) {
			if(model.getValueAt(i, 0).equals(masv)) {
				tx1.setText((String) model.getValueAt(i, 0));
				tx2.setText((String)model.getValueAt(i, 1));
				cb.setSelectedItem(model.getValueAt(i, 2));
				tx3.setText((String)model.getValueAt(i, 3));
				tx4.setText((String)model.getValueAt(i, 4));
				tx5.setText((String)model.getValueAt(i, 5));
				tx6.setText((String)model.getValueAt(i, 6));
			}
		}
	}
	
	private void click(ListSelectionEvent evt) {
		int i = table.getSelectedRow();
		tx1.setText((String) model.getValueAt(i, 0));
		tx2.setText((String)model.getValueAt(i, 1));
		cb.setSelectedItem(model.getValueAt(i, 2));
		tx3.setText((String)model.getValueAt(i, 3));
		tx4.setText((String)model.getValueAt(i, 4));
		tx5.setText((String)model.getValueAt(i, 5));
		tx6.setText((String)model.getValueAt(i, 6));
	}
	private void ghifile(ActionEvent evt) throws IOException {
		File FILE = new File("DanhSachSV.txt");
		FILE.delete();
		FILE.createNewFile();
		try {
			FileOutputStream file = new FileOutputStream("DanhSachSV.txt");
			DataOutputStream data = new DataOutputStream(file);
			String n = String.valueOf(table.getRowCount());
			data.writeUTF(n);
			for(int i=0; i< model.getRowCount();i++)
			{
				data.writeUTF((String) model.getValueAt(i, 0));
				data.writeUTF((String) model.getValueAt(i, 1));
				data.writeUTF((String) model.getValueAt(i, 2));
				data.writeUTF((String) model.getValueAt(i, 3));
				data.writeUTF((String) model.getValueAt(i, 4));
				data.writeUTF((String) model.getValueAt(i, 5));
				data.writeUTF((String) model.getValueAt(i, 6));
				
			}
			JOptionPane.showMessageDialog(f, "Đã lưu!!!");
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}
	private void docfile() throws IOException{
		FileInputStream file = null;
		DataInputStream data = null;
		try {
			file = new FileInputStream("DanhSachSV.txt");
			data = new DataInputStream(file);
			int soluong = Integer.parseInt(data.readUTF());
			for(int i=0 ; i<soluong ;i++) {
				String masv =  data.readUTF();
				String hoten = data.readUTF();
				String malop = data.readUTF();
				String lt = data.readUTF();
				String th = data.readUTF();
				String tb = data.readUTF();
				String kq = data.readUTF();
				
				model.addRow(new Object[] {masv, hoten, malop, lt, th, tb, kq});
			}
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
}
