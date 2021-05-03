package NhaCungCap;

import Button.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
public class NhaCungCapGUI extends JPanel {
    DefaultTableModel model=new DefaultTableModel();
    JTable nhacungcapTable;
    JScrollPane sp;
    JTextField txtMaNCC, txtTenNCC, txtDiachiNCC,txtSdtNCC,txtTimKiem;
    JLabel ltitle, lMaNCC, lTenNCC, lDiachiNCC, lSdtNCC,lTimKiem;
    JButton btnThemNCC,btnSuaNCC,btnXoaNCC,btnTimNCC;
    JPanel panelframe,panelmenu,paneladd;
    private final int height = 760;
    private final int weight = 1115;
    public NhaCungCapGUI(){
        panelframe=new JPanel();
        panelframe.setLayout(null);
        panelframe.setBackground(new Color(240, 230, 140));
        panelframe.setSize(weight,height);
        setSize(weight,height);
        setLocationRelativeTo(this);
        panelmenu=new JPanel();
        panelmenu.setLayout(null);
        panelmenu.setBackground(new Color(240, 230, 140));
        panelmenu.setBounds(0,0,1000,40);
        paneladd=new JPanel();
        paneladd.setBounds(20,50,900,200);
        paneladd.setBackground(new Color(240, 230, 140));
////        ltitle=new JLabel("Quản Lý Nhà Cung Cấp");
////        ltitle.setFont(new Font("Calibri",1,20));
//        ltitle.setBounds(400,1,200,50);
        lMaNCC=new JLabel("Mã Nhà Cung Cấp :");
        lMaNCC.setFont(new Font("Calibri",1,16));
        lMaNCC.setBounds(60,40,150,40);
        lMaNCC.setHorizontalAlignment(SwingConstants.RIGHT);
        lTenNCC=new JLabel("Tên Nhà Cung Cấp :");
        lTenNCC.setFont(new Font("Calibri",1,16));
        lTenNCC.setBounds(57,125,150,50);
        lTenNCC.setHorizontalAlignment(SwingConstants.RIGHT);
        lDiachiNCC=new JLabel("Địa Chỉ :");
        lDiachiNCC.setFont(new Font("Calibri",1,16));
        lDiachiNCC.setBounds(563,125,150,50);
        lSdtNCC=new JLabel("Số Điện Thoại :");
        lSdtNCC.setFont(new Font("Calibri",1,16));
        lSdtNCC.setBounds(470,38,150,50);
        lSdtNCC.setHorizontalAlignment(SwingConstants.RIGHT);

        lTimKiem=new JLabel("Tìm Kiếm :");
        lTimKiem.setFont(new Font("Calibri",1,16));
        lTimKiem.setBounds(10,290,150,50);
        lTimKiem.setHorizontalAlignment(SwingConstants.RIGHT);

        txtMaNCC=new JTextField();
        txtMaNCC.setBounds(235, 40, 220, 40);
        txtTenNCC=new JTextField();
        txtTenNCC.setBounds(235, 130, 220, 40);
        txtDiachiNCC=new JTextField();
        txtDiachiNCC.setBounds(640, 130, 220, 40);
        txtSdtNCC=new JTextField();
        txtSdtNCC.setBounds(640, 40, 220, 40);
        txtSdtNCC.setBorder(null);
        txtDiachiNCC.setBorder(null);
        txtDiachiNCC.setBorder(null);
        txtMaNCC.setBorder(null);
        txtTenNCC.setBorder(null);

        txtTimKiem=new JTextField();
        txtTimKiem.setBounds(180, 290, 330, 40);
        txtTimKiem.setBorder(null);
        //
        btnThemNCC=new ButtonAdd();
        btnThemNCC.setFont(new Font("Calibri",1,16));
        btnThemNCC.setBounds(949, 88, 120, 40);
        //
        btnSuaNCC=new ButtonChange();
        btnSuaNCC.setFont(new Font("Calibri",1,16));
        btnSuaNCC.setBounds(949, 154, 120, 40);
        //
        btnXoaNCC=new ButtonRemove();
        btnXoaNCC.setFont(new Font("Calibri",1,16));
        btnXoaNCC.setBounds(949, 214, 120, 40);
        //
//        btnTimNCC=new JButton("Tìm ");
//        btnTimNCC.setFont(new Font("Calibri",1,18));
//        btnTimNCC.setBounds(800,200,100,40);
        //
       panelframe.add(lTimKiem);
       panelframe.add(txtTimKiem);
        paneladd.add(lMaNCC);
        paneladd.add(lTenNCC);
        paneladd.add(lDiachiNCC);
        paneladd.add(lSdtNCC);
        //
        paneladd.add(txtMaNCC);
        paneladd.add(txtTenNCC);
        paneladd.add(txtDiachiNCC);
        paneladd.add(txtSdtNCC);
        //
        paneladd.setLayout(new BorderLayout());
        panelframe.add(paneladd);
        panelframe.add(panelmenu);
        //
        panelframe.add(btnThemNCC);
        panelframe.add(btnSuaNCC);
        panelframe.add(btnXoaNCC);
//        panelframe.add(btnTimNCC);
        //
        this.add(panelframe);
        //
        nhacungcapTable=new JTable();
        nhacungcapTable.setModel(model);
        nhacungcapTable.setBackground(Color.WHITE);
        sp=new JScrollPane(nhacungcapTable);
        model.addColumn("Mã Nhà Cung Cấp");
        model.addColumn("Tên Nhà Cung Cấp");
        model.addColumn("Địa Chỉ");
        model.addColumn("SĐT");

        sp.setBounds(0,350,1095,400);
        sp.setViewportView(nhacungcapTable);
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBounds(1075, 352, 17, 260);

        panelframe.add(scrollBar);
        setLayout(null);
        panelframe.add(sp);

        //

    }
    private void setLocationRelativeTo(NhaCungCapGUI nhaCungCapGUI) {
    }

}