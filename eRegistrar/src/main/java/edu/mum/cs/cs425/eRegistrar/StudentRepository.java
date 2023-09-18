package edu.mum.cs.cs425.eRegistrar;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Define custom queries if needed
}
