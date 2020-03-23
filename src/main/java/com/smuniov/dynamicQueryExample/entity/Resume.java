package com.smuniov.dynamicQueryExample.entity;

import com.smuniov.dynamicQueryExample.entity.enumeration.Gender;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude="id")
@Entity
@Table(name = "resumes")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Embedded
    Contacts contacts;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "resumes_technologies",
            joinColumns = @JoinColumn(name = "resumes__fk"),
            inverseJoinColumns = @JoinColumn(name = "technologies__fk"))
    private Set<Technology> technologies;

    public String getGender(){
        return gender.toString();
    }

    public void setGender(String gender){
        this.gender = Gender.valueOf(gender);
    }

    public String toString(){

        return "ФИО: " + lastName + " " + firstName + " " + middleName +
                "\nДата рождения: " + birthDate +
                "\nКонтакты: " + contacts +
                "\nПол: " + gender +
                "\nТехнологии: " + Arrays.deepToString(technologies.toArray()) + "\n\n";
    }

}
