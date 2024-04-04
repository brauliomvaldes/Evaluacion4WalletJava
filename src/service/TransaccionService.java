package service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import entities.Transaction;
import persistence.IUseEntities;

public class TransaccionService implements IUseEntities<Transaction>{

	public void findAll(ArrayList<Transaction> transactions){
		transactions.forEach(t->{
			System.out.println(t.getTr_id()+" "+
								t.getTr_date()+" "+"Nº : "+
								t.getTr_number()+" "+
								t.getTr_sender_account_id().getAccount_number()+"->"+
								t.getTr_receiver_account_id().getAccount_number()+" "+
								t.getTr_amount_sender()+" "+
								t.getTr_receiver_account_id().getAccount_currency_id().getCurrency_symbol());
		});
	}
	
	public void findById(int id, ArrayList<Transaction> transactions) {
		var t = transactions.stream().filter(trf->trf.getTr_id()==id).collect(Collectors.toList());
		if(t!=null) {
			t.forEach(trf->{
				String estado = trf.isTr_state()?"Activo":"No activo";
				System.out.println("_____________Datos De La Transacción_________________");
				System.out.println();
				System.out.println("Id              : "+trf.getTr_id());
				System.out.println("Núumero Trf     : "+trf.getTr_number());
				System.out.println("Cuenta Origen   : "+trf.getTr_sender_account_id().getAccount_number());
				System.out.println("Monto Enviado   : "+trf.getTr_amount_sender());
				System.out.println("Moneda          : "+trf.getTr_sender_account_id().getAccount_currency_id().getCurrency_symbol());
				System.out.println("Cuenta Destino  : "+trf.getTr_receiver_account_id().getAccount_number());
				System.out.println("Monto Recibido  : "+trf.getTr_amount_receiver());
				System.out.println("Moneda          : "+trf.getTr_receiver_account_id().getAccount_currency_id().getCurrency_symbol());
				System.out.println("fecha           : "+trf.getTr_date());
				System.out.println("Detalle         : "+trf.getTr_detail());
				System.out.println("Estado          : "+estado);
				System.out.println("_____________________________________________________");
			});
		}
	}
	
	public ArrayList<Transaction> save(Transaction Transaction, ArrayList<Transaction> transactions) {
		return transactions;
	}
	
	public ArrayList<Transaction> delete(int id, ArrayList<Transaction> transactions) {
		return transactions;
	}
}
