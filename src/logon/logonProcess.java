package logon;

import logon.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

import javaBean.logonBean;
import javaBean.memberDataBean;
import property.commandAction;

	@WebServlet("/logon.do")
	public class logonProcess implements commandAction{
		
		@Override
		public String requestPro(HttpServletRequest request,
				HttpServletResponse response) throws Throwable {
		
			logonBean lb = new logonBean();
			
			String idType = (String) request.getAttribute("idType");
			
			
			switch(idType){
			
				case "naver":
					
					memberDataBean mdb = new memberDataBean();
					mdb.setId(0);
					mdb.setEmail( (String) request.getAttribute("nickname") );
					mdb.setIdType((String)request.getAttribute("idType"));
					mdb.setNickname((String)request.getAttribute("nickname"));
					mdb.setPassword((String)request.getAttribute("nickname"));
					mdb.setReg_date(new Timestamp(System.currentTimeMillis()) );
					
					if(lb.joinMember(mdb) == false)
						request.setAttribute("joinResult", false);
					else
						request.setAttribute("joinResult", true);
					break;
					
				case "google":
						
					break;
				
				case "facebook":
					
					break;
					
					default:
			
			}
			
			
			
			return "logonPage/mainPage.jsp";
		}
	}

