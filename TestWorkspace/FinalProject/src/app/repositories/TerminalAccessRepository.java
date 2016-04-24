package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Student;
import app.entity.TerminalAccess;



@Repository
public interface TerminalAccessRepository extends JpaRepository<TerminalAccess, Long>  {
	public TerminalAccess findById(int id);
	public TerminalAccess findByTimeLogAndStudent(String timeLog, Student student);
	public TerminalAccess findByTimeLog(String timeLog);

}
