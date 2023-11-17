package test.mvc.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.mvc.dto.TestDTO;

public class JstlAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("name", "hong");
		String [] str = {"AA", "BB", "CC", "DD"};
		request.setAttribute("arr", str);   // jstl01 파일로 값을 보냄
		
		TestDTO dto1 = new TestDTO();
		dto1.setNum(1); dto1.setName("kim");
		
		TestDTO dto2 = new TestDTO();
		dto2.setNum(2); dto2.setName("lee");
		
		request.setAttribute("d1", dto1);
		request.setAttribute("d2", dto2);
		
		List list = new ArrayList();
		list.add(dto1);
		list.add(dto2);
		request.setAttribute("al", list);
		
		return "1114/jstl01.jsp";
	}

}
