package ru.mephi.reqsystem.domain.requirements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "tcl_status", schema = "system_control_requirements")
public class RequirementStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_pk", columnDefinition = "serial")
    private Long id;

    @NotBlank(message = "name cannot be empty")
    @Column(name = "st_name")
    private String name;

    public RequirementStatus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequirementStatus)) return false;
        RequirementStatus that = (RequirementStatus) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "RequirementStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
