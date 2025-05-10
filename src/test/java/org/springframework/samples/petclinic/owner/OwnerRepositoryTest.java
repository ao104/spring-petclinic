package org.springframework.samples.petclinic.owner;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;

//OwnerRepositoryTest.java
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class OwnerRepositoryTest {

 @Autowired
 private OwnerRepository ownerRepository;

 @Test
 void testCountOwners() {
     long count = ownerRepository.countOwners();
     assertThat(count).isGreaterThanOrEqualTo(0); // 0件以上であることを確認
 }
}
