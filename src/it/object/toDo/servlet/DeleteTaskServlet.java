package it.object.toDo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.object.toDo.model.TaskObj;

@WebServlet("/delete")
public class DeleteTaskServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		List<TaskObj> listTasks = (List<TaskObj>) session.getAttribute("listTodo");

		int index = Integer.parseInt(req.getParameter("deleteId"));

		if (listTasks.isEmpty()) {
			List<TaskObj> listTasksNew = new ArrayList<TaskObj>();
			session.setAttribute("listTodo", listTasksNew);
			req.getRequestDispatcher("pages/toDoList.jsp").forward(req, resp);
		} else {
			listTasks.remove(index);
			for (int i=0; i < listTasks.size(); i++) {
				listTasks.get(i).setId(i);
			}

		}
		req.setAttribute("listTodo", listTasks);
		req.getRequestDispatcher("pages/toDoList.jsp").forward(req, resp);

	}
}
