package pco.domain.commerce;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */

@Entity
@Table(name="order_product")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderProductId;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	private List<Orders> orders;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	private List<Product> products;


	
	public void changeOrder(Orders order){
		orders.add(order);
	}
		
	public void changeProduct(Product product){
		products.add(product);
	}
	
	
}