package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;


public class NhanvienGUI extends javax.swing.JFrame {
    DefaultTableModel model;
    JTable tblDSNV;
    JTextField txtMaNV, txtHoten, txtNgaysinh, txtDiachi, txtSDT, txtTim;
    JLabel ltitle, lMa, lHoten, lNgaysinh, lDiachi, lSDT, lTim;
    JButton btnthem, btnsua, btnxoa, btntkiem;
    JScrollPane sptbl;
    JPanel pframe,pmenu,padd;
    private final int weight =1000;
    private final int height =750;

    Vector title = new Vector();
    
    public NhanvienFRM() {
        init();
    }

    private void btnThemActionPerformed(ActionEvent e) {
        NhanvienDTO nv = new NhanvienDTO();
        nv.MaNV = txtMaNV.getText();
        nv.TenNV = txtHoten.getText();
        nv.NgaySinh = txtNgaysinh.getText();
        nv.DiaChi = txtDiachi.getText();
        nv.SDT = txtSDT.getText();
        NhanvienBUS bus = new NhanvienBUS();
        bus.them(nv);
        Vector row = new Vector();
        row.add(nv.MaNV);
        row.add(nv.TenNV);
        row.add(nv.NgaySinh);
        row.add(nv.DiaChi);
        row.add(nv.SDT);
        model.addRow(row);
        tblDSNV.setModel(model);
    }

    private void btnSuaActionPerformed(ActionEvent e) {
        NhanvienDTO nv = new NhanvienDTO();
        NhanvienBUS bus = new NhanvienBUS();
        int i = tblDSNV.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(rootPane, "Xin vui lòng chọn dòng cần sửa!");
        } else {
            nv.MaNV = txtMaNV.getText();
            nv.TenNV = txtHoten.getText();
            nv.NgaySinh = txtNgaysinh.getText();
            nv.DiaChi = txtDiachi.getText();
            nv.SDT = txtSDT.getText();
            bus.sua(i, nv);
            model.setValueAt(nv.MaNV, i, 0);
            model.setValueAt(nv.TenNV, i, 1);
            model.setValueAt(nv.NgaySinh, i, 2);
            model.setValueAt(nv.DiaChi, i, 3);
            model.setValueAt(nv.SDT, i, 4);
            tblDSNV.setModel(model);
        }
    }

    private void btnXoaActionPerformed(ActionEvent e) {
        NhanvienDTO nv = new NhanvienDTO();
        NhanvienBUS bus = new NhanvienBUS();
        int i = tblDSNV.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn record cần xóa");
        } else {
            String id = tblDSNV.getModel().getValueAt(i, 0).toString();
            if (JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa dòng đã chọn có mã: " + id, "Lựa chọn", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                bus.xoa(i, id);
                model.removeRow(i);
                tblDSNV.setModel(model);
            }
        }
    }

    private void timkiemTheokytu(String s) {
        NhanvienBUS bus = new NhanvienBUS();
        ArrayList<NhanvienBUS> dsnv=new ArrayList<>();
        
    }

    private void selectedRow(MouseEvent e) {
        int i = tblDSNV.getSelectedRow();
        if (i != -1) {
            txtMaNV.setText(tblDSNV.getModel().getValueAt(i, 0).toString());
            txtHoten.setText(tblDSNV.getModel().getValueAt(i, 1).toString());
            txtNgaysinh.setText(tblDSNV.getModel().getValueAt(i, 2).toString());
            txtDiachi.setText(tblDSNV.getModel().getValueAt(i, 3).toString());
            txtSDT.setText(tblDSNV.getModel().getValueAt(i, 4).toString());

        }
    }
    private void btnThoatActionPerfomed(ActionEvent e)  {
            System.exit(0);
        }
    private void btnTatActionPerfomed(ActionEvent e){
             this.setState(JFrame.ICONIFIED);
    }

    void init() {
        JPanel pframe=new JPanel();
        pframe.setBackground(Color.BLUE);
        pframe.setLayout(null);
        
        pframe.setSize(weight,height);
        Icon icon=new ImageIcon("D:\\MônHọc\\JAVA\\Image\\button-add.png");
        setSize(weight, height);
        this.setLocationRelativeTo(this);
        getRootPane().setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.BLACK));
        pmenu = new JPanel();
        pmenu.setLayout(null);
        pmenu.setBounds(0, 0, 1000, 40);
        
        padd=new JPanel();
        padd.setBounds(20,50,750,200);
        
        ltitle = new JLabel("Quản Lý Nhân Viên");
        ltitle.setFont(new Font("Calibri", Font.BOLD, 24));
        ltitle.setBounds(400,1, 200, 50);
        
        lMa = new JLabel("Mã Nhân Viên:");
        lMa.setFont(new Font("Calibri", Font.BOLD, 20));
        lMa.setBounds(10, 20, 150, 40);

        lHoten = new JLabel("Họ Tên: ");
        lHoten.setFont(new Font("Calibri", Font.BOLD, 20));
        lHoten.setBounds(10, 70, 150, 40);

        lNgaysinh = new JLabel("Ngày Sinh:");
        lNgaysinh.setFont(new Font("Calibri", Font.BOLD, 20));
        lNgaysinh.setBounds(10, 120, 150, 40);

        lDiachi = new JLabel("Địa Chỉ");
        lDiachi.setFont(new Font("Calibri", Font.BOLD, 20));
        lDiachi.setBounds(400, 60, 150, 40);

        lSDT = new JLabel("SDT");
        lSDT.setFont(new Font("Calibri", Font.BOLD, 20));
        lSDT.setBounds(400, 20, 150, 40);
        
        lTim=new JLabel("Tìm kiếm");
        lTim.setFont(new Font("Calibri", Font.BOLD, 20));
        lTim.setBounds(30,270,150,65);
        
        txtMaNV = new JTextField();
        txtMaNV.setBounds(145, 20, 200, 40);

        txtHoten = new JTextField();
        txtHoten.setBounds(145, 70, 200, 40);

        txtNgaysinh = new JTextField();
        txtNgaysinh.setBounds(145, 120, 200, 40);
        
        txtDiachi = new JTextField();
        txtDiachi.setBounds(505, 70, 200, 40);
        
        txtTim=new JTextField();
        txtTim.setBounds(205,270,200,50);
        
        txtSDT = new JTextField();
        txtSDT.setBounds(505, 20, 200, 40);
        
        btnthem = new JButton("Thêm");
        btnthem.setFont(new Font("Calibri", Font.BOLD, 20));
        btnthem.setBounds(800, 50, 100, 40);

        btnsua = new JButton("Sửa");
        btnsua.setFont(new Font("Calibri", Font.BOLD, 20));
        btnsua.setBounds(800, 100, 100, 40);

        btnxoa = new JButton("Xóa");
        btnxoa.setFont(new Font("Calibri", Font.BOLD, 20));
        btnxoa.setBounds(800, 150, 100, 40);

        btntkiem = new JButton("Tìm");
        btntkiem.setFont(new Font("Calibri", Font.BOLD, 20));
        btntkiem.setBounds(800, 200, 100, 40);

        //Thêm label,textfield vào panel và frame
        pmenu.add(ltitle);   
        pmenu.setBackground(Color.LIGHT_GRAY);
        padd.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        
        padd.add(lMa);
        padd.add(lHoten);
        padd.add(lNgaysinh);
        padd.add(lDiachi);
        padd.add(lSDT);
        
        padd.add(txtMaNV);
        padd.add(txtHoten);
        padd.add(txtNgaysinh);
        padd.add(txtDiachi);
        padd.add(txtSDT);
        padd.setLayout(new BorderLayout());
 
        pframe.add(padd);
        pframe.add(pmenu);
        pframe.add(lTim);
        pframe.add(txtTim);
        pframe.add(btnthem);
        pframe.add(btnsua);
        pframe.add(btnxoa);
        pframe.add(btntkiem);
        this.add(pframe);
        NhanvienBUS bus = new NhanvienBUS();
        tblDSNV = new JTable();
        sptbl = new JScrollPane();
        title.add("Mã Nhân Viên");
        title.add("Họ Tên");
        title.add("Ngày Sinh");
        title.add("Địa Chỉ");
        title.add("SĐT");
        bus.docDSNV();
        model = new DefaultTableModel(title, 0);
        for (NhanvienDTO nv : NhanvienBUS.dsnv) {
            Vector row = new Vector();
            row.add(nv.MaNV);
            row.add(nv.TenNV);
            row.add(nv.NgaySinh);
            row.add(nv.DiaChi);
            row.add(nv.SDT);
            model.addRow(row);
        }
        tblDSNV.setModel(model);
        sptbl.setBounds(0, 350, 1000, 400);
        sptbl.setViewportView(tblDSNV);
        pframe.add(sptbl);
        setLayout(null);
       
        btnthem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txtMaNV.getText().trim().equals("") || txtHoten.getText().trim().equals("") || 
                   txtNgaysinh.getText().trim().equals("") || txtDiachi.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Vui Lòng điền thongtin");
                }
            else{btnThemActionPerformed(e);}
                
            }
        });
        btnsua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSuaActionPerformed(e);
            }
        });
        btnxoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnXoaActionPerformed(e);
            }
        });
        btntkiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        txtTim.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent e) {
                warn();
            }
            public void insertUpdate(DocumentEvent e) {
                warn();
            }
            public void removeUpdate(DocumentEvent e) {
                warn();
            }
            public void warn(){
                timkiemTheokytu(txtTim.getText());
            }
            
        });
        tblDSNV.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                selectedRow(e);
            }
        });
    }
}
