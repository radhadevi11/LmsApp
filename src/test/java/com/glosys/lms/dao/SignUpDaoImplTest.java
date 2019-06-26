package com.glosys.lms.dao;


import com.glosys.lms.SignUp;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class SignUpDaoImplTest {
    @InjectMocks
    @Spy
    private SignUpDaoImpl signUpDao ;

    @Ignore
    @Test
    public void testSave(){

        SignUp signUp = mock(SignUp.class);
        EntityManagerFactory entityManagerFactory = mock(EntityManagerFactory.class);
        EntityManager entityManager = mock(EntityManager.class);
        Persistence persistence = mock(Persistence.class);


        Mockito.doReturn(signUp).when(signUpDao).createObject(signUp);
        Mockito.doReturn(entityManagerFactory).when(persistence).createEntityManagerFactory("com.radha.lms");
        Mockito.doReturn(entityManager).when(entityManagerFactory).createEntityManager();
        Mockito.doNothing().when(entityManager).getTransaction().begin();
        Mockito.doNothing().when(entityManager).persist(signUp);
        Mockito.doNothing().when(entityManager).getTransaction().commit();

        signUpDao.save(signUp);

        Mockito.verify(persistence).createEntityManagerFactory("com.radha.lms");
        Mockito.verify(signUpDao).createObject(signUp);
        Mockito.verify(entityManagerFactory).createEntityManager();
        Mockito.verify(entityManager).getTransaction().begin();
        Mockito.verify(entityManager).getTransaction().commit();
        Mockito.verify(entityManager).persist(signUp);
    }

    @Test
    public void SaveTest2(){

        SignUpDaoImpl signUpDao = new SignUpDaoImpl();

        signUpDao.save(new SignUp("Srinivasan","T","radha@gmail.com","KEC","radha","radha"));
    }


}