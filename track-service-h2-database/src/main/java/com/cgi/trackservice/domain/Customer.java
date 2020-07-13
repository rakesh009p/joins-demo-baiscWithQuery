package com.cgi.trackservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Customer {
    @Id
    @GeneratedValue
    private int id;
    @NotNull(message = "First Name cannot be null")
    private String customerName;
    private String place;
    @OneToMany(targetEntity = Track.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "ct",referencedColumnName = "id")
    private List<Track> trackList;

}
