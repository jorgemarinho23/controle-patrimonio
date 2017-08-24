package com.jm.patrimonio.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jm.patrimonio.dao.TipoDAO;
import com.jm.patrimonio.modelo.Tipo;
import com.jm.patrimonio.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Tipo.class)
public class TipoConverter implements Converter {

	private TipoDAO tipoDAO;
	
	public TipoConverter() {
		this.tipoDAO = CDIServiceLocator.getBean(TipoDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Tipo retorno = null;

		if (value != null) {
			retorno = this.tipoDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Tipo) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}
}


