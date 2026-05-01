package com.acskii.homehub.notes.repos;

import com.acskii.homehub.notes.models.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
}
