package org.ccs.productcategoryservice.representingInheritance.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="jt_Mentor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User {
    private double mentorRating;
}
