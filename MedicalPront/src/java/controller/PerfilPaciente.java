/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PacienteDAO;
import java.sql.Connection;
import java.util.List;
import model.TbAnamnese;
import model.TbAtestados;
import model.TbCidSubCategoria;
import model.TbExames;
import model.TbPaciente;
import model.TbPrescricoes;
import model.TbProntuario;

/**
 *
 * @author Gabryel
 */
public class PerfilPaciente {
  
    private String cpfPaciente;
    private Connection con;
    private PacienteDAO dao = new PacienteDAO();
    
    public  PerfilPaciente(String cpfPaciente, Connection con){
        this.cpfPaciente = cpfPaciente;
        this.con = con;
    }
    
    
    public TbPaciente consultarInfoPaciente(){
        TbPaciente paciente = dao.consultarInfoPaciente(cpfPaciente, con);
                
        paciente.prontuarios = consultarProntuarios();
        
        for( TbProntuario prontuario : paciente.prontuarios){
            prontuario.exames = consultarExames(prontuario.idProntuario);
            prontuario.anamneses = consultarAnamnese(prontuario.idProntuario);
        }
        
         return paciente;
    }
    
    private List<TbProntuario> consultarProntuarios(){
        
        
        
        return dao.consultarProntuarios(cpfPaciente, con);
        
    }
    
    private List<TbExames> consultarExames(int idProntuario){
        
        return dao.consultarExames(idProntuario, con);
        
    }
    
     private List<TbAnamnese> consultarAnamnese(int idProntuario){
       List<TbAnamnese> anamneses = dao.consultarAnamnese(idProntuario, con);
       for(TbAnamnese anamnese : anamneses){
           
         anamnese.prescricoes = consultarPrescricoes(anamnese.idAnamnese);
         anamnese.atestados = consultarAtestados(anamnese.idAnamnese);
         anamnese.cid = consultarCids(anamnese.idAnamnese);
           
       }
           
       
       return anamneses;
        
    }

    private List<TbPrescricoes> consultarPrescricoes(int idAnamnese) {
       return dao.consultarPrescricoes(idAnamnese, con);
    }
    
    private List<TbAtestados> consultarAtestados(int idAnamnese) {
       return dao.consultarAtestados(idAnamnese, con);
    }
    
    private List<TbCidSubCategoria> consultarCids(int idAnamnese) {
       return dao.consultarCid(idAnamnese, con);
    }

    
    
    
    
    
    
}
