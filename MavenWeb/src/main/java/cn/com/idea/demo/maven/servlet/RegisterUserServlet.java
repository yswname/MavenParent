package cn.com.idea.demo.maven.servlet;

import cn.com.idea.demo.maven.entity.UserEntity;
import cn.com.idea.demo.maven.service.IUserService;
import cn.com.idea.demo.maven.service.impl.UserServiceImpl;
import sun.security.krb5.internal.PAForUserEnc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/registerServlet")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String userName = req.getParameter("userName");
        String ageStr = req.getParameter("age");
        int age = 10;
        try{
            age = Integer.parseInt(ageStr);
        }catch (Exception e){}
        UserEntity userEntity = new UserEntity();
        userEntity.setUrAge(age);
        userEntity.setUrName(name);
        userEntity.setUrUserName(userName);

        IUserService userService = new UserServiceImpl();
        userService.register(userEntity);

        req.getRequestDispatcher("/success.jsp").forward(req,resp);
    }
}
