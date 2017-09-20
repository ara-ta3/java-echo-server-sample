package com.ru.waka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns={"/"})
public class EchoServlet extends HttpServlet {
    private ObjectMapper mapper;

    public EchoServlet() {
        this.mapper = new ObjectMapper();
        this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("application/json");

        JsonResponseBody body = new JsonResponseBody(false, "not implemented");
        String json = this.mapper.writeValueAsString(body);
        res.getWriter().append(json).flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("application/json");
        res.getWriter().append("{\"ok\": false, \"message\": \"not implemented\"}").flush();
    }
}

class JsonResponseBody {
    @SuppressWarnings("WeakerAccess")
    public boolean ok;

    @SuppressWarnings("WeakerAccess")
    public String message;

    JsonResponseBody(boolean ok, String message) {
        this.ok = ok;
        this.message = message;
    }
}
