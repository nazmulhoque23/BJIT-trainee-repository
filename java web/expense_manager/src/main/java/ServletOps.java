import DBOperation.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/s")
public class ServletOps extends HttpServlet {
    DBConnection dbc = new DBConnection();


//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        System.out.println("SUCCESS");
////        resp.getWriter().append("Served at: ").append(req.getContextPath());
//        doPost(req,resp);
//
//    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("exp_category");
        String date = req.getParameter("date");
        String expName = req.getParameter("exp_name");
        String description = req.getParameter("desc");
        Integer amount = Integer.valueOf(req.getParameter("amount"));

        dbc.insertOperation(category, date, expName, description, amount);

        RequestDispatcher dispatcher = req.getRequestDispatcher("show.jsp");
        dispatcher.forward(req, resp);
        //resp.sendRedirect("show.jsp");
    }



}
