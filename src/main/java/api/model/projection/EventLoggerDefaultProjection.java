package api.model.projection;

import java.time.LocalDateTime;

import org.springframework.data.rest.core.config.Projection;

import api.model.EventLogger;
import api.model.enums.Level;

@Projection(name = "eventLoggerDefaultProjection", types = { EventLogger.class })
public interface EventLoggerDefaultProjection {
	
	Level getLevel();
	
	String getEventDescription();
	
	String getSource();
	
	LocalDateTime getDate();
	
	Integer getQuantity();

}
