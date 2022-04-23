package com.skillsoft.springbootmail.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BookHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    private JavaMailSender javaMailSender;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getParameter("bookId") != null){
            System.out.println("preHandle() method sending book accessed mail...");
            sendMail(request.getParameter("bookId"),"Book accessed");
            System.out.println("Done...");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (request.getParameter("bookId") != null){
            System.out.println("postHandle() method sending book access mail...");
            sendMail(request.getParameter("bookId"),"Book access complete");
            System.out.println("Done...");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (request.getParameter("bookId") != null){
            System.out.println("Sending book request and response completion mail...");
            sendMail(request.getParameter("bookId"),"Request and response complete");
            System.out.println("Done...");
        }
    }

    private void sendMail(String bookId, String message) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("akintopbas11@gmail.com");

        msg.setSubject("Book related activity for book: " + bookId);
        msg.setText(message + ": "+dateFormat.format(new Date()));

        javaMailSender.send(msg);
    }
}
