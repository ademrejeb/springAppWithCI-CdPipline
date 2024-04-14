package tn.esprit.devops_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.controllers.SupplierController;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.services.Iservices.ISupplierService;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SupplierControllerTest {

    @Mock
    private ISupplierService supplierService;

    @InjectMocks
    private SupplierController supplierController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetSuppliers() {
        // Arrange
        List<Supplier> expectedSuppliers = Arrays.asList(new Supplier(1L, "Supplier1"), new Supplier(2L, "Supplier2"));
        when(supplierService.retrieveAllSuppliers()).thenReturn(expectedSuppliers);

        // Act
        List<Supplier> actualSuppliers = supplierController.getSuppliers();

        // Assert
        assertEquals(expectedSuppliers.size(), actualSuppliers.size());
        assertEquals(expectedSuppliers.get(0), actualSuppliers.get(0));
        assertEquals(expectedSuppliers.get(1), actualSuppliers.get(1));
    }

    @Test
    void testRetrieveSupplier() {
        // Arrange
        long supplierId = 1L;
        Supplier expectedSupplier = new Supplier(supplierId, "Supplier1");
        when(supplierService.retrieveSupplier(supplierId)).thenReturn(expectedSupplier);

        // Act
        Supplier actualSupplier = supplierController.retrieveSupplier(supplierId);

        // Assert
        assertEquals(expectedSupplier, actualSupplier);
    }

    @Test
    void testAddSupplier() {
        // Arrange
        Supplier supplierToAdd = new Supplier(1L, "New Supplier");
        when(supplierService.addSupplier(supplierToAdd)).thenReturn(supplierToAdd);

        // Act
        Supplier addedSupplier = supplierController.addSupplier(supplierToAdd);

        // Assert
        assertEquals(supplierToAdd, addedSupplier);
    }

    @Test
    void testDeleteSupplier() {
        // Arrange
        long supplierIdToDelete = 1L;

        // Act
        supplierController.removeFournisseur(supplierIdToDelete);

        // Assert
        verify(supplierService, times(1)).deleteSupplier(supplierIdToDelete);
    }

    @Test
    void testUpdateSupplier() {
        // Arrange
        Supplier supplierToUpdate = new Supplier(1L, "Updated Supplier");
        when(supplierService.updateSupplier(supplierToUpdate)).thenReturn(supplierToUpdate);

        // Act
        Supplier updatedSupplier = supplierController.modifyFournisseur(supplierToUpdate);

        // Assert
        assertEquals(supplierToUpdate, updatedSupplier);
    }
}
