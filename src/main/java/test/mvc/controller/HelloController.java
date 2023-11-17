package test.mvc.controller;
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

import test.mvc.action.MainAction;
import test.mvc.action.SuperAction;
import test.mvc.action.TestAction;

// 1.  HttpServlet 클래스 상속
// 2. doGet / doPost / service 중 한가지 메서드 오버라이딩 한다.
//<form action="" method="post"> 이렇게 써왔는데  service 는 두가지 다쓰는거
public class HelloController extends HttpServlet {
	
	private Map map = new HashMap<String, SuperAction>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {  
		//properties 파일 읽기
		// 외부정보를 읽는 작업.
		String commandURI = config.getInitParameter("commandURI");  // 파라미터로 파일경로를 가져왓다
		FileInputStream fis = null;  // 예외처리하려고
		try {
			fis = new FileInputStream(commandURI); //경로 안 파일 =fis
			Properties p = new Properties();  
			p.load(fis); // key, value를 각각 나누어 주는 것
			
			//System.out.println(p);
			Iterator iter = p.keySet().iterator();
			while(iter.hasNext()) {
				String key = (String)iter.next();//첫번째 키를 꺼내줌
				String value = p.getProperty(key); //key에 맞는 벨류값
				Class c= Class.forName(value);  // c로 이름 정리 벨류
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
	    //System.out.println("mvc controller");
	    
	    
	    //url => http 부터 시작하는 모든 주소를 지칭
	   	//uri => ip:port를 제외한 나머지 주소 ex) localhost:8080 을 제외한
	    // http://localhost:8080   <<url     uri>> /mvc/ad.do
	    
	    
	    String uri = request.getRequestURI();
	    String view ="/WEB-INF/views/";
	    
	    SuperAction sa = (SuperAction)map.get(uri);
	    view +=sa.action(request, response);
	    
	    request.getRequestDispatcher(view).forward(request, response);	
	    
	    //if(uri.equals("/mvc/main.do")) {	    	
	    	//비지니스로직으로 다음 행동을 추가한 후 실행 ( dto, 파라미터 등 호출)
	    	//action class
	    	//여기선 MainAction 호출
	    	//기존 이거에서 아래걸로 view += "1113/main.jsp";
	    //	sa = new MainAction();
	    	//view += sa.action(request, response);
	    	
	   // }else if (uri.equals("/mvc/test.do")){
	    	//TestAction 호출
	    	//기존 이거에서 아래껄로 view += "test/test.jsp";
	    //	sa = new TestAction();
	    //	view += sa.action(request, response);
		//}else {
		//	view += "index.jsp";
	//	}
	    //request.getRequestDispatcher(view).forward(request, response);
	}
}
