package edu.fra.uas.Service;

import org.springframework.stereotype.Service;

@Service
public class CounterService {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void Count() {
        counter++;
    }

}
