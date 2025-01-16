package com.fit.backend.repositories;

import com.fit.backend.models.UserSocketMapping;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserSocketMappingRepository extends MongoRepository<UserSocketMapping, String> {
}
