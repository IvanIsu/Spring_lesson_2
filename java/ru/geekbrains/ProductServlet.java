package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/products/*")
public class ProductServlet extends HttpServlet {

    ProductHolder productHolder;

    @Override
    public void init() throws ServletException {
        this.productHolder = new ProductHolder();
        this.productHolder.insert(new Product("Glue", 10.0));
        this.productHolder.insert(new Product("Lemon Tree", 25.0));
        this.productHolder.insert(new Product("Table", 22.0));
        this.productHolder.insert(new Product("Apple", 5.0));
        this.productHolder.insert(new Product("Orange", 6.0));
        this.productHolder.insert(new Product("Smartphone", 99.99));
        this.productHolder.insert(new Product("Notebook", 199.00));
        this.productHolder.insert(new Product("Chair", 15.00));
        this.productHolder.insert(new Product("Cucumber", 3.0));
        this.productHolder.insert(new Product("Onion", 2.0));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getPathInfo() == null || req.getPathInfo().equals("/")) {
            req.setAttribute("product", productHolder.findAll());
            getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
            return;
        }

        if (req.getPathInfo() != null) {

            String path = req.getPathInfo().replace("/","");
            if(this.checkValid(path)){
                Long id = Long.valueOf(path);
                if(productHolder.findById(id) != null){
                    req.setAttribute("product", productHolder.getById(id));
                    getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
                    return;
                }else {
                    resp.getWriter().println("<h1>" + "Not available product" + "</h1>");
                }
            }
        }
    }

    public boolean checkValid(String str) {
        try {
            Long.valueOf(str);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }
}

