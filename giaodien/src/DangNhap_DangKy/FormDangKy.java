package DangNhap_DangKy;

import keeptoo.KGradientPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.Timer;
import java.util.regex.*;


public class FormDangKy extends JFrame implements ActionListener {
    private KGradientPanel panel;
    private JLabel lb_tiede,lb_Tentaikhoan,lb_Matkhau,lb_Nhaplaimk,lb_MaNV,lb_MaQuyen,lb_checkTentaikhoan,lb_checkPass,lb_checkRe_Pass,lb_checkMaNV,lb_checkMaQuyen;
    private JTextField txt_tentaikhoan,txt_MaNV;
    private JPasswordField txt_Password,txt_RePassword;
    private JButton bt_Dangky;
    private  JComboBox comboBox;

     FormDangKy(){

        panel=new KGradientPanel();
        panel.setBorder(new EmptyBorder(10,10,10,10)); //EmptyBorder tạo đường viền ẩn
        panel.kStartColor=new Color(63,94,251);
        panel.kEndColor=new Color(252,70,107);
        panel.setLayout(null);


        lb_tiede=new JLabel("Tạo Tài Khoản");
        lb_tiede.setFont(new Font("Arial",Font.BOLD,30));// set font kiểu Arial, Làm đậm chữ, set size chữ=30
        lb_tiede.setHorizontalAlignment(SwingConstants.CENTER);
        lb_tiede.setBounds(230,37,220,31);
        lb_tiede.setForeground(Color.WHITE);
        panel.add(lb_tiede);

        lb_Tentaikhoan=new JLabel("Tên tài khoản :");
        lb_Tentaikhoan.setBounds(39, 117, 113, 23);
        lb_Tentaikhoan.setHorizontalAlignment(SwingConstants.RIGHT);
        lb_Tentaikhoan.setFont(new Font("Arial",Font.BOLD,15));
        lb_Tentaikhoan.setForeground(Color.WHITE);
        lb_Tentaikhoan.setBounds(45,117,113,23);

        panel.add(lb_Tentaikhoan);


        lb_Matkhau=new JLabel("Mật khẩu :");
        lb_Matkhau.setBounds(39, 177, 113, 14);
        lb_Matkhau.setHorizontalAlignment(SwingConstants.RIGHT);
        lb_Matkhau.setFont(new Font("Arial",Font.BOLD,15));
        lb_Matkhau.setForeground(Color.WHITE);
        panel.add(lb_Matkhau);


        lb_Nhaplaimk=new JLabel("Re-mật khẩu :");
        lb_Nhaplaimk.setBounds(10, 227, 142, 23);
        lb_Nhaplaimk.setHorizontalAlignment(SwingConstants.RIGHT);
        lb_Nhaplaimk.setFont(new Font("Arial",Font.BOLD,15));
        lb_Nhaplaimk.setForeground(Color.WHITE);
        panel.add(lb_Nhaplaimk);


        lb_MaNV=new JLabel("Mã nhân viên :");
        lb_MaNV.setBounds(10, 293, 142, 14);
        lb_MaNV.setHorizontalAlignment(SwingConstants.RIGHT);
        lb_MaNV.setFont(new Font("Arial",Font.BOLD,15));
        lb_MaNV.setForeground(Color.WHITE);
        panel.add(lb_MaNV);

        String[] Cb={"Chọn","QL","NV"};
        comboBox=new JComboBox(Cb);
        comboBox.setFont(new Font("Arial",Font.BOLD,15));
        comboBox.setBounds(190, 339, 131, 22);

        panel.add(comboBox);


        lb_MaQuyen=new JLabel("Mã Quyền:");
        lb_MaQuyen.setBounds(21, 343, 131, 18);
        lb_MaQuyen.setHorizontalAlignment(SwingConstants.RIGHT);
        lb_MaQuyen.setFont(new Font("Arial",Font.BOLD,15));
        lb_MaQuyen.setForeground(Color.WHITE);
        panel.add(lb_MaQuyen);

        txt_tentaikhoan=new JTextField();
        txt_tentaikhoan.setFont(new Font("Arial",Font.BOLD,14));
        txt_tentaikhoan.setBounds(190, 110, 395, 30);
        txt_tentaikhoan.setBorder(new EmptyBorder(5,5,5,5));
        panel.add(txt_tentaikhoan);

        txt_Password=new JPasswordField();
        txt_Password.setFont(new Font("Arial",Font.BOLD,14));
        txt_Password.setBounds(190, 170, 395, 31);
        txt_Password.setBorder(new EmptyBorder(5,5,5,5));
        panel.add(txt_Password);

        txt_RePassword=new JPasswordField();
        txt_RePassword.setFont(new Font("Arial",Font.BOLD,14));
        txt_RePassword.setBounds(190, 222, 395, 30);
        txt_RePassword.setBorder(new EmptyBorder(5,5,5,5));
        panel.add(txt_RePassword);

        txt_MaNV=new JTextField();
        txt_MaNV.setFont(new Font("Arial",Font.BOLD,12));
        txt_MaNV.setBounds(190, 286, 395, 31);
        txt_MaNV.setFont(new Font("Arial",Font.BOLD,14));
        txt_MaNV.setBorder(new EmptyBorder(5,5,5,5));
        panel.add(txt_MaNV);


        bt_Dangky=new JButton("Tạo");

        bt_Dangky.setFont(new Font("Arial",Font.BOLD,20));
        bt_Dangky.setBounds(258, 410, 125, 39);
        bt_Dangky.setBorder(new EmptyBorder(5,5,5,5));
        bt_Dangky.setBackground(new Color(220,20,60));
        bt_Dangky.setForeground(Color.WHITE);

        lb_checkMaQuyen=new JLabel();
        lb_checkMaQuyen.setBounds(330,343,180,17);
        panel.add(lb_checkMaQuyen);
        panel.add(bt_Dangky);

        txt_tentaikhoan.addActionListener(this);
        txt_Password.addActionListener(this);
        txt_RePassword.addActionListener(this);
        txt_MaNV.addActionListener(this);
        txt_MaNV.addActionListener(this);
        comboBox.addActionListener(this);
        bt_Dangky.addActionListener(this);



        setTitle("Tạo tài khoản");
        setContentPane(panel);
        setVisible(true);
        setBounds(380, 100, 650, 529);
        setResizable(false);
        try {
            setUndecorated(true);
        }catch(Exception e){
            System.out.println(e);
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }








    @Override
    public void actionPerformed(ActionEvent e) {
        Xu_lyDatabase xl=new Xu_lyDatabase();
        JTextField txt_Password1,txt_tentaikhoan1,txt_MaNV1,txt_RePassword1;
        String tentaikhoan=txt_tentaikhoan.getText();
        String matkhau=String.valueOf(txt_Password.getPassword());
        String Re_matkhau=String.valueOf(txt_RePassword.getPassword());
        String manv=txt_MaNV.getText();


        String MaQuyen=comboBox.getSelectedItem().toString();

        if (e.getSource()==bt_Dangky) {


            // Phần check tên tài khoản
            if (tentaikhoan.equals("")) {
                txt_tentaikhoan1=new JTextField();
                txt_tentaikhoan1.setText("* Không được bỏ trống");
                txt_tentaikhoan1.setBounds(250, 110, 321, 30);
                txt_tentaikhoan1.setHorizontalAlignment(SwingConstants.RIGHT);
                txt_tentaikhoan1.setFont(new Font("Arial",Font.BOLD,15));
                txt_tentaikhoan1.setBorder(new EmptyBorder(5,5,5,5));
                txt_tentaikhoan1.setForeground(Color.RED);
                panel.add(txt_tentaikhoan1);


                ActionListener taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        txt_tentaikhoan1.setVisible(false);

                    }
                };
                new Timer(7000, taskPerformer).start();


                return;
            }else{
                String formatten="[0-9a-zA-Z aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]{6,50}";

                if (xl.checkTenTaiKhoan(tentaikhoan)==false){
                    JOptionPane.showMessageDialog(null," Tài khoản đã tồn tại! \nVui lòng tạo tài khoản khác!");
                    return;
                }
                if(!Pattern.matches(formatten,tentaikhoan)){
                    // JOptionPane.showMessageDialog(null,"Tên phải đủ 6 kí tự, không chứa kí tự đắc biệt");
                    //return;
                    txt_tentaikhoan1=new JTextField();
                    txt_tentaikhoan1.setText("*Tên phải đủ 6 kí tự,không chứa kí tự đặc biệt");
                    txt_tentaikhoan1.setBounds(250, 110, 335, 30);
                    txt_tentaikhoan1.setHorizontalAlignment(SwingConstants.RIGHT);
                    txt_tentaikhoan1.setFont(new Font("Arial",Font.BOLD,15));
                    txt_tentaikhoan1.setBorder(new EmptyBorder(5,5,5,5));
                    txt_tentaikhoan1.setForeground(Color.RED);
                    panel.add(txt_tentaikhoan1);


                    ActionListener taskPerformer = new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            txt_tentaikhoan1.setVisible(false);

                        }
                    };
                    new Timer(7000, taskPerformer).start();


                    return;
                }
            }


            // Phần Check Mật khẩu

            if (matkhau.equals("")){
                txt_Password1=new JTextField();
                txt_Password1.setBounds(356, 170, 215, 31);
                txt_Password1.setFont(new Font("Arial",Font.BOLD,14));
                txt_Password1.setText("* Không được bỏ trống");
                txt_Password1.setBorder(new EmptyBorder(5,5,5,5));
                txt_Password1.setHorizontalAlignment(SwingConstants.RIGHT);
                txt_Password1.setForeground(Color.RED);
                panel.add(txt_Password1);


                txt_Password1.setForeground(Color.RED);
                ActionListener taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {

                        txt_Password1.setVisible(false);



                    }
                };
                new Timer(7000, taskPerformer).start();


                return;

            }
            else{
                if (matkhau.length()<8){
                    txt_Password1=new JTextField();
                    txt_Password1.setBounds(356, 170, 215, 31);
                    txt_Password1.setFont(new Font("Arial",Font.BOLD,14));
                    txt_Password1.setText("* Mật khẩu phải lớn hơn 8 kí tự");
                    txt_Password1.setBorder(new EmptyBorder(5,5,5,5));
                    txt_Password1.setHorizontalAlignment(SwingConstants.RIGHT);
                    txt_Password1.setForeground(Color.RED);
                    panel.add(txt_Password1);


                    txt_Password1.setForeground(Color.RED);

                    ActionListener taskPerformer = new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {

                            txt_Password1.setVisible(false);



                        }
                    };
                    new Timer(7000, taskPerformer).start();


                    return;

                }
            }

            // Phần Check Re_matkhau

            if (!Re_matkhau.equals(matkhau)){

                txt_RePassword1=new JTextField();
                txt_RePassword1.setBounds(366, 222, 194, 30);
                txt_RePassword1.setFont(new Font("Arial",Font.BOLD,14));
                txt_RePassword1.setText("* Mật khẩu không khớp");

                txt_RePassword1.setBorder(new EmptyBorder(5,5,5,5));
                txt_RePassword1.setHorizontalAlignment(SwingConstants.RIGHT);
                txt_RePassword1.setForeground(Color.RED);

                panel.add(txt_RePassword1);




                ActionListener taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {

                        txt_RePassword1.setVisible(false);




                    }
                };
                new Timer(7000, taskPerformer).start();



                return;

            }

            // Phần check Mã Nhân Viên
            if (manv.equals("")){
                System.out.println("rong");
                txt_MaNV1=new JTextField();
                txt_MaNV1.setBounds(366, 286, 194, 31);
                txt_MaNV1.setFont(new Font("Arial",Font.BOLD,14));
                txt_MaNV1.setText("* Không được bỏ trống");

                txt_MaNV1.setBorder(new EmptyBorder(5,5,5,5));
                txt_MaNV1.setHorizontalAlignment(SwingConstants.RIGHT);
                txt_MaNV1.setForeground(Color.RED);

                panel.add(txt_MaNV1);

                //txt_MaNV.setText("");


                ActionListener taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {

                        txt_MaNV1.setVisible(false);




                    }
                };
                new Timer(7000, taskPerformer).start();



                return;

            }
            else {
                if(xl.checkMaNV(manv)==false){
                    JOptionPane.showMessageDialog(null," Mã nhân viên đã tồn tại! \nVui lòng sử dụng mã khác!");
                    return;
                }
            }

            if (MaQuyen.equals("Chọn")){

                lb_checkMaQuyen.setText("* Phải chọn loại mã quyền");
                lb_checkMaQuyen.setFont(new Font("Arial",Font.BOLD,15));

                lb_checkMaQuyen.setForeground(Color.RED);


                ActionListener taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {

                        lb_checkMaQuyen.setVisible(false);




                    }
                };
                new Timer(7000, taskPerformer).start();



                return;

            }

            xl.insertUser(tentaikhoan, matkhau, manv, MaQuyen);
            if (xl.insertUser(tentaikhoan, matkhau, manv, MaQuyen)) {
                JOptionPane.showMessageDialog(null, "Tạo tài khoản Nhân Viên" + tentaikhoan + " thành công");
            }
        }


    }


}

class connect{
    Connection con;


    public boolean connect() {

        try {
            String url="jdbc:mysql://localhost:3306/quanlicuahangdongho";
            String user="root";
            String pass="";
            con=DriverManager.getConnection(url,user,pass);
            if (con!=null){

                return true;
            }


        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public void closeDB(){
        try {
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

class Xu_lyDatabase{
    connect kn=new connect();
    public boolean insertUser( String TenTK, String MatKhau, String MaNV, String MaQuyen){
        try {
            if (kn.connect() == true) {

                String sql1 = "INSERT INTO  `taikhoan` (`TenTK`,`MatKhau`,`MaNV`,`MaQuyen`) VALUES (?,?,?,?)";


                PreparedStatement pst=kn.con.prepareStatement(sql1);



                pst.setString(1,TenTK);
                pst.setString(2,MatKhau);
                pst.setString(3,MaNV);

                pst.setString(4,MaQuyen);



                pst.executeUpdate();
                kn.closeDB();
                return true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return  false;
    }

    public boolean checkTenTaiKhoan(String Tentaikhoan){
        try{
            if (kn.connect()){
                String sql="SELECT TenTK,MaNV FROM taikhoan WHERE TenTK='"+Tentaikhoan+"'";
                Statement st=kn.con.createStatement();


                ResultSet rs= st.executeQuery(sql);

                while(rs.next()){
                    String ten_tk=rs.getString("TenTK");

                    if (ten_tk.equals(Tentaikhoan)){

                        return false;
                    }

                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return true;
    }

    public boolean checkMaNV(String MaNV){
        try{
            if (kn.connect()){
                String sql="SELECT MaNV FROM taikhoan WHERE  MaNV='"+MaNV+"'";
                Statement st=kn.con.createStatement();


                ResultSet rs= st.executeQuery(sql);

                while(rs.next()){

                    String Ma_nv=rs.getString("MaNV");
                    if (Ma_nv.equals(MaNV)){

                        return false;
                    }

                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return true;
    }
}

