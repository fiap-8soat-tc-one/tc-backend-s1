package com.fiap.tc.core.port.in;

import com.fiap.tc.core.domain.model.Category;
import com.fiap.tc.core.domain.model.CategoryRequest;

public interface RegisterCategoryInputPort {
    Category register(CategoryRequest categoryRequest);
}
