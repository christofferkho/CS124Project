package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.AccessLog;
import app.entity.Terminal;

@Repository
public interface AccessLogRepository extends JpaRepository<AccessLog, Long>  {
	public AccessLog findById(long id);
	public List<AccessLog> findByTerminal(Terminal terminal);
}
