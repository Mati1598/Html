package servlets;

import models.Resultat;
import tools.repository.BrukerRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResultatServlet", urlPatterns = {"/ResultatServlet"})
public class ResultatServlet extends AbstractAppServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fornavn = request.getParameter("firstName");
        String etternavn = request.getParameter("lastName");
        String test1 = request.getParameter("username");
        String test2 = request.getParameter("password");
        //int test3 = request.getParameter("test3");

        Resultat resultat = new Resultat();
        resultat.setFornavn(fornavn);
        resultat.setEtternavn(etternavn);
        resultat.setTest1(test1);
        resultat.setTest2(test2);
        //resultat.setTest3(test3);

        try (PrintWriter out = response.getWriter()) {
            BrukerRepo.addResultat(resultat, out);


            RequestDispatcher dispatcher = request.getRequestDispatcher("/Suksess.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
