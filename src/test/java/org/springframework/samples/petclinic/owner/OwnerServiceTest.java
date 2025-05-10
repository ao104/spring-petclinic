package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

//OwnerServiceTest.java
@ExtendWith(MockitoExtension.class)
class OwnerServiceTest {

 @Mock
 private OwnerRepository ownerRepository;

 @InjectMocks
 private OwnerService ownerService;

 @Test
 void testGetOwnerCount() {
     Mockito.when(ownerRepository.countOwners()).thenReturn(5L);

     long count = ownerService.getOwnerCount();
     assertEquals(5L, count);
 }
}
