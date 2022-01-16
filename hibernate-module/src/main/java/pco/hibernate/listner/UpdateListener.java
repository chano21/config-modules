package pco.hibernate.listner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Component
public class UpdateListener implements  PostUpdateEventListener {

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
			System.out.println("///////////////1");
			Arrays.asList(event.getOldState()).forEach(System.out::println); 
			System.out.println("///////////////2");
			Arrays.asList(event.getState()).forEach(System.out::println); 
			System.out.println("///////////////3");
			Arrays.asList(event.getEntity().getClass().getDeclaredFields()).forEach(System.out::println);
			Arrays.asList(event.getEntity().getClass().getSuperclass().getDeclaredFields()).forEach(System.out::println);
			
			System.out.println("///////////////4");
			Arrays.asList(event.getDirtyProperties()).forEach(System.out::println);
			System.out.println("///////////////5");
	
			System.out.println("///////////////6");
			int dirtys[] =event.getPersister().findDirty(event.getOldState(),
					event.getState(), event.getEntity(), event.getSession());
			String fileds[] = event.getPersister().getPropertyNames();
			
			for(int i =0; i<dirtys.length; i++) {
				System.out.println(fileds[dirtys[i]] +": "
						+event.getPersister().getPropertyValue(event.getEntity() , dirtys[i]));
			}
		}
		
	}
	
//	@PostUpdate
//	 public void hello(Object member) {
//		 System.out.println("포스트 "  +member);
//	 }


}