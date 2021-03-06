package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>  {
	
	public Student findByIdNo(int idNo);
	public List<Student> findByFlagged(boolean flagged);
	public void delete(Student student);
}
