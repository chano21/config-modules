package pco.domain.service;

import java.util.Optional;

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
	public void changeMemberNameAndPhoneNumber(UpdateMemberInfo memberInfo,Long memberId) throws Exception{
		Member member=	
				Optional.ofNullable(em.find(Member.class, Long.valueOf(memberId)))
				.orElseThrow(() -> new Exception());
		member.changeMemberNameAndPhoneNumber(memberInfo);
	}
}
