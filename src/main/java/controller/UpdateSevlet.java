package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Student;
import implement.StudentImp;

/**
 * Servlet implementation class UpdateSevlet
 */
@WebServlet("/update")
public class UpdateSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSevlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int old_id = Integer.parseInt(request.getParameter("id"));
		StudentImp stuImp = new StudentImp();
		Student oldStu = stuImp.find_by_id(old_id);
		request.setAttribute("detail", oldStu);
		request.getRequestDispatcher("views/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg_success, msg_err;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int old_id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		
		StudentImp imp = new StudentImp();
		boolean check_insert = imp.update(new Student(old_id, name, address, email, phone, status));

		if (check_insert == true) {
			msg_success = "Sửa thành công!!";
			request.setAttribute("success", msg_success);
		} else {
			msg_err = "Sửa thất bại!!";
			request.setAttribute("err", msg_err);
		}
		request.getRequestDispatcher("views/update.jsp").forward(request, response);
	}

}
