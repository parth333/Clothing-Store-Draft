package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import dto.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public User getUser(String id) {
		String hql ="from User u where u.id=:id";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("id", id);
		return (User)query.getSingleResult();
		
	}

	@Override
	public List<User> getAllUser() {
		String hql = "from User";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> result = query.getResultList();
		return result ;
	}

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		
	}

	@Override
	public boolean delUser(String id) {
		String hql = "delet User u where u.id=:id";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("id", id);
		return(query.executeUpdate()>0);
	}

	@Override
	public boolean updateUser(User user) {
		String hql = "update User u set u.userName=:un, u.email=:um where u.id=:id";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("un", user.getUserName());
		query.setParameter("um", user.getEmail());
		query.setParameter("id", user.getId());
		return (query.executeUpdate()>0);
			
	}

}
