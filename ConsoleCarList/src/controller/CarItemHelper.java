package controller;
//Cassandra Wruck

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CarItem;

public class CarItemHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleCarList");

	//adding an item
	public void insertItem(CarItem ca) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ca);
		em.getTransaction().commit();

		em.close();
	}
	
	//showing all entries
	public List<CarItem> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<CarItem> allItems = em.createQuery("SELECT i FROM CarItem i").getResultList();
		return allItems;
	}
	
	//deleting an item
	public void deleteItem(CarItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<CarItem> typedQuery = em.createQuery(
				"select ca from CarItem ca where ca.make = :selectedMake and ca.year = :selectedYear and ca.model = :selectedModel",
				CarItem.class);

		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		typedQuery.setParameter("selectedModel", toDelete.getModel());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		CarItem result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	
	//search for make
	public List<CarItem> searchForItemByMake(String makeName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarItem> typedQuery = em.createQuery("select	ca from CarItem	ca	where ca.make	=	:selectedMake", CarItem.class);
		typedQuery.setParameter("selectedMake", makeName);
		List<CarItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	//search for years
	public List<CarItem> searchForItemByYear(String year) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarItem> typedQuery = em
				.createQuery("select ca from CarItem ca	where ca.year = :selectedYear", CarItem.class);
		typedQuery.setParameter("selectedYear", year);
		List<CarItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	//search for model
	public List<CarItem> searchForItemByModel(String modelName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarItem> typedQuery = em.createQuery("select	ca from CarItem	ca	where ca.model =	:selectedModel", CarItem.class);
		typedQuery.setParameter("selectedModel", modelName);
		List<CarItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	
	//editing make
	public CarItem searchForItemById(int IdToEdit) {
		//TODO	Auto-generated	method	stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CarItem found = em.find(CarItem.class, IdToEdit);
		em.close();
		return found;
	}
	
	//editing model
	public void updateModel(CarItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	//clean up
	public	void	cleanUp(){
		emfactory.close();
	}

}
