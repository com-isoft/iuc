package com.isoft.iuc.domain.specification;

import com.isoft.iuc.domain.model.Client;
import org.springframework.data.jpa.domain.Specification;

public class ClientSpecifications {
    public static Specification<Client> clentIdSpec(String clientId) {
        return (root, criteriaQuery, cb) -> cb.equal(root.get("clientId"), clientId);
    }
}
