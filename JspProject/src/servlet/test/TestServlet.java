package servlet.test;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.test.TestDto;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 임의로 List에 TestDto 데이터를 넣어본다
    	List<TestDto> list = new Vector<TestDto>();
    	list.add(new TestDto("소나타", "gray", 3500));
    	list.add(new TestDto("그랜져", "pink", 4100));
    	list.add(new TestDto("모닝", "blue", 1500));
    	list.add(new TestDto("미니", "yellow", 4500));
    	list.add(new TestDto("아반떼", "orange", 2500));
    	
    	//request에 저장
    	request.setAttribute("list", list);
    	// forward
    	RequestDispatcher rd = request.getRequestDispatcher("day1103/ex9_result.jsp");
    	rd.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
