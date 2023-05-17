package com.lizzaraga.eventer.event;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
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
            name = "images"
    )
    @ElementCollection
    private List<String> images = new ArrayList<>();

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
    protected LocalDateTime createdAt;

    @UpdateTimestamp
    protected LocalDateTime updateAt;



    public Event(String title, String description, LocalDateTime startDate, LocalDateTime endDate) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
