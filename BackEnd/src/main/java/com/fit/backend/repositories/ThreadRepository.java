package com.fit.backend.repositories;

import com.fit.backend.models.Thread;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ThreadRepository extends MongoRepository<Thread, String> {
}
