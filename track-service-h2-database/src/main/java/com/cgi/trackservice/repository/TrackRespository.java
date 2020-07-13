package com.cgi.trackservice.repository;

import com.cgi.trackservice.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRespository extends JpaRepository<Track,Integer> {
}
