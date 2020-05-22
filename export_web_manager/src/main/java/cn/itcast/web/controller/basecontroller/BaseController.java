package cn.itcast.web.controller.basecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {

    public HttpServletRequest request;
    public HttpServletResponse response;
    public HttpSession session;

    @ModelAttribute
    public void init(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        this.request=request;
        this.response=response;
        this.session=session;
        //session.getAttribute("user");

    }
}
