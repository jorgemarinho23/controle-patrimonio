package com.jm.patrimonio.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jm.patrimonio.dao.LocalDAO;
import com.jm.patrimonio.modelo.Local;
import com.jm.patrimonio.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Local.class)
public class LocalConverter implements Converter {

	private LocalDAO localDAO;
	
	public LocalConverter() {
		this.localDAO = CDIServiceLocator.getBean(LocalDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Local retorno = null;

		if (value != null) {
			retorno = this.localDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Local) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}
}

