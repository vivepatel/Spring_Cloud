package com.tit.springjdbc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookrepository  extends CrudRepository<Book, Long> {
}
