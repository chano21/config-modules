package pco.domain.commerce;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
@Entity
@Table(name = "member")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "orders")
public class Member extends BaseEntity
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	
	@Column(nullable = false)
	private String memberName;
	
	

	@Column(nullable = true)
	private String memberEmail;
	
//	@Builder.Default
	@OneToMany(mappedBy = "member",fetch = FetchType.LAZY)
//	private List<Orders> orders = new ArrayList<>();
	private List<Orders> orders;

	
	@Column(nullable = false)
	private String phoneNumber;



	public void changeMemberName(String name){
		this.memberName=new String(name);
	}


	public void changeMemberNameAndPhoneNumber(String name,String phoneNumber){
		this.memberName=name;
		this.phoneNumber =phoneNumber;
	}

	
	public void changeOrder(Orders order){
		orders.add(order);
		order.member=this;		
	}
}