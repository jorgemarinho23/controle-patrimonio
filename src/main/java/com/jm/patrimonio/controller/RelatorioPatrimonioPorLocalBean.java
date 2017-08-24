package com.jm.patrimonio.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

import com.jm.patrimonio.dao.PatrimonioDAO;
import com.jm.patrimonio.dao.LocalDAO;
import com.jm.patrimonio.modelo.Patrimonio;
import com.jm.patrimonio.modelo.Local;

@Named
@ViewScoped
public class RelatorioPatrimonioPorLocalBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Patrimonio> patrimonios;
	private Local localSelecionado;
	private List<Local> locais;
	
	@Inject
	private PatrimonioDAO patrimonioDAO;
	@Inject
	private LocalDAO localDAO;
	
	public void buscarPorLocal(){
		this.patrimonios = patrimonioDAO.buscarPorLocal(localSelecionado);
	}
	
	
@PostConstruct
    public void iniciar(){
	this.locais = localDAO.buscarTodos();
    }
	public Local getLocalSelecionado() {
		return localSelecionado;
	}

	public void setLocalSelecionado(Local localSelecionado) {
		this.localSelecionado = localSelecionado;
	}


	public List<Patrimonio> getPatrimonios() {
		return patrimonios;
	}


	public List<Local> getLocais() {
		return locais;
	}
	
	public void posProcessarXls(Object documento) {
		HSSFWorkbook planilha = (HSSFWorkbook) documento;
		HSSFSheet folha = planilha.getSheetAt(0);
		HSSFRow cabecalho = folha.getRow(0);
		HSSFCellStyle estiloCelula = planilha.createCellStyle();
		Font fonteCabecalho = planilha.createFont();
		
		fonteCabecalho.setColor(IndexedColors.WHITE.getIndex());
		fonteCabecalho.setBold(true);
		fonteCabecalho.setFontHeightInPoints((short) 16);
		
		estiloCelula.setFont(fonteCabecalho);
		estiloCelula.setFillForegroundColor(IndexedColors.BLACK.getIndex());
		estiloCelula.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		
		for (int i = 0; i < cabecalho.getPhysicalNumberOfCells(); i++) {
			cabecalho.getCell(i).setCellStyle(estiloCelula);
		}
	}
}
