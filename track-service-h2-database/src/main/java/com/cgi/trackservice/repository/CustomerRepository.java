package com.cgi.trackservice.repository;

import com.cgi.trackservice.domain.Customer;
import com.cgi.trackservice.dto.TrackResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
    @Query("SELECT new com.cgi.trackservice.dto.TrackResponse(c.customerName,t.trackName) FROM Customer c JOIN c.trackList t")
     List<TrackResponse> getJoinInformation();
}
