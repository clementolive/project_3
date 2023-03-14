package com.project3.repositories;

import com.project3.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long>  {
}
