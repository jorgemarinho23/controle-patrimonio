package com.jm.patrimonio.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;







import com.jm.patrimonio.dao.PatrimonioDAO;
import com.jm.patrimonio.modelo.Patrimonio;
import com.jm.patrimonio.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Patrimonio.class)
public class PatrimonioConverter implements Converter {

	private PatrimonioDAO patrimonioDAO;
	
	public PatrimonioConverter() {
		this.patrimonioDAO = CDIServiceLocator.getBean(PatrimonioDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Patrimonio retorno = null;

		if (value != null) {
			retorno = this.patrimonioDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Patrimonio) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}
