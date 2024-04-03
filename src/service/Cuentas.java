package service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import entities.Account;
import entities.Bank;
import entities.Currencyy;
import entities.TypeOfAccount;
import entities.User;
import persistence.IUseEntities;

public class Cuentas implements IUseEntities<Account>{

	public void findAll(ArrayList<Account> accounts){
		accounts.forEach(a->{
			System.out.println("Id: "+a.getAccount_id()+" "+"Cuenta Nº "
									+a.getAccount_number()+" Balance: "
									+a.getAccount_balance()+" "
									+a.getAccount_currency_id().getCurrency_symbol()
									+" Apertura: "+a.getAccount_created_at());
		});
	}
	
	public void findById(int id, ArrayList<Account> accounts) {
		var a = accounts.stream().filter(account->account.getAccount_id()==id).collect(Collectors.toList());
		if(a!=null) {
			a.forEach(cuenta->{
				String estado = cuenta.isAccount_state()?"Activo":"No activo";
				System.out.println("_____________Datos De La Cuenta_________________");
				System.out.println();
				System.out.println("Id      : "+cuenta.getAccount_id());
				System.out.println("Usuario : "+cuenta.getAccount_user().getUser_name()+" "+cuenta.getAccount_user().getUser_lastname());
				System.out.println("Número  : "+cuenta.getAccount_number());
				System.out.println("Balance : "+cuenta.getAccount_balance());
				System.out.println("Moneda  : "+cuenta.getAccount_currency_id().getCurrency_symbol());
				System.out.println("Apertura: "+cuenta.getAccount_created_at());
				System.out.println("Tipo    : "+cuenta.getAccount_type_id().getToa_name());
				System.out.println("Banco   : "+cuenta.getAccount_bank_id().getBank_nombre());
				System.out.println("Estado  : "+estado);
				System.out.println("________________________________________________");
			});
		}
	}
	
	public ArrayList<Account> save(Account account, ArrayList<Account> accounts) {
		// simula auto_increment
		int idCuentaNueva = accounts.size();
		idCuentaNueva++;	
		account.setAccount_id(idCuentaNueva);
		account.setAccount_state(true);
		// se registra el nuevo usuario
		
		accounts.add(account);
		return accounts;
	}
	
	public ArrayList<Account> delete(int id, ArrayList<Account> accounts) {
		// busca la cuenta
		boolean existe = accounts.stream().anyMatch(a->a.getAccount_id()==id);
		if(existe) {
			for(int i=0; i<accounts.size(); i++) {
				if(accounts.get(i).getAccount_id()==id) {
					accounts.get(i).setAccount_state(false);
					System.out.println("Cuenta id :"+id+" fue desactivada");
				}
			}
		}else {
			System.out.println("Cuentas id :"+id+" no existe");
		}
		return accounts;
	}
	
	// composicion de entidades dentro de cuenta
	public Account composicionDeEntidades(Account cuenta,
			 						ArrayList<User> usuarios,
			 						ArrayList<Bank> bancos,
			 						ArrayList<TypeOfAccount> toas,
			 						ArrayList<Currencyy> monedas) {

		// recupera id usuario para buscar y asignar a la cuenta
		int idUsuario = cuenta.getAccount_user().getUser_id();
		User usuario = usuarios.stream().filter(u->u.getUser_id()==idUsuario).collect(Collectors.toList()).get(0);
		cuenta.setAccount_user(usuario);
		
		// recupera id banco para buscar y asignar a la cuenta
		int idBanco = cuenta.getAccount_bank_id().getBank_id();
		Bank banco = bancos.stream().filter(b->b.getBank_id()==idBanco).collect(Collectors.toList()).get(0);
		cuenta.setAccount_bank_id(banco);
		
		// recupera id tipo de cuenta para buscar y asignar a la cuenta
		int idToa = cuenta.getAccount_type_id().getToa_id();
		TypeOfAccount toa = toas.stream().filter(t->t.getToa_id()==idToa).collect(Collectors.toList()).get(0);
		cuenta.setAccount_type_id(toa);
		
		// recupera id moneda para buscar y asignar a la cuenta
		int idMoneda = cuenta.getAccount_currency_id().getCurrency_id();
		Currencyy moneda = monedas.stream().filter(c->c.getCurrency_id()==idMoneda).collect(Collectors.toList()).get(0);
		cuenta.setAccount_currency_id(moneda);
		
		return cuenta;
	}
}
