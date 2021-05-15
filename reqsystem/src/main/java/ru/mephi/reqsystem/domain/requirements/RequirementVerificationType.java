package ru.mephi.reqsystem.domain.requirements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "tcl_verification_type", schema = "system_control_requirements")
public class RequirementVerificationType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vt_pk", columnDefinition = "serial")
    private Long id;

    @NotBlank(message = "name cannot be empty")
    @Column(name = "vt_name")
    private String name;



    public RequirementVerificationType() {
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
        if (!(o instanceof RequirementVerificationType)) return false;
        RequirementVerificationType that = (RequirementVerificationType) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "RequirementVerificationType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
