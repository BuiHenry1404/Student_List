package SinhVien_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JDBC.JDBC;
import Model.SinhVien;

public class SinhVien_DAO {

	private Connection conn = null;
	private PreparedStatement psm = null;
	private ResultSet rs = null;
	
	//getData
	public List<SinhVien> getData(){
		
		List<SinhVien> lstSinhVien = new ArrayList<>();
		
	
		conn = JDBC.getConnect();
		String sqlData = "SELECT * FROM dbo.SinhVien";
		
		try {
			psm = conn.prepareStatement(sqlData);
			rs = psm.executeQuery();
			while(rs.next()) {
				int mssv = rs.getInt("MSSV");
				String hoTen = rs.getNString("HoTen");
				String gioiTinh = rs.getString("gioiTinh");
				String sdt = rs.getString("SDT");
				String lop = rs.getString("Lop");
				String diaChi = rs.getNString("DiaChi");
				
				SinhVien sv = new SinhVien(mssv,hoTen,gioiTinh,sdt,lop,diaChi);
			
				lstSinhVien.add(sv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.closeConnect(conn);
			if(psm != null) {
				try {
					psm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return lstSinhVien;
	}
	
	
	//insertData
	public void inserData(SinhVien sv) {
		
		
		String insertSQL = "INSERT INTO dbo.SinhVien (HoTen, GioiTinh, SDT, Lop, DiaChi) "
											+ " Values(?   ,     ?   ,  ? ,  ?,    ?)";
		
		conn = JDBC.getConnect();
		try {
			
			
			psm = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
			
			psm.setString(1, sv.getHoTen());
			psm.setString(2, sv.getGioiTinh());	
			psm.setString(3, sv.getSDT());
			psm.setString(4, sv.getLop());
			psm.setString(5, sv.getDiaChi());
			
			int affectedRows = psm.executeUpdate();
	        
	        if (affectedRows > 0) {
	            ResultSet generatedKeys = psm.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                int generatedMSSV = generatedKeys.getInt(1);
	                sv.setMSSV(generatedMSSV);
	            }
	        }	
	        
	        
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.closeConnect(conn);
			if(psm != null) {
				try {
					psm.close();
				} catch (SQLException e) {
					
				}
			
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		
	}
	
	
	
	//DeleteData
	public void deleteData(int MSSV) {
		conn = JDBC.getConnect();
		
		String deleteSQL = "DELETE FROM dbo.SinhVien WHERE MSSV = ?";
		
		try {
			
			psm = conn.prepareStatement(deleteSQL);
			psm.setInt(1, MSSV);
			
			int rowDelete = psm.executeUpdate();
			
			if(rowDelete > 0) {
				System.out.println("Xóa thành công !");
			} else {
				System.out.println("Xóa thất bại ! Không tìm thấy MSSV !");
			}			
		} catch (SQLException e) {
			System.out.println("Xóa thất bại !");
			e.printStackTrace();
		} finally {
			JDBC.closeConnect(conn);
			if(psm != null) {
				try {
					psm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
				
		
	}
	
	//UpdateData
public void updateData(SinhVien sv) {
		
		try {
            // Kết nối cơ sở dữ liệu và chuẩn bị truy vấn SQL
            Connection conn = JDBC.getConnect();
            String query = "UPDATE SinhVien SET HoTen = ?, GioiTinh = ?, SDT = ?, Lop = ?, DiaChi = ? WHERE MSSV = ?";
            psm = conn.prepareStatement(query);
            
            // Đặt các tham số truy vấn SQL từ đối tượng SinhVien
            psm.setString(1, sv.getHoTen());
            psm.setString(2, sv.getGioiTinh());
            psm.setString(3, sv.getSDT());
            psm.setString(4, sv.getLop());
            psm.setString(5, sv.getDiaChi());
            psm.setInt(6, sv.getMSSV());
            
       
            int rowsAffected = psm.executeUpdate();
            

            if (rowsAffected > 0) {
                System.out.println("Dữ liệu sinh viên đã được cập nhật thành công!");
            } else {
                System.out.println("Không tìm thấy sinh viên để cập nhật hoặc dữ liệu không thay đổi!");
            }
            
      
            psm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

	
	
	public List<SinhVien> findAllByName(String name){
		List<SinhVien> kq = new ArrayList<>();
		conn = JDBC.getConnect();
		String fiSQL = "SELECT * FROM dbo.SinhVien WHERE HoTen LIKE ?";
		try {
			psm = conn.prepareStatement(fiSQL);
			psm.setString(1, "%" + name + "%");
			
			rs = psm.executeQuery();
			
			while(rs.next()) {
				int MSSV = rs.getInt("MSSV");
				String hoTen = rs.getString("HoTen");
				String gioiTinh = rs.getString("gioiTinh");
				String sdt = rs.getString("SDT");
				String lop = rs.getString("Lop");
				String diaChi = rs.getNString("DiaChi");
				
				SinhVien sv = new SinhVien(MSSV,hoTen,gioiTinh,sdt,lop,diaChi);
			
				kq.add(sv);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.closeConnect(conn);
			
			if(psm != null) {
				try {
					psm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return kq;
	}

	
	
}
