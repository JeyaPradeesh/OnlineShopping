//package com.product.productservice.controllerTest;
//
//import com.product.productservice.controller.ProductController;
//import com.product.productservice.model.Product;
//import com.product.productservice.service.ProductService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class ProductControllerTest {
//
//    private MockMvc mockMvc;
//
//    @InjectMocks
//    private ProductController productController;
//
//    @Mock
//    private ProductService productService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
//    }
//
//    @Test
//    public void testGetProductByCategory() throws Exception {
//        // Given
//        List<Product> products = Arrays.asList(new Product(1L, "Product 1", "Category A", 100.0),
//                new Product(2L, "Product 2", "Category A", 150.0));
//        when(productService.getProductByCategory("Category A")).thenReturn(new ResponseEntity<>(products, HttpStatus.OK));
//
//        // When
//        mockMvc.perform(get("/product/Category A"))
//                .andExpect(status().isOk());
//
//        // Then
//        verify(productService, times(1)).getProductByCategory("Category A");
//    }
//
//    @Test
//    public void testCreateProduct() throws Exception {
//        // Given
//        Product product = new Product(1L, "Product 1", "Category A", 100.0);
//        when(productService.postProduct(product)).thenReturn(product);
//
//        // When
//        mockMvc.perform(post("/product/createProduct")
//                        .contentType("application/json")
//                        .content("{\"id\": 1, \"name\": \"Product 1\", \"category\": \"Category A\", \"price\": 100.0}"))
//                .andExpect(status().isOk());
//
//        // Then
//        verify(productService, times(1)).postProduct(any(Product.class));
//    }
//
//    @Test
//    public void testViewProducts() {
//        // Given
//        List<Product> products = Arrays.asList(new Product(1L, "Product 1", "Category A", 100.0),
//                new Product(2L, "Product 2", "Category B", 150.0));
//        when(productService.viewProduct()).thenReturn(products);
//
//        // When
//        List<Product> response = productController.view();
//
//        // Then
//        assertEquals(2, response.size());
//        verify(productService, times(1)).viewProduct();
//    }
//
//    @Test
//    public void testUpdateProduct() {
//        // Given
//        Product product = new Product(1L, "Updated Product", "Category A", 200.0);
//        when(productService.updateProduct(1L, product)).thenReturn(product);
//
//        // When
//        ResponseEntity<Product> response = productController.updateProduct(1L, product);
//
//        // Then
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(product, response.getBody());
//        verify(productService, times(1)).updateProduct(1L, product);
//    }
//
//    @Test
//    public void testViewProductById() {
//        // Given
//        Product product = new Product(1L, "Product 1", "Category A", 100.0);
//        when(productService.getProductById(1L)).thenReturn(Optional.of(product));
//
//        // When
//        Optional<Product> response = productController.viewById(1L);
//
//        // Then
//        assertEquals(product, response.get());
//        verify(productService, times(1)).getProductById(1L);
//    }
//
//    @Test
//    public void testDeleteProduct() {
//        // When
//        String response = productController.delete(1L);
//
//        // Then
//        assertEquals("Deleted", response);
//        verify(productService, times(1)).delete(1L);
//    }
//}
