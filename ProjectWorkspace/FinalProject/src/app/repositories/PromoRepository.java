package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Promo;

public interface PromoRepository extends JpaRepository<Promo, Long>  {

}