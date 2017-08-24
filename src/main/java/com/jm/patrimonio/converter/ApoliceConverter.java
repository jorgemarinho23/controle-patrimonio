package com.jm.patrimonio.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jm.patrimonio.dao.ApoliceSeguroDAO;
import com.jm.patrimonio.modelo.ApoliceSeguro;
import com.jm.patrimonio.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=ApoliceSeguro.class)
public class ApoliceConverter implements Converter {

	private ApoliceSeguroDAO apoliceSeguroDAO;
	
	public ApoliceConverter() {
		this.apoliceSeguroDAO = CDIServiceLocator.getBean(ApoliceSeguroDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ApoliceSeguro retorno = null;

		if (value != null) {
			retorno = this.apoliceSeguroDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((ApoliceSeguro) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}
