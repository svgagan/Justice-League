package com.svgagan.justiceleague.repository;

import com.svgagan.justiceleague.model.ComicDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComicsDetailsRepository extends JpaRepository<ComicDetails, String> {

    public Optional<ComicDetails> findById(String comicId);
}
