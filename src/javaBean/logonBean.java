package javaBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class logonBean {

	 private static memberDataBean instance = new memberDataBean();
	    
	 public static memberDataBean getInstance() {
	        return instance;
	    }
	    
	 private logonBean() { }
		
		private Connection getConnection() throws Exception {
		    Context initCtx = new InitialContext();
		    Context envCtx = (Context) initCtx.lookup("java:comp/env");
		    DataSource ds = (DataSource)envCtx.lookup("jdbc/basicjsp");
		    return ds.getConnection();
		}
		
		public memberDataBean makeMember(String id, String name, String pw, String idType, Timestamp reg_data){
			
			return new memberDataBean(id, name, pw, idType, reg_data);
		}
		
		public boolean confirmId(String Id)
				throws Exception {
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					boolean isDuplicated = false;
					try{
								conn = getConnection();
			    
			
								
								ps = conn.prepareStatement(
										"select Id from User_Id_Mail where id = ?");
								ps.setString(0, Id);
								
								rs = ps.executeQuery();
								//중복아이디가 있는지 결과를 저장 
								if(rs.next())
									isDuplicated = true;
								else
									isDuplicated = false;
									
								
				}
				catch(Exception e) {
					e.printStackTrace();
				}finally{
					if (ps != null) 
						try { ps.close(); } catch(SQLException ex) {}
					if (conn != null) 
						try { conn.close(); } catch(SQLException ex) {}
				}
				
				return isDuplicated;
		}
		
		public void joinMember(memberDataBean member) 
			              throws Exception {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
				        
			try{
				conn = getConnection();
	
				pstmt = conn.prepareStatement(
				    "insert into MEMBER values (?,?,?,?,?)");
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getName());
				pstmt.setString(3, member.getPassword());
				pstmt.setString(4, member.getIdType());
				pstmt.setTimestamp(5, member.getReg_date());
				
				pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				if (pstmt != null) 
					try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) 
					try { conn.close(); } catch(SQLException ex) {}
			}
		}
				 

	
	
}
