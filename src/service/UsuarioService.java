package service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import entities.User;
import persistence.IUseEntities;

public class UsuarioService implements IUseEntities<User>{

	public void findAll(ArrayList<User> users){
		users.forEach(u->{
			System.out.println(" ".repeat(10)+"Id : "+
					u.getUser_id()+" "+"Nombre: "+
					u.getUser_name()+" "+
					u.getUser_lastname()+" IDN: "+
					u.getUser_identity_number()+" Apertura: "+
					u.getUser_created_at());
		});
	}
	
	public void findById(int id, ArrayList<User> users) {
		
		var u = users.stream().filter(user->user.getUser_id()==id).collect(Collectors.toList());
		if(u!=null) {
			u.forEach(usuario->{
				String sexo = usuario.isUser_sex()?"Hombre":"Mujer";
				String ecivil = usuario.isUser_married()?"casado":"soltero";
				String estado = usuario.isUser_state()?"Activo":"No activo";
				System.out.println(" ".repeat(10)+"_____________Datos Del Cliente_________________");
				System.out.println();
				System.out.println(" ".repeat(10)+"Id      : "+usuario.getUser_id());
				System.out.println(" ".repeat(10)+"Nombre  : "+usuario.getUser_name());
				System.out.println(" ".repeat(10)+"Apellido: "+usuario.getUser_lastname());
				System.out.println(" ".repeat(10)+"DNI     : "+usuario.getUser_identity_number());
				System.out.println(" ".repeat(10)+"Username: "+usuario.getUser_username());
				System.out.println(" ".repeat(10)+"Creación: "+usuario.getUser_created_at());
				System.out.println(" ".repeat(10)+"E.Civil : "+ecivil);
				System.out.println(" ".repeat(10)+"Edad    : "+usuario.isUser_age());
				System.out.println(" ".repeat(10)+"Correo  : "+usuario.getUser_email());
				System.out.println(" ".repeat(10)+"Sexo    : "+ sexo);
				System.out.println(" ".repeat(10)+"Estado  : "+estado );
				System.out.println("_".repeat(58));
			});
		}
	}
		
	
	public ArrayList<User> save(User user, ArrayList<User> users) {
		// simula auto_increment
		int idUsuarioNuevo = users.size();
		idUsuarioNuevo++;
		user.setUser_id(idUsuarioNuevo);
		user.setUser_state(true);
		// se registra el nuevo usuario
		users.add(user);
		return users;
	}
	
	public ArrayList<User> delete(int id, ArrayList<User> users) {
		// busca el cliente
		boolean existe = users.stream().anyMatch(user->user.getUser_id()==id);
		if(existe) {
			for(int i=0; i<users.size(); i++) {
				if(users.get(i).getUser_id()==id) {
					users.get(i).setUser_state(false);
					System.out.println("Cliente id :"+id+" fue desactivado");
				}
			}
		}else {
			System.out.println("Cliente id :"+id+" no existe");
		}
		return users;		
	}
}
