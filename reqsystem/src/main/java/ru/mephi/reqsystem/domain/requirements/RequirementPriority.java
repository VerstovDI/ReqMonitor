package ru.mephi.reqsystem.domain.requirements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "tcl_priority", schema = "system_control_requirements")
public class RequirementPriority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pr_pk", columnDefinition = "serial")
    private Long id;

    @NotBlank(message = "name cannot be empty")
    @Column(name = "pr_name")
    private String name;

    public RequirementPriority() {
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
        if (!(o instanceof RequirementPriority)) return false;
        RequirementPriority that = (RequirementPriority) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "RequirementPriority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
