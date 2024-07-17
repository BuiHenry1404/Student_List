package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.SinhVien;
import SinhVien_DAO.SinhVien_DAO;

import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class SinhVien_View {

	private JFrame frmQunLDanh;
	private JTable table;
	private JTextField txtHoTen;
	private JTextField txtSDT;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtLop;
	private JTextField txtDiaChi;
    private List<SinhVien> lstSinhVien;
    private JTextField txtSrcTen;

	//main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinhVien_View window = new SinhVien_View();
					window.frmQunLDanh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//hiển thị app
	public SinhVien_View() {
		initialize();
		showData();
	
	}

	//cài đặt app hiển thị
	@SuppressWarnings("serial")
	
	
	private void initialize() {
		frmQunLDanh = new JFrame();
		frmQunLDanh.setTitle("QUẢN LÝ DANH SÁCH SINH VIÊN");
		frmQunLDanh.setSize(838, 493);
		
		setupFarme(frmQunLDanh);
		frmQunLDanh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQunLDanh.getContentPane().setLayout(null);
		frmQunLDanh.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 59, 568, 296);
		frmQunLDanh.getContentPane().add(scrollPane);
		
		
		int doCaoCot = 20	;
	
		table = new JTable();

	
		table.setRowHeight(doCaoCot);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MSSV", "H\u1ECD v\u00E0 t\u00EAn", "Gi\u1EDBi t\u00EDnh", "S\u0110T", "L\u1EDBp", "\u0110\u1ECBa ch\u1EC9"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(3).setMinWidth(50);
		table.getColumnModel().getColumn(4).setMinWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(96);
		table.getColumnModel().getColumn(5).setMinWidth(50);
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));

		scrollPane.setViewportView(table);
		
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH SINH VIÊN KHOA HỆ THỐNG THÔNG TIN VÀ VIỄN THÁM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 0, 822, 25);
		frmQunLDanh.getContentPane().add(lblNewLabel);
	    frmQunLDanh.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
	     
	     JPanel panel = new JPanel();
	     panel.setBorder(new TitledBorder(null, "Nh\u1EADp th\u00F4ng tin sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	     panel.setForeground(new Color(255, 255, 255));
	     panel.setBounds(10, 53, 224, 302);
	     frmQunLDanh.getContentPane().add(panel);
	     panel.setLayout(null);
	     
	     JLabel lblHoVaTen = new JLabel("Họ và tên:");
	     lblHoVaTen.setBounds(10, 21, 86, 14);
	     lblHoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
	     panel.add(lblHoVaTen);
	     
	     JLabel lblGioiTinh = new JLabel("Giới tính:");
	     lblGioiTinh.setBounds(10, 77, 55, 14);
	     lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
	     panel.add(lblGioiTinh);
	     
	     JLabel lblSDT = new JLabel("SDT:");
	     lblSDT.setBounds(10, 128, 55, 14);
	     lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
	     panel.add(lblSDT);
	    
	     JLabel lblLop = new JLabel("Lớp:");
	     lblLop.setBounds(10, 184, 55, 14);
	     lblLop.setFont(new Font("Tahoma", Font.PLAIN, 13));
	     panel.add(lblLop);
	     
	     JLabel lblDiaChi = new JLabel("Địa chỉ:");
	     lblDiaChi.setBounds(10, 240, 55, 14);
	     lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
	     panel.add(lblDiaChi);
	     
	     txtHoTen = new JTextField();
	     txtHoTen.setBounds(10, 46, 193, 20);
	     panel.add(txtHoTen);
	     txtHoTen.setColumns(10);
	     
	     JRadioButton rdNam = new JRadioButton("Nam");
	     rdNam.setBounds(83, 98, 55, 23);
	     buttonGroup.add(rdNam);
	     panel.add(rdNam);
	     
	     JRadioButton rdNu = new JRadioButton("Nữ");
	     rdNu.setBounds(10, 98, 55, 23);
	     buttonGroup.add(rdNu);
	     rdNu.setSelected(true);
	     panel.add(rdNu);
	     
	     txtSDT = new JTextField();
	     txtSDT.setBounds(10, 153, 193, 20);
	     panel.add(txtSDT);
	     txtSDT.setColumns(10);
	     
	     txtLop = new JTextField();
	     txtLop.setBounds(10, 209, 193, 20);
	     txtLop.setColumns(10);
	     panel.add(txtLop);
	     
	     txtDiaChi = new JTextField();
	     txtDiaChi.setBounds(10, 265, 193, 20);
	     txtDiaChi.setColumns(10);
	     panel.add(txtDiaChi);
	     
	     JButton btnSave_ = new JButton("Save");
	     btnSave_.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     		String hoTen = txtHoTen.getText();
	     		String gioiTinh = rdNam.isSelected() ? "Nam" : "Nữ";
	     		String sdt = txtSDT.getText();
	     		String lop = txtLop.getText();
	     		String diaChi = txtDiaChi.getText();
	     		
	     		
	     		if(hoTen.isEmpty()) {
	     			JOptionPane.showMessageDialog(null, "Vui lòng nhập Họ và tên của sinh viên !");
	     		} else if(lop.isEmpty()) {
	     			JOptionPane.showMessageDialog(null, "Vui lòng nhập lớp của sinh viên !");
	     		} else {
	     			
	     			SinhVien sv = new SinhVien(hoTen, gioiTinh, sdt, lop, diaChi);
	     			SinhVien_DAO svDAO = new SinhVien_DAO();
	     			
	     			svDAO.inserData(sv);
	     			showData();
	     			
	     			txtHoTen.setText("");
		     		txtSDT.setText("");
		     		txtLop.setText("");
		     		
		     		txtDiaChi.setText("");
		     		
		     		if(rdNam.isSelected()) {
		     			rdNu.setSelected(true);	     			
		     		}
	     		}
	     	
	     	}
	     });
	    	 
	     
	     
	     btnSave_.setBounds(10, 366, 95, 32);
	     frmQunLDanh.getContentPane().add(btnSave_);
	     btnSave_.setFocusPainted(false);
	     
	     
	     
	     JButton btnReset_ = new JButton("Reset");
	     btnReset_.addActionListener(new ActionListener() {	    	 
	     	public void actionPerformed(ActionEvent e) {
	     		txtHoTen.setText("");
	     		txtSDT.setText("");
	     		txtLop.setText("");
	     		
	     		txtDiaChi.setText("");
	     		if(rdNam.isSelected()) {
	     			rdNu.setSelected(true);	     			
	     		}
	     	}
	     });
	     
	     btnReset_.setBounds(10, 409, 95, 32);
	     frmQunLDanh.getContentPane().add(btnReset_);
	     btnReset_.setFocusPainted(false);
	     	
	     table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					int seData = table.getSelectedRow();
					
					if(seData != -1) {
						
						int MSSV = (int) table.getValueAt(seData, 0);
						String hoTen = (String) table.getValueAt(seData, 1);
						String gt = (String) table.getValueAt(seData, 2);
						String sdt = (String) table.getValueAt(seData, 3);
						String lop = (String) table.getValueAt(seData, 4);
						String diaChi = (String)table.getValueAt(seData, 5);
						
						txtHoTen.setText(hoTen);
						if(gt.equals("Nam")) {
							rdNam.setSelected(true);
						} else {
							rdNu.setSelected(true);
						}
						
						txtSDT.setText(sdt);
						txtLop.setText(lop);
						txtDiaChi.setText(diaChi);
					}
					
				}
			});
				
	     JButton btnUpdate_ = new JButton("Update");
	     btnUpdate_.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     		int seData = table.getSelectedRow(); 
	     		int MSSV = (int) table.getValueAt(seData, 0);
	     		
	     		String hoTen = txtHoTen.getText();
	     		String gt = rdNam.isSelected() ? "Nam" : "Nữ";
	     		String lop = txtLop.getText();
	     		String sdt = txtSDT.getText();
	     		String diaChi = txtDiaChi.getText();
	     				
	     		SinhVien sv = new SinhVien(MSSV, hoTen, gt, sdt, lop, diaChi);
	     		SinhVien_DAO svDAO = new SinhVien_DAO();
	     		svDAO.updateData(sv);
	     		showData();	     		
	     		
	     	}
	     });
	     btnUpdate_.setBounds(139, 366, 95, 32);
	     frmQunLDanh.getContentPane().add(btnUpdate_);
	     btnUpdate_.setFocusPainted(false);
	     
	     
	     
	     JButton btnDelete_ = new JButton("Delete");
	     btnDelete_.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     			int viTriData = table.getSelectedRow();
	     			
	     			if(viTriData != -1 ) {//Dữ liệu được chọn
	     				
	     				int option = JOptionPane.showConfirmDialog(null, "Xác nhận xóa sinh viên này ?");
	     				
	     				if(option == 1 || option == 2 ) {
	     					return;
	     				}	     				 	     
	     				int mssv = (int) table.getValueAt(viTriData, 0);
	     				
	     				SinhVien_DAO svDAO = new SinhVien_DAO();
	     				svDAO.deleteData(mssv);
	     				
	     				showData();
	     			} else {
	     				
	     				JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên để xóa !");
	     				
	     			}
	     		}
	
	     });
	     btnDelete_.setBounds(139, 409, 95, 32);
	     frmQunLDanh.getContentPane().add(btnDelete_);
	     btnDelete_.setFocusPainted(false);
	     
	     JPanel panel_1 = new JPanel();
	     panel_1.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	     panel_1.setBounds(244, 366, 386, 75);
	     frmQunLDanh.getContentPane().add(panel_1);
	     panel_1.setLayout(null);
	     
	     JLabel lblSrcTen = new JLabel("Họ và tên:");
	     lblSrcTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
	     lblSrcTen.setBounds(10, 33, 83, 14);
	     panel_1.add(lblSrcTen);
	     
	     txtSrcTen = new JTextField();
	     txtSrcTen.setBounds(77, 30, 180, 20);
	     panel_1.add(txtSrcTen);
	     txtSrcTen.setColumns(10);
	     
	     JButton btnSrc = new JButton("Tìm kiếm");
	     btnSrc.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     		String srcTen = txtSrcTen.getText();
	     		
	     		
	     		SinhVien_DAO svDAO = new SinhVien_DAO();
	     		List<SinhVien> kq = svDAO.findAllByName(srcTen);
	     		
	     		DefaultTableModel model = (DefaultTableModel) table.getModel();
	    		model.setRowCount(0);

	    		for (SinhVien sv : kq) {
	    			Object[] row = { sv.getMSSV(), sv.getHoTen(), sv.getGioiTinh(), sv.getSDT(), sv.getLop(), sv.getDiaChi() };
	    			model.addRow(row);
	    		}

	     		
	     		
	     	}
	     });
	     btnSrc.setBounds(267, 29, 89, 23);
	     panel_1.add(btnSrc);
	
		
	}
	
	//ShowData
	private void showData() {
		SinhVien_DAO svDAO = new SinhVien_DAO();
		lstSinhVien = svDAO.getData();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (SinhVien sv : lstSinhVien) {
			Object[] row = { sv.getMSSV(), sv.getHoTen(), sv.getGioiTinh(), sv.getSDT(), sv.getLop(), sv.getDiaChi() };
			model.addRow(row);
		}
	}
	
	//Frame ở giữa màn hình
	public void setupFarme(JFrame frame) {
		
		Dimension sizeManHinh = Toolkit.getDefaultToolkit().getScreenSize();
		
		int manHinh_cr = sizeManHinh.width;
		int manHinh_cc = sizeManHinh.height;
		
		int frame_cr = frame.getWidth();
		int frame_cc = frame.getHeight();
		
		int viTri_X = (manHinh_cr - frame_cr) / 2;
		int viTri_Y = (manHinh_cc - frame_cc) / 2;
		
		frame.setLocation(viTri_X,viTri_Y);
	}
}
