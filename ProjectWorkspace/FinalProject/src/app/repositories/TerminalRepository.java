package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Terminal;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Long>  {
	public Terminal findById(long id);
	public List<Terminal> findByTerminalNumberAndRoomName(int terminalNumber, String roomName);
}
