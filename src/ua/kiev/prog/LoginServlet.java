package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Andzhel on 02.02.2016.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Members members = Members.getInstance();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Member member = members.findByName(login);
        if (member==null) {resp.setStatus(401); return;}
        if (!member.getPassword().equals(password)) {resp.setStatus(401); return;}
        HttpSession httpSession = req.getSession();
        member.setSessionID(httpSession.getId());
        member.setOnline(true);
    }
}
