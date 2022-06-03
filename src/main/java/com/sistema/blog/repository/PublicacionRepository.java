package com.sistema.blog.repository;

import com.sistema.blog.entities.PublicacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<PublicacionEntity,Long> {
}
