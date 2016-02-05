package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by Andzhel on 04.02.2016.
 */
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Members members = Members.getInstance();
        String login = req.getParameter("login");
        Member member = members.findByName(login);
        if (member==null) {resp.setStatus(401); return;}
        member.setOnline(false);
        member.setLastConnection(LocalDateTime.now().toString());
    }

}
