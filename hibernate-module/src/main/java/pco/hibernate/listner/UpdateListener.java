package pco.hibernate.listner;

import org.hibernate.event.spi.PostCommitUpdateEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Component

public class UpdateListener implements 
//PostUpdateEventListener {
PostCommitUpdateEventListener {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean requiresPostCommitHanding(EntityPersister persister) {
		// TODO Auto-generated method stub
		return false;
	}

	 
	@Override
	public void onPostUpdate(PostUpdateEvent event) {
		
		if(event.getEntity().getClass().getSimpleName().equals("Member")) {
			int dirtys[] =event.getPersister().findDirty(event.getOldState(),
					event.getState(), event.getEntity(), event.getSession());
			String fileds[] = event.getPersister().getPropertyNames();
			
			for(int i =0; i<dirtys.length; i++) {
				System.out.println(fileds[dirtys[i]] +": "
						+event.getPersister().getPropertyValue(event.getEntity() , dirtys[i]));
			}
		}
		
	}


	@Override
	public void onPostUpdateCommitFailed(PostUpdateEvent event) {
	
		System.out.println("실패");
	}

}