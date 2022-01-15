package pco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;

import pco.domain.commerce.Member;
import pco.hibernate.HibernateListenerConfig;
import pco.jpa.JPAConfig;

@DataJpaTest
@ComponentScan(basePackageClasses= {HibernateListenerConfig.class})
@ContextConfiguration(classes = {JPAConfig.class,HibernateListenerConfig.class})
@Commit
public class MemberTest {

	@Autowired
	private EntityManager em;

		@Test
		@DisplayName("create member and is persist")
		public void testCreateEntitty() {
			Member member = Member.builder().memberName("테스트이름")
					.phoneNumber("01022223333").build();

			em.persist(member);

			assertEquals(true, em.contains(member));
		}

		@Test
		@DisplayName("dirty properties catch test")
		public void dirtyPropertiesTest() {

			Member member=	em.find(Member.class, Long.valueOf(1));
			
			assertEquals(true, em.contains(member));

			member.changeMemberName("바꾼이름");
			System.out.println("변경완료");
		}

		@Test
		@DisplayName("change data test")
		public void changeDataTest() {

			Member member=	em.find(Member.class, Long.valueOf(1));
			
			assertEquals(true, em.contains(member));
			assertEquals("바꾼이름", member.getMemberName());
			
		}
	
		
}
