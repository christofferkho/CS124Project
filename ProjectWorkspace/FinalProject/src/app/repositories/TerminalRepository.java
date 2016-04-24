package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Terminal;

public interface TerminalRepository extends JpaRepository<Terminal, Long>  {

}
