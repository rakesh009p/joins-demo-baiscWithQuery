package com.cgi.trackservice.dto;

import com.cgi.trackservice.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TrackRequest {
    public Customer getCustomer() {
        return customer;
    }

    private Customer customer;
}
