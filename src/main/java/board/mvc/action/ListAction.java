package board.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import test.mvc.action.SuperAction;
import board.mvc.dao.BoardDAO;
import java.text.SimpleDateFormat;
import java.util.List;
		
public class ListAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		try {
	         request.setCharacterEncoding("UTF-8");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
	    int pageSize = 10; 
	    int pageBlock=10;
	    int pageCount=0;
	    int startPage=0;
	    int endPage=0;
	    
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	    String pageNum = request.getParameter("pageNum");
	    if (pageNum == null) {
	        pageNum = "1";
	    }

	    int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage - 1) * pageSize + 1;
	    int endRow = currentPage * pageSize;
	    int count = 0;
	    int number=0;

	    List articleList = null;
	    BoardDAO dbPro = BoardDAO.getInstance();
	    
	    try {
	    	count = dbPro.getArticleCount();
		    if (count > 0) {
		     articleList = dbPro.getArticles(startRow, endRow);
		    }
		    
		    request.setAttribute("count", count);
		    request.setAttribute("articleList", articleList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    number=count-(currentPage-1)*pageSize;
	    
	    pageCount=  count / pageSize + ( count % pageSize == 0 ? 0 : 1);	    
	    startPage = (int)(currentPage/10)*10+1;		    
        endPage = startPage + pageBlock-1;     
        
        if (endPage > pageCount) endPage = pageCount;
	    
	    
	    request.setAttribute("pageSize", pageSize);
	    request.setAttribute("pageBlock", pageBlock);
	    request.setAttribute("sdf", sdf);
	    request.setAttribute("number", number);
	    request.setAttribute("pageCount", pageCount);
	    request.setAttribute("startPage", startPage);

		
	

		
		return "board/list.jsp";
	}

}
