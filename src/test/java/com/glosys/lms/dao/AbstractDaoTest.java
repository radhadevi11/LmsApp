package com.glosys.lms.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDaoTest {
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("lms-app-test");
}
