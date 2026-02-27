package com.meuprojeto.cinemaparadiso;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = request.getReader().readLine()) != null) {
            sb.append(line);
        }
        
        String jsonData = sb.toString();
        String cpf = jsonData.replaceAll("[^0-9]", "");

        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT nome, cargo FROM Funcionario WHERE cpf = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();

            PrintWriter out = response.getWriter();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                
                String jsonResponse = String.format(
                    "{\"success\": true, \"funcionario\": {\"nome\": \"%s\", \"cargo\": \"%s\"}}", 
                    nome, cargo
                );
                out.print(jsonResponse);
            } else {
                out.print("{\"success\": false, \"message\": \"CPF não encontrado\"}");
            }
            out.flush();

        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            PrintWriter out = response.getWriter();
            out.print("{\"success\": false, \"message\": \"Erro no servidor: " + e.getMessage() + "\"}");
            out.flush();
        }
    }
}