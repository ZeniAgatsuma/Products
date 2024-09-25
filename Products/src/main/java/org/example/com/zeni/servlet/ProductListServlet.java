package org.example.com.zeni.servlet; // Змінено на правильний пакет

import org.example.com.zeni.model.Product; // Оновлено на правильний пакет
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Створення списку продуктів під час обробки запиту
        List<Product> productList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            productList.add(new Product(i, "Продукт " + i, 10.00 + i)); // Додаємо 10 продуктів
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Список продуктів</title></head>");
        out.println("<body>");
        out.println("<h1>Список продуктів</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Назва</th><th>Вартість</th></tr>");
        for (Product product : productList) {
            out.println("<tr><td>" + product.getId() + "</td><td>" + product.getTitle() + "</td><td>" + product.getCost() + "</td></tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
