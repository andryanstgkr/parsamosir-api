package com.andryanstgkr.parsamosir.api.model;

import java.time.LocalDate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "activity_log")
@Access(AccessType.FIELD)
public class ActivityLog {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")

    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;

    @Column(name = "application_id", length = 50, nullable = false)
    private String applicationId;

    @Column(name = "actionby_id", length = 50, nullable = false)
    private String actionById;

    @Column(name = "actionby_name", length = 50, nullable = false)
    private String actionByName;

    @Column(name = "action_type", length = 50, nullable = false)
    private String actionType;

    @Column(name = "action_menu", length = 50, nullable = false)
    private String actionMenu;

    @Column(name = "model_name", length = 50, nullable = false)
    private String modelName;

    @Column(name = "menu_name", length = 50, nullable = false)
    private String menuName;

    @Column(name = "log_date", columnDefinition = "TIMESTAMP", nullable = false)
    @CreationTimestamp
    private LocalDate logDate;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String beforeValue;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String afterValue;

    @Column(name = "status", length = 10, nullable = false)
    private String status;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String errorMessage;

}
