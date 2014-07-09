package com.ssh.demo.dao;

import java.sql.SQLException;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ssh.demo.dto.UserQueryDTO;
import com.ssh.demo.entity.User;
import com.ssh.demo.utils.Page;

//持久层:负责映射对象及对象关系,都实现公共的接口
@SuppressWarnings("unchecked")
public class UserDAO extends HibernateDaoSupport implements IUserDAO
{
	//private SessionFactory sessionFactory;
	public void saveUser(User user){
		//没有整合Spring之前
//		 Session session = sessionFactory.getCurrentSession();
//		 Transaction tx = session.beginTransaction();
//		 try {
//			session.save(user);
//			tx.commit();
//		} catch (Exception ex) {
//			tx.rollback();
//			ex.printStackTrace();
//		}
		
		//整合Spring之后
		getHibernateTemplate().save(user);
	}
	
	public void updateUser(User user){
		getHibernateTemplate().update(user);
	}
	
	public void deleteUser(User user){
		getHibernateTemplate().delete(user);
		
	}
	
	public User findUserById(Long id){
		User user = getHibernateTemplate().get(User.class, id);
		return user;
	}
	
	public List<User> findAllUsers(){
		List<User> userLists =  getHibernateTemplate().find("from User");
		return userLists;
	}

	@Override
	public Page<User> findUsers(final UserQueryDTO qdto, final int page, final int rows, String sidx, String sord) {
		//声明2条HQL语句
		//1.用于查询结果总记录数的HQL，如果总记录数为0的时候,就没必要执行第2条hql语句的查询
		StringBuilder countHQLString = new StringBuilder();
		countHQLString.append("select count(*) from User user");
		countHQLString.append(" WHERE (:userName IS NULL OR LOWER(user.userName) LIKE :userName)");
        //countHQLString.append(" and (:userName IS NULL OR LOWER(user.createDate) >= :date)");
		final String countString = countHQLString.toString();
		
		//2.用于查询结构集的HQL
		StringBuilder hqlStringBuilder = new StringBuilder();
        hqlStringBuilder.append("from User user");
        hqlStringBuilder.append(" WHERE (:userName IS NULL OR LOWER(user.userName) LIKE :userName)");
        //hqlStringBuilder.append(" and (:userName IS NULL OR LOWER(user.createDate) >= :date)");
        hqlStringBuilder.append(" ORDER BY user."+sidx+" "+sord);

        final String hqlString = hqlStringBuilder.toString();
        
        
        //1.查询符合条件的记录数
        List<?> countList = (List<?>) getHibernateTemplate().execute(new HibernateCallback() 
        {
            public Object doInHibernate(Session hibernateSession) throws HibernateException, SQLException
            {
                Query query = hibernateSession.createQuery(countString);
                query.setParameter("userName", qdto.getUserName() == null ? null : "%" +  qdto.getUserName() + "%");

                return query.list();
            }
        });
        
        long totalCount = (Long) countList.get(0);
        //当记录数为0直接return没必要执行第2条hql语句的查询
//        if (totalCount < 1) {
//            return Page.EMPTY_PAGE;
//        }
        
        final int startIndex = Page.getStartIndex(page, rows);
        
		List<User> usetsList = (List) getHibernateTemplate().execute(new HibernateCallback() 
        {
            public Object doInHibernate(Session hibernateSession) throws HibernateException, SQLException
            {
                Query query = hibernateSession.createQuery(hqlString);
              
                query.setParameter("userName", qdto.getUserName() == null ? null : "%" +  qdto.getUserName() + "%");
//                query.setParameter("date", qdto.getDate() == null ? null : qdto.getDate());
               // return query.list();
                //实现分页查询：按照开始记录到最大记录数返回结果集（性能优化考虑）
                return query.setFirstResult(startIndex).setMaxResults(rows).list();
            }
        });
        
		System.out.println(usetsList.size());
		return new Page<User>(page, rows, totalCount, usetsList);
	}
	
	
	
}
