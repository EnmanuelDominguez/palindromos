package com.elpoli.edu.co.ces3.universitas.Servlets;

import com.elpoli.edu.co.ces3.universitas.Objects.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "studentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private String message;
    private GsonBuilder gsonBuilder;
    private Gson gson;
    private ArrayList<Student> students;
    public void init() {

        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();

        students = new ArrayList<>();
        Student student1 = new Student();
        student1.id = 10;
        student1.setNombre("Enmanuel");
        student1.setCedula("1140423482");
        students.add(student1);

        for (int i = 0; i < students.size(); i = i+1){
            System.out.println(students.get(i));
        }

        message = "Hello student.";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        //getStudentByParam
        String studentId = request.getParameter("studentId");
        PrintWriter out = response.getWriter();
        //Si param viene vacio...
        if (studentId == null){
            out.println(gson.toJson(students));
            //Si param viene lleno...
        } else {
            Student studentSearch = null;
            //For mejorado realizado en clase
            for (Student s: students){
                if (s.getId() == Integer.parseInt(studentId)){
                    studentSearch = s;
                    break;
                }
            }
            out.println(gson.toJson(studentSearch));
        }
    }

    public void destroy() {
    }
}