package com.fiap.tc.application.port.out.payment;

import com.fiap.tc.core.domain.model.OrderPayment;
import com.fiap.tc.infrastructure.adapter.web.requests.OrderPaymentRequest;

public interface RegisterPaymentOutputPort {

    OrderPayment saveOrUpdate(OrderPaymentRequest orderPaymentRequest);
}
