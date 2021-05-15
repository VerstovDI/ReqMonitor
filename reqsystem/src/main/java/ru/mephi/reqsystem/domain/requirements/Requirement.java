package ru.mephi.reqsystem.domain.requirements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "t_requirements", schema = "system_control_requirements")
public class Requirement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "req_pk", columnDefinition = "serial")
    private Long id;

    @NotBlank(message = "title cannot be empty")
    @Column(name = "req_title")
    private String title;

    @NotBlank(message = "art_type cannot be empty")
    @Column(name = "req_art_type")
    private String art_type;

    @NotBlank(message = "description cannot be empty")
    @Column(name = "req_s_desc")
    private String description;

    @NotBlank(message = "limit time cannot be empty")
    @Column(name = "req_lim_t")
    private Time limitTime;


    @NotBlank(message = "loc cannot be empty")
    @Column(name = "req_loc")
    private String loc;

    @NotBlank(message = "origin cannot be empty")
    @Column(name = "req_origin")
    private String origin;

    @NotBlank(message = "date cannot be empty")
    @Column(name = "req_date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "req_rel_fk")
    private Release release;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "req_vrf_fk")
    private RequirementVerification requirementVerification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = " req_pr_fk")
    private RequirementPriority requirementPriority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "req_st_fk")
    private RequirementStatus requirementStatus;

    public Requirement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArt_type() {
        return art_type;
    }

    public void setArt_type(String art_type) {
        this.art_type = art_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Time limitTime) {
        this.limitTime = limitTime;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public RequirementVerification getRequirementVerification() {
        return requirementVerification;
    }

    public void setRequirementVerification(RequirementVerification requirementVerification) {
        this.requirementVerification = requirementVerification;
    }

    public RequirementPriority getRequirementPriority() {
        return requirementPriority;
    }

    public void setRequirementPriority(RequirementPriority requirementPriority) {
        this.requirementPriority = requirementPriority;
    }

    public RequirementStatus getRequirementStatus() {
        return requirementStatus;
    }

    public void setRequirementStatus(RequirementStatus requirementStatus) {
        this.requirementStatus = requirementStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Requirement)) return false;
        Requirement that = (Requirement) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(art_type, that.art_type) && Objects.equals(description, that.description) && Objects.equals(limitTime, that.limitTime) && Objects.equals(loc, that.loc) && Objects.equals(origin, that.origin) && Objects.equals(date, that.date) && Objects.equals(release, that.release) && Objects.equals(requirementVerification, that.requirementVerification) && Objects.equals(requirementPriority, that.requirementPriority) && Objects.equals(requirementStatus, that.requirementStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, art_type, description, limitTime, loc, origin, date, release, requirementVerification, requirementPriority, requirementStatus);
    }

    @Override
    public String toString() {
        return "Requirement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", art_type='" + art_type + '\'' +
                ", description='" + description + '\'' +
                ", limitTime=" + limitTime +
                ", loc='" + loc + '\'' +
                ", origin='" + origin + '\'' +
                ", date=" + date +
                ", release=" + release +
                ", requirementVerification=" + requirementVerification +
                ", requirementPriority=" + requirementPriority +
                ", requirementStatus=" + requirementStatus +
                '}';
    }
}
