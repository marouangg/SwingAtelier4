package ma.idao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import ma.entitie.Produit;
import ma.util.HibernateUtile;

public class DaoProduit implements Idao<Produit> {

	@Override
	public List<Produit> getAll() {
		Session session = HibernateUtile.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		List<Produit> prods = session.createQuery("from Produit").getResultList();

		t.commit();
		session.close();

		return prods;
	}

	@Override
	public Produit getOne(int id) {
		
		Session session = HibernateUtile.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		Produit produit = session.get(Produit.class, id);

		t.commit();
		session.close();

		return produit;
	}

	@Override
	public boolean save(Produit obj) {
		try {
			Session session = HibernateUtile.getSessionFactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			Object o = session.save(obj);

			System.out.println(o);

			t.commit();
			session.close();

			if (o == null)
				return false;
			else
				return true;

		} catch (Exception e) {
			return false;
		}
}

	@Override
	public boolean update(Produit obj) {
		try {
			Session session = HibernateUtile.getSessionFactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.update(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(Produit obj) {
		try {
			Session session = HibernateUtile.getSessionFactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.delete(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

}
