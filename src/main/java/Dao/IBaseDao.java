package Dao;

import java.util.List;

import entities.Student;

public interface IBaseDao<K,O> {
	public List<O> getAll();
	public boolean addNew(O o);
	public Student find_by_id(K id);
	public boolean update(O o);
	public boolean remove(K id);
}
