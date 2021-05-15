package ru.mephi.reqsystem.domain.requirements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "t_specifications", schema = "system_control_requirements")
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "spc_pk", columnDefinition = "serial")
    private Long id;

    @NotBlank(message = "version cannot be empty")
    @Column(name = "spc_ver")
    private Integer version;

    @NotBlank(message = "description cannot be empty")
    @Column(name = "spc_desc")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spc_prj_fk")
    private Project project;

    public Specification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Specification)) return false;
        Specification that = (Specification) o;
        return Objects.equals(id, that.id) && Objects.equals(version, that.version) && Objects.equals(description, that.description) && Objects.equals(project, that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, description, project);
    }

    @Override
    public String toString() {
        return "Specification{" +
                "id=" + id +
                ", version=" + version +
                ", description='" + description + '\'' +
                ", project=" + project +
                '}';
    }
}
