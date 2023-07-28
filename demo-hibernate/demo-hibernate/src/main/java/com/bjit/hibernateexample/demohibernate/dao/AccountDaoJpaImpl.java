package com.bjit.hibernateexample.demohibernate.dao;

import com.bjit.hibernateexample.demohibernate.model.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoJpaImpl implements AccountDao{
    @Autowired
    private EntityManager em;

    @Override
    public List<Account> findAll(){
        String jpql = "select c from Account c";
        TypedQuery<Account> query = em.createQuery(jpql, Account.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(Account account){
        em.persist(account);// works same as the "save()" function of CrudRepository, JpaRepository etc.
    }

    @Override
    public Account findById(Long id){
        return em.find(Account.class, id);
    }

    @Override
    public List<Account> findByFirstName(String name){
        TypedQuery<Account> query = em.createQuery("select a from Account a where a.firstName LIKE :name", Account.class).setParameter("name" , name);
        return query.getResultList();

        //return em.find(Account.class, name);
    }

//    @Override
//    @Transactional
//    public Account updateBalance(Account account, Long id){
//
//    }

}
