package api.model.projection;

import java.time.LocalDateTime;

import org.springframework.data.rest.core.config.Projection;

import api.model.EventLogger;
import api.model.enums.Level;

@Projection(name = "eventLoggerAllProjection", types = { EventLogger.class })
public interface EventLoggerAllProjection {
	
	Level getLevel();
	
	String getEventDescription();
	
	String getEventLogger();
	
	String getSource();
	
	LocalDateTime getDate();
	
	Integer getQuantity();

}
