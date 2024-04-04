package service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import entities.Account;
import entities.Bank;
import entities.Currencyy;
import entities.TypeOfAccount;
import entities.User;
import persistence.IUseEntities;

// Clase que proporciona servicios relacionados con las cuentas
public class CuentaService implements IUseEntities<Account> {

    // Método para encontrar todas las cuentas
    public void findAll(ArrayList<Account> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No hay cuentas registradas en el sistema.");
            return;
        }

        System.out.println("Listado de cuentas:");
        for (Account account : accounts) {
            printAccountInfo(account);
        }
    }

    // Método para encontrar una cuenta por su ID
    public void findById(int id, ArrayList<Account> accounts) {
        Account foundAccount = accounts.stream().filter(account -> account.getAccount_id() == id).findFirst()
                .orElse(null);
        if (foundAccount != null) {
            System.out.println("Datos de la cuenta con ID " + id + ":");
            printAccountInfo(foundAccount);
        } else {
            System.out.println("No se encontró ninguna cuenta con el ID proporcionado.");
        }
    }

    // Método para guardar una nueva cuenta
    public ArrayList<Account> save(Account account, ArrayList<Account> accounts) {
        // Simula auto_increment
        int newAccountId = accounts.size() + 1;
        account.setAccount_id(newAccountId);
        account.setAccount_state(true);
        accounts.add(account);
        System.out.println("Cuenta creada exitosamente con ID: " + newAccountId);
        return accounts;
    }

    // Método para eliminar una cuenta por su ID
    public ArrayList<Account> delete(int id, ArrayList<Account> accounts) {
        boolean removed = accounts.removeIf(account -> account.getAccount_id() == id);
        if (removed) {
            System.out.println("Cuenta con ID " + id + " eliminada correctamente.");
        } else {
            System.out.println("No se encontró ninguna cuenta con el ID proporcionado.");
        }
        return accounts;
    }

    // Método para componer entidades dentro de una cuenta
    public Account composeEntities(Account account, ArrayList<User> users, ArrayList<Bank> banks,
            ArrayList<TypeOfAccount> accountTypes, ArrayList<Currencyy> currencies) {

        account.setAccount_user(findEntityById(account.getAccount_user().getUser_id(), users));
        account.setAccount_bank_id(findEntityById(account.getAccount_bank_id().getBank_id(), banks));
        account.setAccount_type_id(findEntityById(account.getAccount_type_id().getToa_id(), accountTypes));
        account.setAccount_currency_id(findEntityById(account.getAccount_currency_id().getCurrency_id(), currencies));

        return account;
    }

    // Método genérico para buscar una entidad por su ID en una lista de entidades
    private <T> T findEntityById(int id, ArrayList<T> entities) {
        return entities.stream().filter(entity -> getId(entity) == id).findFirst().orElse(null);
    }

    // Método para obtener el ID de una entidad
    private <T> int getId(T entity) {
        if (entity instanceof User) {
            return ((User) entity).getUser_id();
        } else if (entity instanceof Bank) {
            return ((Bank) entity).getBank_id();
        } else if (entity instanceof TypeOfAccount) {
            return ((TypeOfAccount) entity).getToa_id();
        } else if (entity instanceof Currencyy) {
            return ((Currencyy) entity).getCurrency_id();
        }
        return -1;
    }

    // Método para imprimir la información de una cuenta
    private void printAccountInfo(Account account) {
        String status = account.isAccount_state() ? "Activa" : "Inactiva";
        System.out.println("ID: " + account.getAccount_id());
        System.out.println("Usuario: " + account.getAccount_user().getUser_name() + " "
                + account.getAccount_user().getUser_lastname());
        System.out.println("Número de cuenta: " + account.getAccount_number());
        System.out.println("Balance: " + account.getAccount_balance());
        System.out.println("Moneda: " + account.getAccount_currency_id().getCurrency_symbol());
        System.out.println("Apertura: " + account.getAccount_created_at());
        System.out.println("Tipo de cuenta: " + account.getAccount_type_id().getToa_name());
        System.out.println("Banco: " + account.getAccount_bank_id().getBank_nombre());
        System.out.println("Estado: " + status);
        System.out.println("-----------------------------------------------------");
    }
}
