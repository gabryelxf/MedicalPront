/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabryel
 */
public class TbAnamnese {
    public int idAnamnese;
    public String descricaoBasicaAnamnese;
    public String descricaoCompletaAnamnese;
    public List<TbPrescricoes> prescricoes = new ArrayList();
    public List<TbAtestados> atestados = new ArrayList();
    public List<TbCidSubCategoria> cid = new ArrayList();
    public TbMedico medico = new TbMedico();
    
}
