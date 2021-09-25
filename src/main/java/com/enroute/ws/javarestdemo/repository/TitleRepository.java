package com.enroute.ws.javarestdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enroute.ws.javarestdemo.model.Titles;

@Repository
public interface TitleRepository extends CrudRepository<Titles, Integer> {

}