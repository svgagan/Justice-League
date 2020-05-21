package com.svgagan.justiceleague.service;

import com.svgagan.justiceleague.model.ComicDetails;
import com.svgagan.justiceleague.repository.ComicsDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComicDetailsService {

    private ComicsDetailsRepository comicsDetailsRepository;

    public ComicDetailsService(ComicsDetailsRepository comicsDetailsRepository){
        this.comicsDetailsRepository = comicsDetailsRepository;
    }

    public List<ComicDetails> findAllComics() throws Exception {
        return this.comicsDetailsRepository.findAll();
    }

    public ComicDetails findByComicId(String comicId) throws Exception {
        Optional<ComicDetails> existing = this.comicsDetailsRepository.findById(comicId);
        if(!existing.isPresent()){
            throw new Exception("Comic Not Exists");
        }
        return existing.get();
    }

    public ComicDetails createComic(ComicDetails comicDetails) throws Exception {
        Optional<ComicDetails> existing = this.comicsDetailsRepository.findById(comicDetails.getId());
        if(existing.isPresent()){
            throw new Exception("Comic Exists");
        }
        return this.comicsDetailsRepository.save(comicDetails);
    }

    public void deleteComic(String comicId) throws Exception {
        Optional<ComicDetails> existing = this.comicsDetailsRepository.findById(comicId);
        if(!existing.isPresent()){
            throw new Exception("Comic Not Found");
        }
        this.comicsDetailsRepository.deleteById(comicId);
    }

    public ComicDetails updateComic(String comicId, ComicDetails comicDetails) throws Exception {
        Optional<ComicDetails> existing = this.comicsDetailsRepository.findById(comicId);
        if(!existing.isPresent()){
            throw new Exception("Comic Not Found");
        }
        comicDetails.setId(comicId);
        return this.comicsDetailsRepository.save(comicDetails);
    }
}
