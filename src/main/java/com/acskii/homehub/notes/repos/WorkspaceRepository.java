package com.acskii.homehub.notes.repos;

import com.acskii.homehub.notes.models.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Integer> {
}
