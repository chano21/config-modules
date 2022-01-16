package pco.domain.command;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UpdateMemberInfo {
	String name;
	String phoneNumber;
}
