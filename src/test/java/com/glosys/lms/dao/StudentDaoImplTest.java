package com.glosys.lms.dao;


import com.glosys.lms.entity.Student;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class StudentDaoImplTest {
    @InjectMocks
    @Spy
    private StudentDaoImpl signUpDao ;

    @Ignore
    @Test
    public void testSave(){

        Student student = mock(Student.class);
        EntityManagerFactory entityManagerFactory = mock(EntityManagerFactory.class);
        EntityManager entityManager = mock(EntityManager.class);
        Persistence persistence = mock(Persistence.class);


        Mockito.doReturn(entityManagerFactory).when(persistence).createEntityManagerFactory("com.radha.lms");
        Mockito.doReturn(entityManager).when(entityManagerFactory).createEntityManager();
        Mockito.doNothing().when(entityManager).getTransaction().begin();
        Mockito.doNothing().when(entityManager).persist(student);
        Mockito.doNothing().when(entityManager).getTransaction().commit();

        signUpDao.save(student);

        Mockito.verify(persistence).createEntityManagerFactory("com.radha.lms");

        Mockito.verify(entityManagerFactory).createEntityManager();
        Mockito.verify(entityManager).getTransaction().begin();
        Mockito.verify(entityManager).getTransaction().commit();
        Mockito.verify(entityManager).persist(student);
    }

    @Test
    public void SaveTest2(){

        StudentDaoImpl studentDao = new StudentDaoImpl();

        studentDao.save(new Student("Radha","Devi","Female","abc@gmail.com", "KEC", "radha"));
    }


}