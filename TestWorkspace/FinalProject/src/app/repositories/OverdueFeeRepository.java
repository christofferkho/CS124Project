package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.OverdueFee;
import app.entity.Student;

@Repository
public interface OverdueFeeRepository extends JpaRepository<OverdueFee, Long>  {
	public List<OverdueFee> findByStudent(Student student);
	public OverdueFee findById(long id);
}
