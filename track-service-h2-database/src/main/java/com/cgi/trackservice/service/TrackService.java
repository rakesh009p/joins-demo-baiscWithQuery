package com.cgi.trackservice.service;

import com.cgi.trackservice.domain.Customer;
import com.cgi.trackservice.domain.Track;
import com.cgi.trackservice.dto.TrackRequest;
import com.cgi.trackservice.dto.TrackResponse;
import com.cgi.trackservice.repository.CustomerRepository;
import com.cgi.trackservice.repository.TrackRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService  {

    TrackRespository trackRespository;
    CustomerRepository customerRepository;


    @Autowired
    public TrackService(TrackRespository trackRespository, CustomerRepository customerRepository) {
        this.trackRespository = trackRespository;
        this.customerRepository=customerRepository;
    }


    public Track saveTrack(Track track) {
        Track savedTrack = trackRespository.save(track);
        return savedTrack;
    }


    public Track getTrackById(int id) {
        Track trackId = trackRespository.findById(id).get();
        return trackId;
    }


    public List<Track> getAllTracks() {
        List<Track> trackList = trackRespository.findAll();
        return trackList;

    }


    public Optional<Track> deleteTrackById(int id) {
        Optional<Track> trackDelete = trackRespository.findById(id);
        if (trackDelete.isPresent()) {
            trackRespository.deleteById(id);
        }
        return trackDelete;
    }


    public Track updateTrack(int id,Track track) {
        Track update = trackRespository.findById(id).get();
        update.setTrackName(track.getTrackName());
        update.setLanguage(track.getLanguage());
        return trackRespository.save(track);
    }


    public List<Customer> getJoin() {
        return customerRepository.findAll();
    }


    public Customer saveCustomer(TrackRequest trackRequest) {
        return customerRepository.save(trackRequest.getCustomer());
    }


    public List<TrackResponse> getJoinInfo() {
        return customerRepository.getJoinInformation();
    }
}
