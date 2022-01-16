package pco.domain.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pco.domain.Member;
import pco.domain.command.UpdateMemberInfo;

@Service
@RequiredArgsConstructor

public class MemberService {
//@Autowired
	private final EntityManager em;
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void changeMemberNameAndPhoneNumber(UpdateMemberInfo memberInfo) throws Exception{
		Member member=	
				em.find(Member.class, Long.valueOf(1));
		member.changeMemberNameAndPhoneNumber(memberInfo);
		throw new Exception();
	}
}
