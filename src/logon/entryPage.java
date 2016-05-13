package logon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import property.commandAction;

	public class entryPage implements commandAction{
		

	
		@Override
		public String requestPro(HttpServletRequest request,
				HttpServletResponse response) throws Throwable {
		
			
			
			
			return "logonPage/entryPage.jsp";
		}
	}

