package com.school.manage.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "staff")
public class StaffMember {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        @NotBlank
        private  String name;
        private String city;
        @NotBlank
        private String contact;
        @NotBlank
        private String department;
        @NotBlank
        private String speciality;
}
