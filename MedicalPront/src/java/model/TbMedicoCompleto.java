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
public class TbMedicoCompleto {
  public String crmMedico; 
  public String nomeMedico; 
  public Date dataNascimentoMedico;
  public String naturalidadeMedico; 
  public List<TbAnamnese> anammneses = new ArrayList();
  
}
