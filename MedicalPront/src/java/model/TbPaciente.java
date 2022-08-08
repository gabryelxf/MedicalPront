/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabryel
 */
public class TbPaciente {
   
   public String cpfPaciente;
    public String nomePaciente;
    public String emailPaciente;
    public Date dataNascimentoPaciente;
    public String telefonePaciente;
    public List<TbProntuario> prontuarios = new ArrayList();
    
}
