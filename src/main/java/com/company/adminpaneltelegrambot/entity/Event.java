package com.company.adminpaneltelegrambot.entity;

import com.company.adminpaneltelegrambot.enums.EventType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "events")
@NoArgsConstructor
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "photo_id", nullable = false)
  private String photoId;

  @Column(name = "event_type", nullable = false)
  @Enumerated(value = EnumType.STRING)
  private EventType eventType;

  @Column(name = "venue", nullable = false)
  private String venue;

  @Column(name = "date", nullable = false)
  private LocalDate date;

  @Column(name = "event_organized_by", nullable = false)
  private String eventOrganizedBy;


  public Event(String title, String description, String photoId, EventType eventType, String venue,
      LocalDate date, String eventOrganizedBy) {
    this.title = title;
    this.description = description;
    this.photoId = photoId;
    this.eventType = eventType;
    this.venue = venue;
    this.date = date;
    this.eventOrganizedBy = eventOrganizedBy;
  }

  @Override
  public String toString() {
    return "Event{" +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", eventType=" + eventType +
        ", venue='" + venue + '\'' +
        ", date=" + date +
        ", eventOrganizedBy='" + eventOrganizedBy + '\'' +
        '}';
  }
}