package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Student;
import implement.StudentImp;

@WebServlet("/delete")
public class DeleteServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServelet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int old_id = Integer.parseInt(request.getParameter("id"));
		StudentImp stuImp = new StudentImp();
		boolean check_delete = stuImp.remove(old_id);
		response.sendRedirect("view_all");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
