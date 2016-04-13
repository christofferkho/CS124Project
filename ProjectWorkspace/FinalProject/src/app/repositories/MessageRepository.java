package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Message;
import app.entity.OverdueFee;
import app.entity.Student;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>  {
	public List<Message> findByStudent(Student student);
}
