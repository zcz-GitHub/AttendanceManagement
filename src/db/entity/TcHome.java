package db.entity;
// Generated 2015-12-16 20:34:33 by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Tc.
 * @see db.entity.Tc
 * @author Hibernate Tools
 */
public class TcHome {

	private static final Log log = LogFactory.getLog(TcHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}
	
	  public Transaction createTransaction() {
	        return sessionFactory.getCurrentSession().beginTransaction();
	    }
	  
	public void persist(Tc transientInstance) {
		log.debug("persisting Tc instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Tc instance) {
		log.debug("attaching dirty Tc instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tc instance) {
		log.debug("attaching clean Tc instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Tc persistentInstance) {
		log.debug("deleting Tc instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tc merge(Tc detachedInstance) {
		log.debug("merging Tc instance");
		try {
			Tc result = (Tc) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tc findById(db.entity.TcId id) {
		log.debug("getting Tc instance with id: " + id);
		try {
			Tc instance = (Tc) sessionFactory.getCurrentSession().get("db.entity.Tc", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Tc instance) {
		log.debug("finding Tc instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("db.entity.Tc")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	/**
	 * 根据主键中的某一个键值来查询
	 * @param idName 键值对名称
	 * @param idValue 键值对的值
	 * @return 查询出符合要求的List
	 */
	public List findByNo(String idName,String idValue){
		String hql = "";
		if (idName.equals("tno")){
			hql = "from Tc tc where tc.id.tno=:id";
		}else if (idName.equals("cno")){
			hql = "from Tc tc where tc.id.cno=:id";
		}
		Query query = sessionFactory.getCurrentSession().
				createQuery(hql);
		query.setParameter("id", idValue);
		List result = query.list();
		if (result == null){
			log.debug("get successful, no instance found");
		} else {
			log.debug("get successful, instance found");
		}
		return result;
	}

	
}
