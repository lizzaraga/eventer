package com.lizzaraga.eventer.event;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Event")
@Table(name = "tbl_event", uniqueConstraints = {
        @UniqueConstraint(
                name = "event_title_unique",
                columnNames = "title"
        )
})
public class Event {

    @Id
    @SequenceGenerator(
            name = "event_generator",
            sequenceName = "event_generator"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_generator"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "title",
            nullable = false
    )
    private String title;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "start_date",
            nullable = false
    )
    private LocalDateTime startDate;
    @Column(
            name = "end_date",
            nullable = false
    )
    private LocalDateTime endDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

    public Event(String title, String description, LocalDateTime startDate, LocalDateTime endDate) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
