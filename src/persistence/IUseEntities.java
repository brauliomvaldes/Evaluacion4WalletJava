package persistence;

import java.util.ArrayList;

public interface IUseEntities<T>{

	void findAll(ArrayList<T> t);
	
	void findById(int id, ArrayList<T> t);
	
	ArrayList<T> save(T trf, ArrayList<T> t);
	
	ArrayList<T> delete(int id, ArrayList<T> t);
}
