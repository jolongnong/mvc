package board.mvc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.mvc.action.SuperAction;

public class BoardController extends HttpServlet{
private Map map = new HashMap<String, SuperAction>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {  
		//properties 파일 읽기
		// 외부정보를 읽는 작업.
		String commandURI = config.getInitParameter("boardURI");  // 파라미터로 파일경로를 가져왓다
		FileInputStream fis = null;  // 예외처리하려고
		try {
			fis = new FileInputStream(commandURI); //경로 안 파일 =fis
			Properties p = new Properties();  
			p.load(fis); // key, value를 각각 나누어 주는 것
			
			//System.out.println(p);
			Iterator iter = p.keySet().iterator();
			while(iter.hasNext()) {
				String key = (String)iter.next();//첫번째 키를 꺼내줌
				String value = p.getProperty(key.trim()); //key에 맞는 벨류값,trim() 공백을제거
				Class c= Class.forName(value.trim());  // c로 이름 정리 벨류,trim() 공백을제거
				Object obj = c.newInstance();   // 인스턴스 만듬
				map.put(key, obj);      // 맵에 집어넣음				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//요청할때마다 동작하는거
	@Override
	protected void service(HttpServletRequest request,
			               HttpServletResponse response) throws ServletException, IOException {				

	    
	    String uri = request.getRequestURI();
	    String view ="/WEB-INF/views/";
	    
	    Object obj = map.get(uri);
	    SuperAction sa = null;	    
	    if(obj !=null && obj instanceof SuperAction) {  //obj가 superaction을 구현하고 있느냐
	    	sa = (SuperAction)obj;
	    	view +=sa.action(request, response);
	    }else {
	    	view +="error/error.jsp";
	    }
	  	    
	 
	    
	    request.getRequestDispatcher(view).forward(request, response);	

	}


}
