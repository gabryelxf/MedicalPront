package servlet;

import com.google.gson.Gson;
import controller.PerfilPaciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TbPaciente;
import org.json.JSONObject;




@WebServlet(name = "ConsultarPacienteServlet", urlPatterns = {"/pacienteDados"})
public class ConsultarPacienteServlet extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response, String json)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.println(json); 
        }
    }


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, "");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
               
        String json = "";
        
        

        
        try {
            
            String json2 = request.getReader().lines().collect(Collectors.joining());
        JSONObject jsonObject = new JSONObject(json2);
        String value = jsonObject.getString("cpfPaciente");
        
            //String cpfPaciente = (String)request.getParameter("cpfPaciente");
            
            Connection con = dao.MySQL.getConnection();
            

            //String cpfPaciente = request.getParameter("cpfPaciente"); 
            System.out.println(value);
            
            PerfilPaciente perfl = new PerfilPaciente(value, con);
                
            TbPaciente paciente = perfl.consultarInfoPaciente();

            con.close();
            con = null; 
 
            json = new Gson().toJson(paciente, TbPaciente.class);
            
        } catch (Exception ex) {
            json = new Gson().toJson(ex);
        }
        
        processRequest(request, response, json);
        
    }

  
    @Override
    public String getServletInfo() {
        return "";
    }

}
