package wallet;

import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import entities.Account;
import entities.Bank;
import entities.Currencyy;
import entities.Transaction;
import entities.TypeOfAccount;
import entities.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main {

	private static Bank bank1;
	private static Currencyy currency1;
	private static Currencyy currency2;
	private static TypeOfAccount toa1;
	private static TypeOfAccount toa2;
	private static User user1;
	private static User user2;
	private static User user3;
	private static Account account1;
	private static Account account2;
	private static Account account3;
	private static Account account4;

	public static void main(String[] args) {

		// crea los objetos para contener datos
		creacionObjetosEntidades();

		// ingresa datos de prueba para las entidades involucradas
		poblarEntities();

		// simula tabla usuarios
		ArrayList<User> usuarios = new ArrayList<>();
		usuarios.add(user1);
		usuarios.add(user2);
		usuarios.add(user3);

		// simula tabla cuentas
		ArrayList<Account> cuentas = new ArrayList<>();
		cuentas.add(account1);
		cuentas.add(account2);
		cuentas.add(account3);
		cuentas.add(account4);
		
		// simula tabla bancos
		ArrayList<Bank> bancos = new ArrayList<>();
		bancos.add(bank1);
		
		// simula tabla monedas
		ArrayList<Currencyy> monedas = new ArrayList<>();
		monedas.add(currency1);
		monedas.add(currency2);
		
		// simula tabla tipos de cuentas
		ArrayList<TypeOfAccount> toas = new ArrayList<>();
		toas.add(toa1);
		toas.add(toa2);
		
		// simula tabla de transacciones
		ArrayList<Transaction> transacciones = new ArrayList<>();
		// simula auto_increment id transacciones
		int id_transacciones = 0;

		// lectura de datos desde teclado
		Scanner leeteclado = new Scanner(System.in);
		// loop principal
		String opcion = "";
		do {
			// menu principal
			menu();
			opcion = leeteclado.next();
			leeteclado.nextLine();

			switch (opcion) {
			case "1":
				listaSaldosDisponibles(usuarios, cuentas);
				break;
			case "2":
				mostrarHistorialTrf(transacciones);
				break;
			case "3":
				id_transacciones = transferenciasEntreCuentas(usuarios, cuentas, transacciones, leeteclado, id_transacciones);
				break;
			case "4":
				Mantenedor.menu(usuarios, cuentas, transacciones, bancos, toas, monedas);
				break;
			case "0":
				System.out.println("\nfin del programa");
				leeteclado.close();
				break;
			default:
				break;
			}
		} while (!opcion.equals("0"));
	}

	// creación de objetos para su populación
	public static void creacionObjetosEntidades() {
		// creacion de entidades
		// creacion de banco
		bank1 = new Bank();
		// creacion de currency
		currency1 = new Currencyy();
		currency2 = new Currencyy();
		// crear tipos de cuenta
		toa1 = new TypeOfAccount();
		toa2 = new TypeOfAccount();
		// creación de usuarios
		user1 = new User();
		user2 = new User();
		user3 = new User();
		// creación de cuentas
		account1 = new Account();
		account2 = new Account();
		account3 = new Account();
		account4 = new Account();
	}

	// generacion de transferencias
	public static int transferenciasEntreCuentas(ArrayList<User> usuarios, ArrayList<Account> cuentas, ArrayList<Transaction> transacciones, Scanner leeteclado, int id_transacciones){
		/*
		 * un usuario puede transferir dinero a otra cuenta un usuario puede transferir
		 * dinero entre sus cuentas si en la transferencia intervienen monedas distintas
		 * se solicita el factor de conversion las transferencias registran un id,
		 * fecha, los montos involucrados, origen y destino se puede agregar un
		 * comentario a la operación String.matches("[a-zA-Z ]+") do {
		 * System.out.println("Ingrese nombre del pais:");
		 * paises[indice]=tecladoScanner.next(); if(!soloLetras(paises[indice])) {
		 * System.out.println("Error: Debe ingresar sólo letras"); } } while
		 * (!soloLetras(paises[indice]));
		 */
		try {

			// almacenas los números de cuentas de los clientes
			ArrayList<Account> cuentasCliente = new ArrayList<>();
			// ciclo principal
			String continuar = null;
			// cuentas seleccionadas
			String nroCuentaOrigen, nroCuentaDestino;
			do {
				tituloTransferencias();
				// saldos
				float saldoOrigen = 0F;
				Account cuentaOrigen = new Account();
				float saldoDestino = 0F;
				Account cuentaDestino = new Account();
				// lista los clientes
				listaClientes(usuarios);

				// solicta el origen de los fondos en base a su ID
				System.out.print("- Ingrese el ID del cliente origen   : ");
				int id_origen = leeteclado.nextInt();
				leeteclado.nextLine();
				// muestra y cuentas las cuentas del origen
				cuentasCliente = listaCuentasCliente(usuarios, cuentas, id_origen);

				// si no retorna un único nro de cuenta pide el nro de cuentas
				if (cuentasCliente.size() > 1) {
					do {
						System.out.print("=> Es necesario especificar cual es nro cuenta de origen : ");
						nroCuentaOrigen = leeteclado.next().trim();
						// validar que exista la xuenta ingresada
						cuentaOrigen = validaCuenta(nroCuentaOrigen, cuentasCliente);
						if (cuentaOrigen != null) {
							break;
						} else {
							System.out.println("¡no existe la cuenta!, vuelva a intentar");
						}
					} while (true);

				} else {
					// toma la única cuenta almacenada
					cuentaOrigen = cuentasCliente.get(0);
				}
				// recupera saldo origen
				saldoOrigen = cuentaOrigen.getAccount_balance();

				// solicita el destino de los fondos
				System.out.print("- Ingrese el ID del cliente destino  : ");
				int id_destino = leeteclado.nextInt();
				leeteclado.nextLine();
				// muestra y cuentas las cuentas del distino
				cuentasCliente = listaCuentasCliente(usuarios, cuentas, id_destino);

				// si no retorna un çunico nro de cuenta pide el nro de cuentas
				if (cuentasCliente.size() > 1) {
					do {
						System.out.print("=> Es necesario especificar cual es nro cuenta de origen : ");
						nroCuentaDestino = leeteclado.next().trim();
						// validar que exista la xuenta ingresada
						cuentaDestino = validaCuenta(nroCuentaDestino, cuentasCliente);
						if (cuentaDestino != null) {
							break;
						} else {
							System.out.println("¡no existe la cuenta!, vuelva a intentar");
						}
					} while (true);

				} else {
					// toma la única cuenta almacenada
					cuentaDestino = cuentasCliente.get(0);
				}
				// extrae los tipos de monedas de la transacción
				String monedaOrigen = cuentaOrigen.getAccount_currency_id().getCurrency_symbol();
				String monedaDestino = cuentaDestino.getAccount_currency_id().getCurrency_symbol();
				// recupera saldo origen
				saldoDestino = cuentaDestino.getAccount_balance();
				// informa el saldo disponible
				System.out.println("Saldo disponible de cuenta origen: " + cuentaOrigen.getAccount_number()
						+ " $ " + saldoOrigen + " " + monedaOrigen);
				// si tiene saldo en cuenta para realizar transacciones
				if (saldoOrigen > 0) {
					// visualiza el saldo disponible de la cuenta origen
					float factorCambio = solicitaFactor(monedaOrigen, monedaDestino, leeteclado);
					// almacena monto a tranferir de la cuenta origen sin conversión
					float montoTransferir = solicitaMontoTransferir(monedaOrigen, leeteclado);
					// esto porque si la cuenta es de otra moneda, se debe rebajar sin cambios
					float montoTrfOrigen = montoTransferir;
					// aplica factor de cambio
					montoTransferir = montoTransferir * factorCambio;
					if (saldoOrigen >= montoTrfOrigen) {
						// informa el monto a transferir en la moneda de destino
						System.out.print("Se estan transferiendo " + montoTrfOrigen + " " + monedaOrigen);
						if (factorCambio != 1) {
							System.out.println(" -> con factor " + factorCambio + " -> equivale a " + montoTransferir + " "
									+ monedaDestino);
						} else {
							System.out.println();
						}
						// agrega comentario a la tansferencia
						System.out.print("\nAgregar un comentario : ");
						if (leeteclado.hasNext()) {
							leeteclado.nextLine();
						}
						String comentario = leeteclado.nextLine();
						// solicta fonfirmar transacción
						System.out.print("\nIngrese 's' para confirma la operación ? ");
						String confirmaOperacion = leeteclado.next();
						if (confirmaOperacion.equalsIgnoreCase("s")) {
							System.out.print("OK operación confirmada\n");
							saldoDestino += montoTransferir;
							saldoOrigen -= montoTrfOrigen;
							// actualiza saldo de las cuentas
							registraSaldoActualizadosDeFondos(cuentas, cuentaOrigen, saldoOrigen, cuentaDestino,
									saldoDestino);
							// registra la nueva transaccion
							id_transacciones++;
							transacciones.add(grabarTransaccion(montoTrfOrigen, montoTransferir, comentario,
									cuentaOrigen, cuentaDestino, id_transacciones));
							mensajeOperacionExitosa(cuentaOrigen, saldoOrigen, cuentaDestino, saldoDestino);
						}
					} else {
						System.out.print("El monto ingresado supera el saldo disponible");
					}
				} else {
					System.out.print("No cuenta con suficientes fondos para transferir");
				}
				do {
					System.out.print("\n" + "-".repeat(20) + "\n ¿ Desea realizar otra transferencia s/n ? ");
					continuar = leeteclado.next();
				} while (!continuar.equals("s") && !continuar.equals("n"));
			} while (!continuar.equalsIgnoreCase("n"));
		} catch (Exception e) {
			System.out.println("\n¡ Ha ocurrido un error al procesar los datos, la operación es cancelada !");
		}
		return id_transacciones;
	}
	
	
	// lista saldos disponibles de clientes
	public static void listaSaldosDisponibles(ArrayList<User> usuarios, ArrayList<Account> cuentas) {
		tituloSaldosCuentas();
		for (User user : usuarios) {
			System.out.println(user.getUser_name().toUpperCase() + " " + user.getUser_lastname().toUpperCase());
			listaCuentasCliente(usuarios, cuentas, user.getUser_id());
		}
	}

	// lista todos los clientes
	public static void listaClientes(ArrayList<User> usuarios) {
		usuarios.forEach(u->{
			System.out.println("  ID: " + u.getUser_id() + " Nombre: " + u.getUser_name() + " " + u.getUser_lastname());
		});
		System.out.println("=".repeat(140));
	}

	// lista las cuentas del usuario consultado
	public static ArrayList<Account> listaCuentasCliente(ArrayList<User> usuarios, ArrayList<Account> cuentas, int id) {
		ArrayList<Account> cuentasCliente = new ArrayList<>();
		System.out.println(".".repeat(140));
		System.out.print("    Cuentas del Usuario: ");
		usuarios.forEach(usuario->{
			if (usuario.getUser_id() == id) {
				System.out
				.println(usuario.getUser_name().toUpperCase() + " " + usuario.getUser_lastname().toUpperCase());
				cuentas.forEach(cuenta->{
					if (cuenta.getAccount_user().equals(usuario)) {
						System.out.println("    Nro: " + cuenta.getAccount_number() + " saldo disponible $ "
								+ cuenta.getAccount_balance() + " "
								+ cuenta.getAccount_currency_id().getCurrency_symbol());
						// si hay más de una cuenta del usuario no se devolvera ninguna de ellas
						cuentasCliente.add(cuenta);
					}				
				});
			}
		});

		System.out.println("_".repeat(140));
		return cuentasCliente;
	}

	// validación de cuenta
	public static Account validaCuenta(String nroCuentaDestino, ArrayList<Account> cuentasCliente) {
		for(int i=0; i<cuentasCliente.size(); i++) {
			if(cuentasCliente.get(i).getAccount_number().equals(nroCuentaDestino)) {
				System.out.println("*** cuenta validada OK");
				return cuentasCliente.get(i);
			}
		}
		return null;
	}

	// ingreso de factor de conversion de moneda
	public static float solicitaFactor(String monedaOrigen, String monedaDestino, Scanner leeteclado) {
		float factorCambio = 1f;
		if (!monedaOrigen.equals(monedaDestino)) {
			System.out.println("Esta transfiriendo de " + monedaOrigen + " -> " + monedaDestino);
			System.out.print("Debe ingresar el factor de conversión a moneda destino (" + monedaDestino + ")" + ": ");
			// pide factor de cambio de moneda
			factorCambio = leeteclado.nextFloat();
		}
		return factorCambio;
	}

	// ingreso monto de la transferencia
	public static float solicitaMontoTransferir(String monedaOrigen, Scanner leeteclado) {
		float montoTransferir = 0f;
		System.out.print("Ingrese el monto a transferir " + monedaOrigen + " $ ");
		montoTransferir = leeteclado.nextFloat();
		return montoTransferir;
	}

	public static Transaction grabarTransaccion(float montoTrfOrigen, float montoTransferir, String comentario,
			Account cuentaOrigen, Account cuentaDestino, int id_transacciones) {
		// genera nro transacciones
		int contadorTransacciones = 0;
		Random rand = new Random();
		contadorTransacciones = rand.nextInt(1000000000);
		Transaction trf = new Transaction();
		
		trf.setTr_id(id_transacciones);
		trf.setTr_amount_sender(montoTrfOrigen);
		trf.setTr_amount_receiver(montoTransferir);
		trf.setTr_date(new Date());
		trf.setTr_detail(comentario);
		trf.setTr_number(String.valueOf(contadorTransacciones));
		trf.setTr_receiver_account_id(cuentaDestino);
		trf.setTr_sender_account_id(cuentaOrigen);
		trf.setTr_state(true);
		return trf;
	}

	public static void registraSaldoActualizadosDeFondos(ArrayList<Account> cuentas, Account cuentaOrigen, float saldoOrigen,
			Account cuentaDestino, float saldoDestino) {
		// actualizar los saldos de las cuentas involucradas
		for (Account c : cuentas) {
			if (c.getAccount_number().equals(cuentaOrigen.getAccount_number())) {
				c.setAccount_balance(saldoOrigen);
			}
			if (c.getAccount_number().equals(cuentaDestino.getAccount_number())) {
				c.setAccount_balance(saldoDestino);
			}
		}
	}

	// lista transferencias realizadas
	public static void mostrarHistorialTrf(ArrayList<Transaction> transacciones) {
		// Formatea la fecha con nombres de día y mes
		System.out.println("\n" + "*".repeat(140));
		System.out.println(" ".repeat(20) + "HISTORIAL DE TRANSACCIONES");
		System.out.println("-".repeat(140));
		if (transacciones.size() > 0) {
			for (Transaction trf : transacciones) {
				String formattedDate = new SimpleDateFormat("EEEE dd 'de' MMMM 'de' yyyy", Locale.getDefault())
						.format(trf.getTr_date());
				System.out.println(" " + trf.getTr_sender_account_id().getAccount_user().getUser_name() + " "
						+ formattedDate + " id:" + trf.getTr_number() + " "
						+ trf.getTr_sender_account_id().getAccount_number() + " -> "
						+ trf.getTr_receiver_account_id().getAccount_number() + " " + trf.getTr_amount_sender() + " "
						+ trf.getTr_sender_account_id().getAccount_currency_id().getCurrency_symbol() + " -> "
						+ trf.getTr_amount_receiver() + " "
						+ trf.getTr_receiver_account_id().getAccount_currency_id().getCurrency_symbol() + " "
						+ trf.getTr_detail());
			}
		} else {
			System.out.println("No existen registros de transacciones que mostrar");
		}
		System.out.println("-".repeat(140));
	}

	public static void mensajeOperacionExitosa(Account cuentaOrigen, float saldoOrigen, Account cuentaDestino,
			float saldoDestino) {
		System.out.println("=".repeat(140));
		System.out.println("*** operación exitosa ***");
		System.out.println("obs: se muestras ambos saldos como testeo");
		System.out.println("El nuevo saldo cuenta origen : " + cuentaOrigen.getAccount_number() + " $ " + saldoOrigen);
		// check
		System.out
				.println("El nuevo saldo cuenta destino: " + cuentaDestino.getAccount_number() + " $ " + saldoDestino);
	}

	public static void menu() {
		System.out.println("\n");
		System.out.println("MENU-".repeat(30));
		System.out.println(" ".repeat(140));
		System.out.println(" ".repeat(20) + " MENU DE PRUEBA DE PROCESOS");
		System.out.println(" ".repeat(20) + "=".repeat(40));
		System.out.println(" ".repeat(20) + " 1 Saldos Disponibles de Cuentas");
		System.out.println(" ".repeat(20) + " 2 Historial de Transacciones");
		System.out.println(" ".repeat(20) + " 3 Transferencias entre Cuentas");
		System.out.println(" ".repeat(20) + " 4 Mantenedor");
		System.out.println(" ".repeat(20) + " 0 Finalizar");
		System.out.println(" ".repeat(20) + "=".repeat(40));
		System.out.print(" ".repeat(20) + "   Opción ? ");
	}

	public static void tituloTransferencias() {
		System.out.println("\n");
		System.out.println(" ".repeat(20) + "TRANSFERENCIAS ENTRE CUENTAS DE USUARIOS");
		System.out.println("=".repeat(140));
		System.out.println("Clientes Habilitados");
		System.out.println("-".repeat(140));
	}

	public static void tituloSaldosCuentas() {
		System.out.println("\n");
		System.out.println(" ".repeat(20) + "SALDOS DISPONIBLES DE CUENTAS");
		System.out.println("-".repeat(140));
	}

	public static void poblarEntities() {

		user1.setUser_id(1);
		user1.setUser_name("braulio");
		user1.setUser_lastname("valdes");
		user1.setUser_identity_number("15200300-5");
		user1.setUser_username("brauliomariano");
		user1.setUser_password_hash("12345");
		user1.setUser_created_at(new Date());
		user1.setUser_married(true);
		user1.setUser_age((short) 55);
		user1.setUser_email("braulio@mail.com");
		user1.setUser_has_contact(false);
		user1.setUser_sex(true);
		user1.setAddress(null);
		user1.setUser_state(true);

		user2.setUser_id(2);
		user2.setUser_name("marcela");
		user2.setUser_lastname("campos");
		user2.setUser_identity_number("10200300-4");
		user2.setUser_username("marcelacampos");
		user2.setUser_password_hash("12345");
		user2.setUser_created_at(new Date());
		user2.setUser_married(true);
		user2.setUser_age((short) 31);
		user2.setUser_email("marcela@mail.com");
		user2.setUser_has_contact(false);
		user2.setUser_sex(false);
		user2.setAddress(null);
		user2.setUser_state(true);

		user3.setUser_id(3);
		user3.setUser_name("isabel");
		user3.setUser_lastname("muller");
		user3.setUser_identity_number("23200000-1");
		user3.setUser_username("isabelmuller");
		user3.setUser_password_hash("12345");
		user3.setUser_created_at(new Date());
		user3.setUser_married(false);
		user3.setUser_age((short) 27);
		user3.setUser_email("isabel@mail.com");
		user3.setUser_has_contact(false);
		user3.setUser_sex(false);
		user3.setAddress(null);
		user3.setUser_state(true);

		bank1 = new Bank(1, "Banco de Chile", true);

		currency1 = new Currencyy(1, "Pesos Chilenos", "CLP", true);
		currency2 = new Currencyy(2, "Dolares Americanos", "USD", true);

		toa1 = new TypeOfAccount(1, "cuenta vista", true);
		toa2 = new TypeOfAccount(1, "cuenta en dolares", true);

		account1.setAccount_id(1);
		account1.setAccount_user(user1);
		account1.setAccount_balance(1000000);
		account1.setAccount_bank_id(bank1);
		account1.setAccount_currency_id(currency1);
		account1.setAccount_type_id(toa1);
		account1.setAccount_number("100-111-001");
		account1.setAccount_created_at(new Date());
		account1.setAccount_state(true);

		account2.setAccount_id(2);
		account2.setAccount_user(user2);
		account2.setAccount_balance(1000000);
		account2.setAccount_bank_id(bank1);
		account2.setAccount_currency_id(currency1);
		account2.setAccount_type_id(toa1);
		account2.setAccount_number("200-222-002");
		account2.setAccount_created_at(new Date());
		account2.setAccount_state(true);

		account3.setAccount_id(3);
		account3.setAccount_user(user3);
		account3.setAccount_balance(1000000);
		account3.setAccount_bank_id(bank1);
		account3.setAccount_currency_id(currency1);
		account3.setAccount_type_id(toa1);
		account3.setAccount_number("505-522-003");
		account3.setAccount_created_at(new Date());
		account3.setAccount_state(true);

		account4.setAccount_id(4);
		account4.setAccount_user(user1);
		account4.setAccount_balance(10000);
		account4.setAccount_bank_id(bank1);
		account4.setAccount_currency_id(currency2);
		account4.setAccount_type_id(toa2);
		account4.setAccount_number("105-722-001");
		account4.setAccount_created_at(new Date());
		account4.setAccount_state(true);
	}

}
