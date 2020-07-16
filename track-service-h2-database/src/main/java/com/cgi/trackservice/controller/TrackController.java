package com.cgi.trackservice.controller;

import com.cgi.trackservice.domain.Customer;
import com.cgi.trackservice.domain.Track;
import com.cgi.trackservice.dto.TrackRequest;
import com.cgi.trackservice.dto.TrackResponse;
import com.cgi.trackservice.exception.TrackAlreadyExistException;
import com.cgi.trackservice.exception.TrackNotFoundException;
import com.cgi.trackservice.repository.CustomerRepository;
import com.cgi.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class TrackController {
    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistException {
        System.out.println(track);
        Track savedTrack = trackService.saveTrack(track);
        System.out.println(savedTrack);

        return new ResponseEntity<>(savedTrack, HttpStatus.CREATED);

    }

    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@RequestParam int id) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        Optional<Track> trackId = trackService.getTrackById(id);
        return new ResponseEntity<>(trackId, HttpStatus.OK);
//        responseEntity = new ResponseEntity<String>("retrived by id", HttpStatus.CREATED);
//        return responseEntity;
    }

    @GetMapping("tracks/")
    public ResponseEntity<?> getAllTracks() throws TrackNotFoundException {
        List<Track> trackAll = trackService.getAllTracks();
        return new ResponseEntity<>(trackAll, HttpStatus.OK);
    }

    @DeleteMapping("trackde/{id}")
    public ResponseEntity<?> deleteTrackbyId(@PathVariable int id) throws TrackNotFoundException {
        Optional<Track> trackDelete = (Optional<Track>) trackService.deleteTrackById(id);

        return new ResponseEntity<>(trackDelete, HttpStatus.CREATED);
    }


    @PutMapping("trackco/{id}")
    public ResponseEntity<?> updateTrack(@PathVariable int id,@RequestBody Track track){
        Track updatedTrack=trackService.updateTrack(id,track);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }
    @GetMapping("getjoin")
    public ResponseEntity<?> getJoin(){
        List<Customer> customerList = trackService.getJoin();
        return new ResponseEntity<>(customerList,HttpStatus.CREATED);

    }
    @PostMapping("postjoin")
    public ResponseEntity<?> saveCustomer(@RequestBody TrackRequest trackRequest){
        Customer customerSaved = trackService.saveCustomer(trackRequest);
        return new ResponseEntity<>(customerSaved,HttpStatus.CREATED);
    }
//    @GetMapping("getInfo")
//    public ResponseEntity<?> getJoinInfo(){
//        List<TrackResponse> trackResponses =trackService.getJoinInfo();
//        return new ResponseEntity<>(trackResponses,HttpStatus.CREATED);
//    }
    }

