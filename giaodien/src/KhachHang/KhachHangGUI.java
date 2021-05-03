package KhachHang;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import Button.*;
import java.awt.event.*;


public class KhachHangGUI extends JPanel implements ActionListener {
    private JTextField txt_MaKH, txt_TenKH, txt_NgaySinh, txt_DiaCHi, txt_SDT, txt_TimKiem;
    private JLabel lb_tieude, lb_MAKH, lb_TenKH, lb_NgaySinh, lb_DiaCHi, lb_SDT, lb_TimKiem;
    private JTable khach_hang_table;
    private JButton bt_add, bt_Sua, bt_Xoa, bt_TimKiem;
    private JScrollPane scrollPane;
    private DefaultTableModel model = new DefaultTableModel();

    public KhachHangGUI() {

        setLayout(null);

       setBackground(new Color(240, 230, 140));


        lb_MAKH = new JLabel("Mã Khách Hàng :");
        lb_MAKH.setBounds(70, 78, 150, 50);
        lb_MAKH.setHorizontalAlignment(SwingConstants.RIGHT);
        lb_MAKH.setFont(new Font("tohoma", Font.BOLD, 16));
        add(lb_MAKH);

        lb_TenKH = new JLabel("Tên Khách Hàng :");
        lb_TenKH.setFont(new Font("tohoma", Font.BOLD, 16));
        lb_TenKH.setHorizontalAlignment(SwingConstants.RIGHT);
        lb_TenKH.setBounds(495, 78, 150, 50);
        add(lb_TenKH);

        lb_NgaySinh = new JLabel("Ngày Sinh :");
        lb_NgaySinh.setFont(new Font("tohoma", Font.BOLD, 16));
        lb_NgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
        lb_NgaySinh.setBounds(70, 143, 150, 50);
        add(lb_NgaySinh);

        lb_DiaCHi = new JLabel("Địa Chỉ :");
        lb_DiaCHi.setHorizontalAlignment(SwingConstants.RIGHT);
        lb_DiaCHi.setBounds(495, 143, 150, 50);
        lb_DiaCHi.setFont(new Font("tohoma", Font.BOLD, 16));
        add(lb_DiaCHi);

        lb_SDT = new JLabel("Số Điện Thoại :");
        lb_SDT.setFont(new Font("tohoma", Font.BOLD, 16));
        lb_SDT.setHorizontalAlignment(SwingConstants.RIGHT);
        lb_SDT.setBounds(495, 200, 150, 50);
        add(lb_SDT);

        lb_TimKiem = new JLabel("Tìm Kiếm :");
        lb_TimKiem.setHorizontalAlignment(SwingConstants.RIGHT);
        lb_TimKiem.setFont(new Font("tohoma", Font.BOLD, 16));
        lb_TimKiem.setBounds(0, 272, 150, 50);
        add(lb_TimKiem);


        txt_MaKH = new JTextField();
        txt_MaKH.setBounds(235, 86, 220, 40);
        txt_MaKH.setBorder(null);
        txt_MaKH.setFont(new Font("tohoma", Font.BOLD, 16));
        txt_MaKH.setColumns(12);
        add(txt_MaKH);


        txt_TenKH = new JTextField();
        txt_TenKH.setBounds(657, 86, 220, 40);
        txt_TenKH.setFont(new Font("tohoma", Font.BOLD, 16));
        txt_TenKH.setBorder(null);
        txt_TenKH.setColumns(12);
        add(txt_TenKH);

        txt_NgaySinh = new JTextField();
        txt_NgaySinh.setBounds(235, 148, 220, 40);
        txt_NgaySinh.setFont(new Font("tohoma", Font.BOLD, 16));
        txt_NgaySinh.setBorder(null);
        txt_NgaySinh.setColumns(12);
        add(txt_NgaySinh);

        txt_DiaCHi = new JTextField();
        txt_DiaCHi.setBounds(657, 148, 220, 40);
        txt_DiaCHi.setFont(new Font("tohoma", Font.BOLD, 16));
        txt_DiaCHi.setBorder(null);
        txt_DiaCHi.setColumns(12);
        add(txt_DiaCHi);


        txt_SDT = new JTextField();
        txt_SDT.setBounds(657, 208, 220, 40);
        txt_SDT.setFont(new Font("tohoma", Font.BOLD, 16));
        txt_SDT.setBorder(null);
        txt_SDT.setColumns(12);
        add(txt_SDT);

        txt_TimKiem = new JTextField();
        txt_TimKiem.setBounds(160, 278, 350, 40);
        txt_TimKiem.setFont(new Font("tohoma", Font.BOLD, 16));
        txt_TimKiem.setBorder(null);
        txt_TimKiem.setColumns(12);
        add(txt_TimKiem);

        bt_add = new ButtonAdd();
        bt_add.setFont(new Font("tohoma", Font.BOLD, 16));
        bt_add.setBorder(null);
        bt_add.setForeground(new Color(255, 255, 255));
        bt_add.setBackground(new Color(255, 0, 0));
        bt_add.setBounds(949, 88, 100, 40);
        add(bt_add);


        bt_Sua = new ButtonChange();
        bt_Sua.setFont(new Font("tohoma", Font.BOLD, 14));
        bt_Sua.setBorder(null);
        bt_Sua.setForeground(new Color(255, 255, 255));
        bt_Sua.setBackground(new Color(255, 0, 0));
        bt_Sua.setBounds(949, 154, 100, 40);
        add(bt_Sua);


        bt_Xoa = new ButtonRemove();
        bt_Xoa.setFont(new Font("tohoma", Font.BOLD, 14));
        bt_Xoa.setBorder(null);
        bt_Xoa.setForeground(new Color(255, 255, 255));
        bt_Xoa.setBackground(new Color(255, 0, 0));
        bt_Xoa.setBounds(949, 214, 100, 40);
        add(bt_Xoa);

        bt_add.addActionListener(this);
        bt_Sua.addActionListener(this);
        bt_Xoa.addActionListener(this);
        txt_TimKiem.addActionListener(this);

        khach_hang_table=new JTable();
        khach_hang_table.setModel(model);
        khach_hang_table.setBackground(Color.WHITE);
        scrollPane=new JScrollPane(khach_hang_table);
        model.addColumn("Mã Khách Hàng");
        model.addColumn("Tên Khách Hàng");
        model.addColumn("Ngày Sinh");
        model.addColumn("Địa Chỉ");
        model.addColumn("Số Điện Thoại");


       // model.addRow( (new Object[]{"traicây01","ngo khang","08/9/2001","adsasđ","0563535355"}));
        scrollPane.setBounds(0,350,1095,400);
        scrollPane.setViewportView(khach_hang_table);
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBounds(1075, 352, 17, 260);

        this.add(scrollBar);
        setLayout(null);
        this.add(scrollPane);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

