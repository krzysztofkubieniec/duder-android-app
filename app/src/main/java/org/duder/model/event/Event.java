package org.duder.model.event;

import org.duder.model.user.Account;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Event {
    private String name;
    private List<String> hobbies;
    private int numberOfParticipants;
    private Long timestamp;
    private Account host;

    public Event(String name, List<String> hobbies, Long timestamp) {
        this.name = name;
        this.hobbies = hobbies;
        this.timestamp = timestamp;
    }

    public Event(String name, List<String> hobbies, int numberOfParticipants, Long timestamp) {
        this.name = name;
        this.hobbies = hobbies;
        this.numberOfParticipants = numberOfParticipants;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Account getHost() {
        return host;
    }

    public void setHost(Account host) {
        this.host = host;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return numberOfParticipants == event.numberOfParticipants &&
                name.equals(event.name) &&
                hobbies.equals(event.hobbies) &&
                timestamp.equals(event.timestamp) &&
                host.equals(event.getHost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hobbies, numberOfParticipants, timestamp, host);
    }
}