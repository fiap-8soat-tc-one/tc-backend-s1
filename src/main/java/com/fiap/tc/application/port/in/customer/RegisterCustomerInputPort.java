package com.fiap.tc.application.port.in.customer;

import com.fiap.tc.core.domain.model.Customer;
import com.fiap.tc.infrastructure.adapter.web.requests.CustomerRequest;

public interface RegisterCustomerInputPort {
    Customer register(CustomerRequest customerRequest);
}
