package com.endlesshorses.oot.custom.pattern.repository;

import com.endlesshorses.oot.custom.pattern.entity.Pattern;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PatternRepository{
	private EntityManager em;

	public List<Pattern> findAll(){
		return em.createQuery("select p from Pattern p",Pattern.class).getResultList();
	}
}
