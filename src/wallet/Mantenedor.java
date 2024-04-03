package wallet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import entities.Account;
import entities.Bank;
import entities.Currencyy;
import entities.Transaction;
import entities.TypeOfAccount;
import entities.User;
import service.Cuentas;
import service.Transacciones;
import service.Usuarios;

public final class Mantenedor {

	public static final void menu(ArrayList<User> usuarios, 
								  ArrayList<Account> cuentas,
								  ArrayList<Transaction> transacciones,
								  ArrayList<Bank> bancos,
								  ArrayList<TypeOfAccount> toas,
								  ArrayList<Currencyy> monedas
			) {
		Scanner leeteclado = new Scanner(System.in);
		String opcion;
		do {
			// menu mantención de registros

			menuMantenedor();

			opcion = leeteclado.next();
			leeteclado.nextLine();

			switch (opcion) {
			case "1":
				mantenedorUsuarios(usuarios, leeteclado);
				break;
			case "2":
				mantenedorCuentas(cuentas, usuarios, bancos, toas, monedas, leeteclado);
				break;
			case "3":
				mantenedorTransacciones(transacciones, leeteclado);
				break;
			case "0":
				break;
			}

		} while (!opcion.equals("0"));
		return;
	}

	public static void mantenedorUsuarios(ArrayList<User> usuarios, Scanner leeteclado) {
		String opcion;
		int id;
		Usuarios usu = new Usuarios();
		do {
			// menu
			mantenedor("USUARIOS");
			opcion = leeteclado.next();
			leeteclado.nextLine();

			switch (opcion) {
			case "1":
				tituloUsuarios();
				usu.findAll(usuarios);
				break;
			case "2":
				System.out.print(" ".repeat(10)+"\nIngrese ID Usuario : ");
				id = leeteclado.nextInt();
				usu.findById(id, usuarios);
				break;
			case "3":
				// simula recepcion de datos del clientes
				User usuario = ingresoDeDatosCliente(leeteclado);
				usuarios = usu.save(usuario, usuarios);
				System.out.println("\nNuevo usuario creado existosamente !!\n");
				break;
			case "4":
				System.out.print("\nIngrese ID Usuario a desactivar: ");
				id = leeteclado.nextInt();
				usuarios = usu.delete(id, usuarios);
				break;
			}
		} while (!opcion.equals("0"));
	};

	public static void mantenedorCuentas(ArrayList<Account> cuentas,
										 ArrayList<User> usuarios,
										 ArrayList<Bank> bancos,
										 ArrayList<TypeOfAccount> toas,
										 ArrayList<Currencyy> monedas,
										 Scanner leeteclado) {
		String opcion;
		Cuentas ctas = new Cuentas();
		do {
			mantenedor("CUENTAS");
			opcion = leeteclado.next();
			leeteclado.nextLine();

			switch (opcion) {
			case "1":
				tituloCuentas();
				ctas.findAll(cuentas);
				break;
			case "2":
				System.out.print(" ".repeat(10)+"\nIngrese ID Cuenta : ");
				int id = leeteclado.nextInt();
				ctas.findById(id, cuentas);
				break;
			case "3":
				// simula recepcion de datos de la cuenta
				Account cuenta = ingresoDeDatosCuentaNueva(leeteclado);
				// composicion de entidades en cuenta
				cuenta = ctas.composicionDeEntidades(cuenta, usuarios, bancos, toas, monedas);
				cuentas = ctas.save(cuenta, cuentas);
				System.out.println("\nNueva cuenta creada existosamente !!\n");
				break;
			case "4":
				System.out.print("Ingrese ID Cuenta a desactivar: ");
				id = leeteclado.nextInt();
				cuentas = ctas.delete(id, cuentas);
				break;
			}
		} while (!opcion.equals("0"));
	};

	public static void mantenedorTransacciones(ArrayList<Transaction> transacciones, Scanner leeteclado) {
		String opcion;
		Transacciones trf = new Transacciones();
		do {
			// menu
			mantenedor("TRANSACCIONES");
			opcion = leeteclado.next();
			leeteclado.nextLine();

			switch (opcion) {
			case "1":
				tituloTransacciones();
				trf.findAll(transacciones);
				break;
			case "2":
				System.out.print(" ".repeat(10)+"\nIngrese ID Transacción : ");
				int id = leeteclado.nextInt();
				trf.findById(id, transacciones);
				break;
			case "3":
				System.out.println("\nLo siento, en proceso de implementación !!\n");
				break;
			case "4":
				System.out.println("\nLo siento, en proceso de implementación !!\n");
				break;
			}
		} while (!opcion.equals("0"));
	};

	
	public static User ingresoDeDatosCliente(Scanner leeteclado) {
		
		System.out.println("\n"+"*".repeat(140));
		System.out.println(" ".repeat(10)+"Ingreso de Datos del Cliente");
		System.out.println("-".repeat(140));
		System.out.print(" ".repeat(10)+"Nombre           : ");
		String user_name = leeteclado.next();
		System.out.print(" ".repeat(10)+"Apellido         : ");
		String user_lastname = leeteclado.next();
		System.out.print(" ".repeat(10)+"DNI              : ");
		String user_identity_number = leeteclado.next();
		System.out.print(" ".repeat(10)+"Username         : ");
		String user_username = leeteclado.next();
		System.out.print(" ".repeat(10)+"Password         : ");
		String user_password_hash = leeteclado.next();
		System.out.print(" ".repeat(10)+"E.Civil c=casado : ");
		String ecivil = leeteclado.next();
		System.out.print(" ".repeat(10)+"Edad             : ");
		int user_age = leeteclado.nextInt();
		System.out.print(" ".repeat(10)+"Correo           : ");
		String user_email = leeteclado.next();
		System.out.print(" ".repeat(10)+"Sexo    h=hombre : ");
		String sexo = leeteclado.next();
		System.out.println("_".repeat(140));
		User usuario = new User();
		
		boolean user_married = ecivil.equals("c")?true:false;
		boolean user_sex = sexo.equals("h")?true:false;
		
		usuario.setUser_id(0);
		usuario.setUser_name(user_name);
		usuario.setUser_lastname(user_lastname);
		usuario.setUser_identity_number(user_identity_number);
		usuario.setUser_email(user_email);
		usuario.setUser_username(user_username);
		usuario.setUser_password_hash(user_password_hash);
		usuario.setUser_created_at(new Date());
		usuario.setUser_age((short)user_age);
		usuario.setUser_sex(user_sex);
		usuario.setUser_married(user_married);
		usuario.setUser_has_contact(false);
		usuario.setUser_state(false);
		usuario.setAddress(null);
		return usuario;
	}
	
	public static Account ingresoDeDatosCuentaNueva(Scanner leeteclado){
		
		System.out.println("\n"+"|".repeat(140));
		System.out.println(" ".repeat(10)+"Ingreso de Datos de la Cuenta");
		System.out.println("-".repeat(140));
		System.out.print(" ".repeat(10)+"User id           : ");
		int account_user=leeteclado.nextInt();
		System.out.print(" ".repeat(10)+"Número Cuenta     : ");
		String account_number=leeteclado.next();
		System.out.print(" ".repeat(10)+"Balance inicial   : ");
		float account_balance=leeteclado.nextFloat();
		System.out.print(" ".repeat(10)+"Ide de moneda     : ");
		int account_currency_id=leeteclado.nextInt(); 
		System.out.print(" ".repeat(10)+"Id Tipo de Cuenta : ");
		int account_type_id=leeteclado.nextInt();
		System.out.print(" ".repeat(10)+"Id Banco          : ");
		int account_bank_id=leeteclado.nextInt();
		System.out.println("-".repeat(140));
		
		// creación de objetos que componen la cuenta según el ingreso de sus id
		User usuario = new User();
		usuario.setUser_id(account_user);
		Currencyy moneda = new Currencyy();
		moneda.setCurrency_id(account_currency_id);
		TypeOfAccount toa = new TypeOfAccount();
		toa.setToa_id(account_type_id);
		Bank banco = new Bank();
		banco.setBank_id(account_bank_id);
		
		Date account_created_at=new Date();
		
		// creación del objeto
		Account cuenta = new Account();
		// se ingresa el id como id de cuenta
		cuenta.setAccount_id(account_user);
		cuenta.setAccount_user(usuario); 
		cuenta.setAccount_number(account_number); 
		cuenta.setAccount_balance(account_balance); 
		cuenta.setAccount_currency_id(moneda); 
		cuenta.setAccount_created_at(account_created_at); 
		cuenta.setAccount_type_id(toa); 
		cuenta.setAccount_bank_id(banco); 
		cuenta.setAccount_state(false);
		
		return cuenta;
	}
	
	public static void menuMantenedor() {
		System.out.println("\n" + " ".repeat(140));
		System.out.println("M-".repeat(70));
		System.out.println();
		System.out.println(" ".repeat(20) + " MENU MENTENEDOR");
		System.out.println(" ".repeat(20) + "=".repeat(40));
		System.out.println(" ".repeat(20) + " 1 Usuarios");
		System.out.println(" ".repeat(20) + " 2 Cuentas");
		System.out.println(" ".repeat(20) + " 3 Transacciones");
		System.out.println(" ".repeat(20) + " 0 Finalizar");
		System.out.println(" ".repeat(20) + "=".repeat(40));
		System.out.print(" ".repeat(20) + "   Opción ? ");
	}

	public static void mantenedor(String proceso) {
		System.out.println("\n" + proceso.substring(0, 1).repeat(140));
		System.out.println();
		System.out.println(" ".repeat(20) + " MENU MENTENEDOR "+proceso);
		System.out.println(" ".repeat(20) + "=".repeat(40));
		System.out.println(" ".repeat(20) + " 1 Lista Todo");
		System.out.println(" ".repeat(20) + " 2 Busca por Id");
		System.out.println(" ".repeat(20) + " 3 Crea");
		System.out.println(" ".repeat(20) + " 4 Desactivar");
		System.out.println(" ".repeat(20) + " 0 Elimina por Id");
		System.out.println(" ".repeat(20) + "=".repeat(40));
		System.out.print(" ".repeat(20) + "   Opción ? ");
	}

	public static void tituloUsuarios() {
		System.out.println("\n" + "U".repeat(140));
		System.out.println(" ".repeat(10)+"Lista todos los Usuarios");
		System.out.println("\n" + "U".repeat(140));
	}

	public static void tituloCuentas() {
		System.out.println("\n" + "C".repeat(140));
		System.out.println(" ".repeat(10)+"Lista todas las Cuenta de Usuarios");
		System.out.println("\n" + "C".repeat(140));
	}

	public static void tituloTransacciones() {
		System.out.println("\n" + "T".repeat(140));
		System.out.println("Lista todos las Transacciones");
		System.out.println("\n" + "T".repeat(140));
	}

}
