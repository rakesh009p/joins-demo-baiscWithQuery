package com.cgi.trackservice.service;

import com.cgi.trackservice.domain.Customer;
import com.cgi.trackservice.domain.Track;
import com.cgi.trackservice.dto.TrackRequest;
import com.cgi.trackservice.dto.TrackResponse;
import com.cgi.trackservice.exception.TrackAlreadyExistException;
import com.cgi.trackservice.exception.TrackNotFoundException;
import com.cgi.trackservice.repository.CustomerRepository;
import com.cgi.trackservice.repository.TrackRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService  {

    @Autowired
    TrackRespository trackRespository;
    @Autowired
    CustomerRepository customerRepository;


//    @Autowired
//    public TrackService(TrackRespository trackRespository, CustomerRepository customerRepository) {
//        this.trackRespository = trackRespository;
//        this.customerRepository=customerRepository;
//    }


    public Track saveTrack(Track track) throws TrackAlreadyExistException{
        Track savedTrack = trackRespository.save(track);
        if (trackRespository.existsById(track.getId())) {
//            System.out.println("Inside service*************");
            throw new TrackAlreadyExistException("user already exists");
        }
        return savedTrack;
    }


    public Optional<Track> getTrackById(int id) throws TrackNotFoundException {

        if (!trackRespository.findById(id).isPresent()) {

            throw new TrackNotFoundException("id not exists");
        }
        return trackRespository.findById(id);
    }


    public List<Track> getAllTracks() throws TrackNotFoundException {
        List<Track> trackList = trackRespository.findAll();
        if (trackList.isEmpty()) {
            throw new TrackNotFoundException("Tracks Not available");
        }
        return trackList;

    }


    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException {
        Optional<Track> trackDelete = trackRespository.findById(id);
        if (!trackDelete.isPresent()) {
            throw new TrackNotFoundException("track not found");
        } else {
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


//    public List<TrackResponse> getJoinInfo() {
//        return customerRepository.getJoinInformation();
//    }

}
