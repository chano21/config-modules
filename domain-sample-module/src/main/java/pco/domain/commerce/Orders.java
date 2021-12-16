package pco.domain.commerce;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Orders extends BaseEntity {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@Column(name = "order_name")
	private String orderName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member")
	protected Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_product")
	protected OrderProduct orderProduct;
	
}