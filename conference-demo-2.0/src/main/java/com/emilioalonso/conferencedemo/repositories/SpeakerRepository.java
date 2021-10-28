package com.emilioalonso.conferencedemo.repositories;

import com.emilioalonso.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
