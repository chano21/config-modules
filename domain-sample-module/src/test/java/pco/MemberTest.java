package pco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;

import pco.domain.commerce.Member;
import pco.domain.commerce.Product;
import pco.hibernate.HibernateListenerConfig;
import pco.hibernate.listner.UpdateListener;
import pco.jpa.JPAConfig;

@DataJpaTest
@ComponentScan(basePackageClasses= {UpdateListener.class})
@ContextConfiguration(classes = {JPAConfig.class,HibernateListenerConfig.class})
//@ContextConfiguration(classes = {JPAConfig.class})
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@Commit
public class MemberTest {

	@Autowired
	private EntityManager em;

		@Test
		@DisplayName("create member and is persist")
		@Order(1)
		public void testCreateEntitty() {
			Member member = Member.builder().memberName("테스트이름")
					.phoneNumber("01022223333").build();

			em.persist(member);

			assertEquals(true, em.contains(member));
		}

		@Test
		@DisplayName("dirty properties catch test")
		@Order(2)
		public void dirtyPropertiesTest() {

			Member member=	em.find(Member.class, Long.valueOf(1));
			
			assertEquals(true, em.contains(member));

			//member.changeMemberName("바꾼이름");
			member.changeMemberNameAndPhoneNumber("바꾼이름", "폰번호");
			System.out.println("변경완료");
		}

		@Test
		@DisplayName("change data test")
		@Order(3)
		public void changeDataTest() {

			Member member=	em.find(Member.class, Long.valueOf(1));
			
			assertEquals(true, em.contains(member));
			assertEquals("바꾼이름", member.getMemberName());
			
		}
		
		@Test
		@DisplayName("dirty properties not member catch test")
		@Order(4)
		public void dirtyPropertiesNotMemberTest() {

			
			Product product =Product.builder()
					.productName("상품")
					.build();
			
			em.persist(product);
			assertEquals(true, em.contains(product));
			product.changeProductName("바꾼이름");
			System.out.println("상품 변경완료");
		}
		
	
		
}
