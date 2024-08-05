package com.fiap.tc.adapter.repository.output;

import br.com.six2six.fixturefactory.Fixture;
import com.fiap.tc.adapter.repository.OrderPaymentRepository;
import com.fiap.tc.adapter.repository.OrderRepository;
import com.fiap.tc.adapter.repository.entity.OrderEntity;
import com.fiap.tc.adapter.repository.entity.OrderPaymentEntity;
import com.fiap.tc.core.domain.exception.NotFoundException;
import com.fiap.tc.core.domain.requests.OrderPaymentRequest;
import com.fiap.tc.util.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegisterPaymentOutputAdapterTest extends BaseTest {

    public static final UUID UUID = java.util.UUID.randomUUID();

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderPaymentRepository orderPaymentRepository;

    @InjectMocks
    private RegisterPaymentOutputAdapter registerPaymentOutputAdapter;

    private OrderEntity orderEntity;

    private OrderPaymentEntity orderPaymentEntity;

    private OrderPaymentRequest requestSuccess;

    private OrderPaymentRequest requestError;

    @BeforeEach
    public void setUp() {
        orderEntity = Fixture.from(OrderEntity.class).gimme("valid");
        orderPaymentEntity = Fixture.from(OrderPaymentEntity.class).gimme("valid");
        requestSuccess = Fixture.from(OrderPaymentRequest.class).gimme("valid");
        requestError = Fixture.from(OrderPaymentRequest.class).gimme("error");
    }


    @Test
    public void saveOrderPaymentTest() {

        when(orderRepository.findByUuid(Mockito.any())).thenReturn(Optional.of(orderEntity));
        when(orderPaymentRepository.findByOrderUuid(Mockito.any())).thenReturn(Optional.empty());
        when(orderPaymentRepository.save(Mockito.any())).thenReturn(orderPaymentEntity);

        var orderPayment = registerPaymentOutputAdapter.saveOrUpdate(requestSuccess);

        assertNotNull(orderPayment);
        verify(orderRepository).findByUuid(Mockito.any());
        verify(orderPaymentRepository).findByOrderUuid(Mockito.any());
        verify(orderPaymentRepository).save(Mockito.any());

    }

    @Test
    public void saveOrderPaymentWithErrorTest() {

        when(orderRepository.findByUuid(Mockito.any())).thenReturn(Optional.of(orderEntity));
        when(orderPaymentRepository.findByOrderUuid(Mockito.any())).thenReturn(Optional.empty());
        when(orderPaymentRepository.save(Mockito.any())).thenReturn(orderPaymentEntity);

        var orderPayment = registerPaymentOutputAdapter.saveOrUpdate(requestError);

        assertNotNull(orderPayment);
        verify(orderRepository).findByUuid(Mockito.any());
        verify(orderPaymentRepository).findByOrderUuid(Mockito.any());
        verify(orderPaymentRepository).save(Mockito.any());

    }

    @Test
    public void updateOrderPaymentTest() {
        when(orderRepository.findByUuid(Mockito.any())).thenReturn(Optional.of(orderEntity));
        when(orderPaymentRepository.findByOrderUuid(Mockito.any())).thenReturn(Optional.of(orderPaymentEntity));
        when(orderPaymentRepository.save(Mockito.any())).thenReturn(orderPaymentEntity);

        var orderPayment = registerPaymentOutputAdapter.saveOrUpdate(requestSuccess);

        assertNotNull(orderPayment);
        verify(orderRepository).findByUuid(Mockito.any());
        verify(orderPaymentRepository).findByOrderUuid(Mockito.any());
        verify(orderPaymentRepository).save(Mockito.any());

    }

    @Test
    public void launchExceptionWhenOrderNotExistTest() {
        when(orderRepository.findByUuid(Mockito.any())).thenReturn(Optional.empty());

        var assertThrows = Assertions.assertThrows(NotFoundException.class,
                () -> registerPaymentOutputAdapter.saveOrUpdate(requestSuccess));

        assertTrue(assertThrows.getMessage().contains("not found"));
    }


}