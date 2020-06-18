package api.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import api.model.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class EventLogger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreatedDate
    private LocalDateTime createdAt;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Level level;
	
	@NotBlank
	@Size(max = 255)
	private String eventDescription;
	
	@NotBlank
	private String eventLogger;
	
	@NotBlank
	@Size(max = 150)
	private String source;
	
	@NotNull
	private LocalDateTime date;
	
	@NotNull
	private Integer quantity;

}
