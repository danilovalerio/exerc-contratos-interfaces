package model.services;

public class PayPalService implements PagamentoOnlineService {
	
	private static final double OPERACAO_PORCENTAGEM = 0.02;
	private static final double MONTANTE_MENSAL = 0.01;

	@Override
	public double valor(double valor) {
		return valor * OPERACAO_PORCENTAGEM;
	}

	@Override
	public double valorParcelas(double valor, int meses) {
		return valor * MONTANTE_MENSAL * meses;
	}

}
