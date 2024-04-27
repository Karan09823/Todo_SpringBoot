package com.example.TODOSPRINGBOOT.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TODOSPRINGBOOT.model.ToDo;

public interface TodoRepoInterface extends JpaRepository<ToDo,Long>{

}
