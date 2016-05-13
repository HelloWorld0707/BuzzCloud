<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>BuzzCloud</title>
		
		
    <script type="text/javascript" charset="utf-8" src="http://code.jquery.com/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.0/jquery.cookie.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js"></script>


		</head>	
		
	<body>
	
	</div>
	<div id="naver_id_login">
		
 	 <!-- <input type="BUTTON" value="네이버로 로그인" name="LoginToNaver" class="NAVER_BUTTON"  onclick='loginProcess()'></input> -->
		
		</div>
		<div><input type="BUTTON" value="정보보기" onclick='load()'></input>
		
		<div><h3 id="result"></h3></div>
		
		
		
<script type="text/javascript">

		var naver = new naver_id_login("Vf8cYbYQv2N0c_cSv_XA", "http://114.129.211.33:8181/");
		var state = naver.getUniqState();
		naver.setState(state);
		naver.setButton(BUTTON_COLOR_GREEN, BANNER_BIG_TYPE, 40);
		naver.setStateStore();
		naver.init_naver_id_login();	 

		getParameter = function(param){
		    full_url=location.href;
		    
		  			//파라미터가 하나도 없을때
		    if(full_url.search("&") == -1)
		        return false;
		  			
	
		  			
		 
		    search=full_url.split("#");
				    //해당하는 파라미터가 없을때.
		    if(search[1].indexOf(param)==(-1)){
		        
		        return "";
		        return;
				    }
		    
		    search=search[1].split("&");

		   		 //한개의 파라미터일때.
		    if(search.length<3){
		       
		        data=search[1].split("=");
		        return data[1];
				    }
		    else{
				    //여러개의 파라미터 일때.
			    var i=0;
		    		for(i=0 ; i < search.length ; i++){
		    				data = search[i].split("=");
			    			if(data[0].match(param))
			    				return data[1];
		    			}
			    	if(i==search.length)
		    				return NULL;
		    		}
		    
		}

		function naverSignInCallback() {
			// naver_id_login.getProfileData('프로필항목명');
			// 프로필 항목은 개발가이드를 참고하시기 바랍니다.
			alert(naver.getProfileData('email'));
			alert(naver.getProfileData('nickname'));
			alert(naver.getProfileData('age'));
		}

		
		window.onload=function(){
			var form = document.createElement("form");
			var state = getParameter("state");
			var savedNaverState = naver.state;

			//네이버로그인 콜백인지 확인 
			if( state.match(savedNaverState)){

				document.getElementById("email").value = naver.getProfileData("email");
				document.getElementById("nickname").value = naver.getProfileData("nickname");
				document.getElementById("password").value = "";
				document.getElementById("idType").value = "naver";
				document.getElementById("reg_date").value = "";
				
	   	form.submit();
			}
				
			
				
		}
</script>
		<div>
			<form method="POST" ACTION="${pageContext.request.contextPath}/logon.do">
				<input type = "hidden" id = "email" value = "" >
				<input type = "hidden" id = "nickname" value = "" >
				<input type = "hidden" id = "password" value = "" >
				<input type = "hidden" id = "idType" value = "" >
				<input type = "hidden" id = "reg_date" value = "" >
			</form>
		</div>
	</body>
</html>