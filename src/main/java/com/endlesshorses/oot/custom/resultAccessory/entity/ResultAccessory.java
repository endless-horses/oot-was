package com.endlesshorses.oot.custom.resultAccessory.entity;

import com.endlesshorses.oot.custom.accessory.enity.Accessory;
import com.endlesshorses.oot.custom.result.entity.Result;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class ResultAccessory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="RESULT_ID")
	private Result result;

	@ManyToOne
	@JoinColumn(name = "ACCESSORY_ID")
	private Accessory accessory;

	@CreatedDate
	private LocalDateTime createdAt;

}
