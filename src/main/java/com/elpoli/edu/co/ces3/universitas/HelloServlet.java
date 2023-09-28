package com.elpoli.edu.co.ces3.universitas;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Obtener el valor del input
        String inputText = request.getParameter("inputText");

        // Verificar si es un palindromo
        boolean isPalindrome = isPalindrome(inputText);

        // Preparar la respuesta
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Verificador de Palindromos</h1>");
        out.println("<div>");

        if (isPalindrome) {
            out.println("<p>La frase \"" + inputText + "\" es un palíndromo.</p>");
        } else {
            out.println("<p>La frase \"" + inputText + "\" no es un palíndromo.</p>");
        }

        out.println("</div>");
        out.println("<form action=\"index.jsp\">");
        out.println("<button type=\"submit\">Volver</button>");
        out.println("</form>");
        out.println("</body></html>");
    }

    private boolean isPalindrome(String input) {
        // Eliminar espacios en blanco y convertir a minúsculas
        input = input.replaceAll("\\s+", "").toLowerCase();

        // Revertir la cadena
        StringBuilder reversed = new StringBuilder(input).reverse();

        // Comparar la cadena original con la cadena revertida
        return input.equals(reversed.toString());
    }
}