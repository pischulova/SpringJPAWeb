package com.mysite.servlet;

import com.mysite.entity.Address;
import com.mysite.entity.Person;
import com.mysite.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Алена on 16.03.14.
 */

@Configuration
public class PersonServlet extends HttpServlet {
    @Autowired
    private PersonService personService;

    @Override
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String city = request.getParameter("address");
        if(name!=null && city!=null){
            personService.createPerson(name);

            Address address = new Address(city);
            Person person = personService.findPerson(name);
            person.setAddress(address);

            List<Person> list = personService.findAll();
            for(Person p: list) {
                out.print(p);
            }
        } else {
            out.print("Enter your name and city.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<Person> list = personService.findAll();
        for(Person p: list) {
            out.print(p);
        }

    }
}
