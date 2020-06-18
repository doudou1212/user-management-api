package com.autraining.user.management.service;

import com.autraining.user.management.Fixture;
import com.autraining.user.management.model.Consumer;
import com.autraining.user.management.repository.ConsumerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.PersistenceException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationServiceImplTest {
    @Mock
    private ConsumerRepository consumerRepository;

    @InjectMocks
    private ApplicationServiceImpl applicationService;

    @Nested
    class FindConsumerById {
        @Test
        public void shouldGetConsumerById() {
            Integer consumerId = 1;
            Consumer mockConsumer = Fixture.mockConsumer(consumerId);
            when(consumerRepository.findConsumerById(consumerId))
                    .thenReturn(Fixture.mockConsumer(consumerId));

            Consumer consumer = applicationService.findConsumerById(consumerId);

            assertThat(consumer).isEqualToComparingFieldByField(mockConsumer);
        }
    }

    @Nested
    class CreateConsumer {

        private CreateConsumerRequest request;

        @BeforeEach
        public void setUp() {
            Integer consumerId = 1;
            Consumer mockConsumer = Fixture.mockConsumer(consumerId);
            request = new CreateConsumerRequest(mockConsumer.getName(), mockConsumer.getAge(), mockConsumer.getEmail());
        }

        @Test
        public void shouldCreateConsumer() {
            Integer consumerId = 1;
            Consumer mockConsumer = Fixture.mockConsumer(consumerId);
            when(consumerRepository.save(any(Consumer.class)))
                    .thenReturn(mockConsumer);
            Integer createdConsumerId = applicationService.createConsumer(request);

            assertThat(createdConsumerId).isEqualTo(mockConsumer.getId());
        }

        @Test
        public void shouldThrowErrorWhenCreateConsumerFailed() {
            when(consumerRepository.save(any(Consumer.class))).thenThrow(new PersistenceException());

            assertThatThrownBy(() -> applicationService.createConsumer(request)).isInstanceOf(RuntimeException.class);
        }
    }

    @Nested
    class UpdateConsumerById {
        Integer consumerId = 1;
        private CreateConsumerRequest request;
        private Consumer mockConsumer;

        @BeforeEach
        public void setUp() {
            mockConsumer = Fixture.mockConsumer(consumerId);
            request = new CreateConsumerRequest(mockConsumer.getName(), mockConsumer.getAge(), mockConsumer.getEmail());
        }

        @Test
        public void shouldUpdateConsumer() {
            when(consumerRepository.save(any(Consumer.class)))
                    .thenReturn(mockConsumer);
            Consumer updatedConsumer = applicationService.updateConsumerById(request, consumerId);

            assertThat(updatedConsumer).isEqualToComparingFieldByField(updatedConsumer);
        }

        @Test
        public void shouldThrowErrorWhenCreateConsumerFailed() {
            when(consumerRepository.save(any(Consumer.class))).thenThrow(new PersistenceException());

            assertThatThrownBy(() -> applicationService.updateConsumerById(request, consumerId)).isInstanceOf(RuntimeException.class);
        }
    }
}
