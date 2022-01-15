package pco.hibernate;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import pco.hibernate.listner.UpdateListner;

@Configuration
public class HibernateListenerConfig {

  private final UpdateListner entityUpdateEventListener;

  @PersistenceUnit
  private EntityManagerFactory emf;

  public HibernateListenerConfig(UpdateListner entityUpdateEventListener) {
      this.entityUpdateEventListener = entityUpdateEventListener;
  }

  @PostConstruct
  protected void init() {
      SessionFactoryImpl sessionFactory = emf.unwrap(SessionFactoryImpl.class);
      EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
      	
      registry.getEventListenerGroup(EventType.POST_UPDATE)
      .appendListener(entityUpdateEventListener);
     
  }
}