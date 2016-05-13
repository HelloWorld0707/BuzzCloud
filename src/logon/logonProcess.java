package logon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import property.commandAction;

	public class logonProcess implements commandAction{
		

	
		@Override
		public String requestPro(HttpServletRequest request,
				HttpServletResponse response) throws Throwable {
		
			System.out.println(request.getAttribute("email"));
			
			
			
			return "logonPage/mainPage.jsp";
		}
	}

