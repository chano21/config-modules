package pco.hibernate.listner;

import java.util.Arrays;

import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Component
public class UpdateListner implements PostUpdateEventListener {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean requiresPostCommitHanding(EntityPersister persister) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onPostUpdate(PostUpdateEvent event) {
		System.out.println("나오냐 "  +event.getEntity());
		
		if(event.getEntity().getClass().getSimpleName().equals("Member")) {
			Arrays.asList (event.getDirtyProperties()).
			forEach(p -> {
				System.out.println(p);
			});
			
//			System.out.println(event.getDirtyProperties()[0]);
//			System.out.println(event.getDirtyProperties()[1]);
//									
			Arrays.asList(event.getOldState()).forEach(System.out::println); 

		}else {
			
		}
		
	}


}