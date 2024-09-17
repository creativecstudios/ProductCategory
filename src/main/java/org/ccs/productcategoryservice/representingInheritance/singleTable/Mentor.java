package org.ccs.productcategoryservice.representingInheritance.singleTable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="st_Mentor")
@DiscriminatorValue(value = "1")
public class Mentor extends User {
    private double mentorRating;
}
