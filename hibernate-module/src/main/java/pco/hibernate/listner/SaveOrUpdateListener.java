package pco.hibernate.listner;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Component
public class SaveOrUpdateListener implements SaveOrUpdateEventListener {

	@Override
	public void onSaveOrUpdate(SaveOrUpdateEvent event) throws HibernateException {
		// TODO Auto-generated method stub
		//System.out.println(event.getEntityName());
		if(event.getEntityName().equals("Member")) {
//			event.getEntry().
//			event.getEntry().getPersister().findModified(null, null, event, null)
//			
//			event.getEntry().getPersister().findDirty(null, null, event, null)
		}
	}

	

}