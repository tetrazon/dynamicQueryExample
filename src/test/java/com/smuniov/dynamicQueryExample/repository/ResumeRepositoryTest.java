package com.smuniov.dynamicQueryExample.repository;

import com.smuniov.dynamicQueryExample.DemoApplication;
import com.smuniov.dynamicQueryExample.entity.Resume;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.smuniov.dynamicQueryExample.repository.ResumeSpecifications.*;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class ResumeRepositoryTest {

    @Autowired ResumeRepository resumeRepository;

    @Test
    public void findByFirstAndMiddleAndLastNameTest(){
        String lastName = "Морская";
        String firstName = "Мария";
        String middleName = "Васильевна";

        Specification<Resume> specification = Specification.where(firstNameEquals(firstName)).
                                                                and(middleNameEquals(middleName)).
                                                                and(lastNameEquals(lastName));
        Optional<Resume> resume = resumeRepository.findOne(specification);
        assertTrue(resume.isPresent());

    }

    @Test
    public void findAllByFirstNameContainsOrGenderEquals(){
        Specification<Resume> specification = Specification.where(lastNameContains("ов")).
                                                                or(genderEquals("женщина"));
        List<Resume> resumes = resumeRepository.findAll(specification);
        System.out.println(Arrays.deepToString(resumes.toArray()));
        assertTrue(resumes.size() == 3);

    }

}