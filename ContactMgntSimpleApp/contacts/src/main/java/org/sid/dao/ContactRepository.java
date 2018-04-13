package org.sid.dao;

import org.sid.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



/**
 * Created by jocopernicus on 3/28/2018.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

    @Query("SELECT c FROM Contact c where c.nom LIKE :x")
    public Page<Contact> search(@Param("x") String mc, Pageable pageable);
}
