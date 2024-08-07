package com.fiap.tc.application.usecase.category;

import com.fiap.tc.application.port.in.category.DeleteCategoryInputPort;
import com.fiap.tc.application.port.out.category.DeleteCategoryOutputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class DeleteCategoryUseCase implements DeleteCategoryInputPort {

    private final DeleteCategoryOutputPort deleteCategoryOutputPort;

    public DeleteCategoryUseCase(DeleteCategoryOutputPort deleteCategoryOutputPort) {
        this.deleteCategoryOutputPort = deleteCategoryOutputPort;
    }


    @Override
    public void delete(UUID uuid) {
        this.deleteCategoryOutputPort.delete(uuid);
    }
}


