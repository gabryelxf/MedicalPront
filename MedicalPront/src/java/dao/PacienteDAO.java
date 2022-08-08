/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
public class PacienteDAO {

    public TbPaciente consultarInfoPaciente(String cpfPaciente, Connection con) {
       TbPaciente paciente = new TbPaciente();
        try{
            String sql = "SELECT cpfPaciente, dataNascimentoPaciente, emailPaciente, nomePaciente, telefonePaciente FROM tb_paciente WHERE cpfPaciente = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpfPaciente);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                paciente.cpfPaciente = rs.getString(1);
                paciente.dataNascimentoPaciente= rs.getDate(2);
                paciente.emailPaciente = rs.getString(3);
                paciente.nomePaciente = rs.getString(4);
                paciente.telefonePaciente = rs.getString(5);
            }
            
            
        }catch(Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
        
        return paciente;
    }

    public List<TbExames> consultarExames(int idProntuario, Connection con) {
        List<TbExames> exames = new ArrayList();
        try{
            String sql = "SELECT idExame, descricaoExame, obsExame, dataExame FROM tb_exames WHERE cod_idProntuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProntuario);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                TbExames exame = new TbExames();
                exame.idExame = rs.getInt(1);
                exame.descricaoExame = rs.getString(2);
                exame.obsExame = rs.getString(3);
                exame.dataExame = rs.getDate(4);
                exames.add(exame);
            }
        }catch(Exception ex){
           System.out.println(ex.getLocalizedMessage()); 
        }
        
        return exames;
    }

    public List<TbProntuario> consultarProntuarios(String cpfPaciente, Connection con) {
        List<TbProntuario> prontuarios = new ArrayList();
        try{
            String sql = "SELECT idProntuario, descricaoProntuario FROM tb_prontuario WHERE cod_cpfPaciente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpfPaciente);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                TbProntuario prontuario = new TbProntuario();
                
                prontuario.idProntuario = rs.getInt(1);                
                prontuario.descricaoProntuario = rs.getString(2);
                
                prontuarios.add(prontuario);            }
        }catch(Exception ex){
           System.out.println(ex.getLocalizedMessage()); 
        }
        
        return prontuarios;
    }

    public List<TbAnamnese> consultarAnamnese(int idProntuario, Connection con) {
        List<TbAnamnese> anamneses = new ArrayList();
        try{
            String sql = "SELECT idAnamnese, descricaoBasicaAnamnese, descricaoCompletaAnamnese, med.crmMedico, med.dataNascimentoMedico,  "
                    + "med.naturalidadeMedico, med.nomeMedico FROM tb_anamnese AS an  INNER JOIN tb_medico AS med  "
                    + "ON med.crmMedico = an.cod_crmMedico WHERE cod_idProntuario = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProntuario);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                TbAnamnese anamnese = new TbAnamnese();
                anamnese.idAnamnese = rs.getInt(1);
                anamnese.descricaoBasicaAnamnese  = rs.getString(2);
                anamnese.descricaoCompletaAnamnese = rs.getString(3);
                anamnese.medico.crmMedico = rs.getString(4);
                anamnese.medico.dataNascimentoMedico = rs.getDate(5);
                anamnese.medico.naturalidadeMedico = rs.getString(6);
                anamnese.medico.nomeMedico = rs.getString(7);
                anamneses.add(anamnese);
                     }
        }catch(Exception ex){
           System.out.println(ex.getLocalizedMessage()); 
        }
        
        return anamneses;
    }

    public List<TbAtestados> consultarAtestados(int idAnamnese, Connection con) {
        List<TbAtestados> atestados = new ArrayList();
        try{
            String sql = "SELECT idAtestado, descricaoAtestado, cod_idAnamnese FROM tb_atestados WHERE  cod_idAnamnese = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAnamnese);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
               TbAtestados atestado =  new TbAtestados();
               atestado.idAtestado = rs.getInt(1);
               atestado.descricaoAtestado = rs.getString(2);
               atestados.add(atestado);
               
            }
        }catch(Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
        
        return atestados;
    }

    public List<TbPrescricoes> consultarPrescricoes(int idAnamnese, Connection con) {
         List<TbPrescricoes> prescricoes = new ArrayList();
        try{
            String sql = "SELECT id_prescricoes, descricaoPrescricao, cod_idAnamnese FROM tb_prescricoes WHERE  cod_idAnamnese = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAnamnese);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
               TbPrescricoes prescricao =  new TbPrescricoes();
               
               prescricao.id_prescricoes = rs.getInt(1);
               prescricao.descricaoPrescricao = rs.getString(2);
               
               prescricoes.add(prescricao);
               
            }
        }catch(Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
        
        return prescricoes;
    }

    public List<TbCidSubCategoria> consultarCid(int idAnamnese, Connection con) {
        List<TbCidSubCategoria> cids = new ArrayList();
        try{
            String sql = "SELECT cid.id, cid.descricao from ta_cid_anamnese AS ta INNER JOIN tb_anamnese AS an ON an.idAnamnese = ta.cod_Anamnese  INNER JOIN tb_cid_sub_categoria AS cid ON cid.id = ta.cod_cid_sub_categoria "
                    + "WHERE cod_Anamnese = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAnamnese);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
               TbCidSubCategoria cid =  new TbCidSubCategoria();
               
               cid.id = rs.getString(1);
               cid.descricao = rs.getString(2);
               
               cids.add(cid);
               
            }
        }catch(Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
        
        return cids;
    }
    
}
