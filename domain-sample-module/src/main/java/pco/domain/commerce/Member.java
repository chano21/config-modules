package pco.domain.commerce;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pco.domain.command.UpdateMemberInfo;

@Entity
@Table(name = "member")
@Builder
@Getter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	
	@Column(nullable = false)
	private String memberName;
	
	

	@Column(nullable = true)
	private String memberEmail;

	
	@Column(nullable = false)
	private String phoneNumber;

	public void changeMemberNameAndPhoneNumber(UpdateMemberInfo memberInfo){
		this.memberName=memberInfo.getName();
		this.phoneNumber =memberInfo.getPhoneNumber();
	}

}