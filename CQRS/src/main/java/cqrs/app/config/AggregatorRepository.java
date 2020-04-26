package cqrs.app.config;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cqrs.app.aggregate.Aggregator;

@Configuration
public class AggregatorRepository {

	@Bean
	public EventSourcingRepository<Aggregator> accountAggregateEventSourcingRepository(EventStore eventStore) {
		return EventSourcingRepository.builder(Aggregator.class).eventStore(eventStore).build();
	}
}
