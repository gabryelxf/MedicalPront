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
public class TbProntuario {
    public int idProntuario;
    public List<TbExames> exames = new ArrayList();
    public List<TbAnamnese> anamneses = new ArrayList();
    public String descricaoProntuario;
}
