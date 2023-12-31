package com.elpoli.edu.co.ces3.universitas.Servlets;

import com.elpoli.edu.co.ces3.universitas.Objects.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "studentServlet", value = "/student")
public class StudentServlet extends MyServlet {
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

        String studentId = request.getParameter("studentId");
        PrintWriter out = response.getWriter();
        if (studentId == null){
            out.println(gson.toJson(students));
        } else {
            Student studentSearch = null;
            for (Student s: students){
                if (s.getId() == Integer.parseInt(studentId)){
                    studentSearch = s;
                    break;
                }
            }
            out.println(gson.toJson(studentSearch));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException {
        resp.setContentType("application/json");
        ServletOutputStream out = resp.getOutputStream();
        JsonObject body = this.getParamsFromPost(req);

        Student student = new Student(
                body.get("id").getAsInt(),
                body.get("cedula").getAsString(),
                body.get("nombre").getAsString()
        );

        this.students.add(student);
        out.println(gson.toJson(student));
        out.flush();

    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        JsonObject body = this.getParamsFromPost(request);

        int studentId = body.get("id").getAsInt();

        Student studentToUpdate = null;
        for (Student student : students) {
            if (student.getId() == studentId) {
                studentToUpdate = student;
                break;
            }
        }

        if (studentToUpdate != null) {
            studentToUpdate.setNombre(body.get("nombre").getAsString());
            studentToUpdate.setCedula(body.get("cedula").getAsString());

            PrintWriter out = response.getWriter();
            out.println("Se actualizo la informacion.");
            out.flush();
            System.out.println("El id " + studentId + " se actualizo");

        } else {
            PrintWriter out = response.getWriter();
            out.println("No se encontro informacion.");
            out.flush();
        }
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        String studentId = request.getParameter("studentId");
        if (studentId != null) {
            int idToDelete = Integer.parseInt(studentId);
            Student studentToDelete = null;

            for (Student student : students) {
                if (student.getId() == idToDelete) {
                    studentToDelete = student;
                    break;
                }
            }

            if (studentToDelete != null) {
                students.remove(studentToDelete);
                PrintWriter out = response.getWriter();
                out.println("El id " + idToDelete + " se elimino.");
                out.flush();
            } else {
                PrintWriter out = response.getWriter();
                out.println("No se encontro información");
            }
        }
        System.out.println("Se elimino el id " + studentId);
    }

        public void destroy() {
    }
}