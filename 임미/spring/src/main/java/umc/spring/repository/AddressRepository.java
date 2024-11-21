package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.member.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
