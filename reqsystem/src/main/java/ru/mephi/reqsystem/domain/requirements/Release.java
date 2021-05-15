package ru.mephi.reqsystem.domain.requirements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "t_releases", schema = "system_control_requirements")
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rel_pk", columnDefinition = "serial")
    private Long id;

    @NotBlank(message = "version cannot be empty")
    @Column(name = "rel_ver")
    private Integer version;

    @NotBlank(message = "description cannot be empty")
    @Column(name = "rel_desc")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rel_spc_fk")
    private Specification specification;

    public Release() {
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

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Release)) return false;
        Release release = (Release) o;
        return Objects.equals(id, release.id) && Objects.equals(version, release.version) && Objects.equals(description, release.description) && Objects.equals(specification, release.specification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, description, specification);
    }

    @Override
    public String toString() {
        return "Release{" +
                "id=" + id +
                ", version=" + version +
                ", description='" + description + '\'' +
                ", specification=" + specification +
                '}';
    }
}
