package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Parcela;

public class ContratoService {
	
	private PagamentoOnlineService pOn;

	public ContratoService(PagamentoOnlineService pOn) {
		this.pOn = pOn;
	}
	
	//metodo que realiza o processamento do contrato
	public void processaContrato(Contrato contrato, int meses) {
		double quotaBasica = contrato.getValorTotal() / meses;
		
		for(int i = 1; i <= meses;i++) {
			Date date = addMeses(contrato.getData(), i);
			double quotaAtualizada = quotaBasica + pOn.valorParcelas(quotaBasica, i);
			double quotaTotal = quotaAtualizada + pOn.valor(quotaAtualizada);
			contrato.addParcela( new Parcela(date, quotaTotal));
		}
	}
	
	private Date addMeses(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

}
