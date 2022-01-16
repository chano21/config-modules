package pco.domain.commerce;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pco.domain.status.Status;

/**
 * @author ParkChano
 *
 * 2021. 6. 28.
 */
@MappedSuperclass
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	@CreatedDate
	public LocalDateTime createdDate;
	@LastModifiedDate
	public LocalDateTime modifiedDate;
	
	@Column(name = "author")
	public String author;
	@Column(name = "del")
	public Status.Del del;
}