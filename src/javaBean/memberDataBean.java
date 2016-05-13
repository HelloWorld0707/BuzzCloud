package javaBean;

import java.sql.Timestamp;

//User Table 참조
public class memberDataBean {

	private String id;
	private String name;
	private String password;
	private String idType;
	private Timestamp reg_date;
	
	public memberDataBean(){
	}
	
	public memberDataBean(memberDataBean mdb){
		id = mdb.id;
		name = mdb.name;
		password = mdb.password;
		idType = mdb.idType;
		reg_date = mdb.reg_date;
	}
	
	public memberDataBean(String id, String name, String pw, String idType, Timestamp reg_data){
		this.id = id;
		this.name = name;
		this.password = pw;
		this.idType = idType;
		this.reg_date = reg_date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	
	
	
	
}
