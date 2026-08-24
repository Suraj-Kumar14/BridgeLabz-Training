package com.fundoo_notes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundoo_notes.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

	Optional<Tag> findByNameIgnoreCaseAndUserEmail(String name, String email);

	List<Tag> findByUserEmail(String email);

	Optional<Tag> findByTagIdAndUserEmail(Long tagId, String email);
}