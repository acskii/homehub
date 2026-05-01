package com.acskii.homehub.notes.repos;

import com.acskii.homehub.notes.models.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
}
