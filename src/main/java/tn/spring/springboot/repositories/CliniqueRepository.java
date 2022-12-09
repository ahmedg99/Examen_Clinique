package tn.spring.springboot.repositories;

 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 import org.springframework.stereotype.Repository;
import tn.spring.springboot.entities.Clinique;

@EnableJpaRepositories
public interface CliniqueRepository extends JpaRepository<Clinique, Long > {


}
