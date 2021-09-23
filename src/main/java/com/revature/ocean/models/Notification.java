package com.revature.ocean.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Zimi Li
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "notifications")
public class Notification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    @JsonIgnore
    private Integer id;

    @Column(name = "notification_type", nullable = false)
    private String type;

    @Column(name = "notification_timestamp", nullable = false)
    private Long timestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    //@JsonIgnore
    private User user;

   /* @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Feed feed;*/

   /* @Transient
    private Integer feedID;*/

    @Transient
    private Response response;

    @Transient
    private UserResponse userResponse;
}
