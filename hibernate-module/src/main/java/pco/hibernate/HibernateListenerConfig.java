package pco.hibernate;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.context.annotation.Configuration;

import pco.hibernate.listner.UpdateListener;

@Configuration
public class HibernateListenerConfig {

  private final UpdateListener entityUpdateEventListener;

  @PersistenceUnit
  private EntityManagerFactory emf;

  public HibernateListenerConfig(UpdateListener entityUpdateEventListener) {
      this.entityUpdateEventListener = entityUpdateEventListener;
  }

  @PostConstruct
  protected void init() {
      SessionFactoryImpl sessionFactory = emf.unwrap(SessionFactoryImpl.class);
      EventListenerRegistry registry = sessionFactory.getServiceRegistry()
    		  .getService(EventListenerRegistry.class);
      
//      registry.getEventListenerGroup(EventType.POST_UPDATE)
//      .appendListener(entityUpdateEventListener);

      registry
      
      .appendListeners(EventType.POST_UPDATE, entityUpdateEventListener);

      
  }
}