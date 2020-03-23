package com.smuniov.dynamicQueryExample.repository;

import com.smuniov.dynamicQueryExample.entity.Resume;
import com.smuniov.dynamicQueryExample.entity.enumeration.Gender;
import org.springframework.data.jpa.domain.Specification;

import java.text.MessageFormat;

public final class ResumeSpecifications {

    public static Specification<Resume> firstNameEquals(String firstName) {
        return (root, query, builder) -> builder.equal(root.get("firstName"), firstName);
    }

    public static Specification<Resume> middleNameEquals(String middleName) {
        return (root, query, builder) -> builder.equal(root.get("middleName"), middleName);
    }

    public static Specification<Resume> lastNameEquals(String lastName) {
        return (root, query, builder) -> builder.equal(root.get("lastName"), lastName);
    }

    public static Specification<Resume> genderEquals(String gender) {
        return (root, query, builder) -> builder.equal(root.get("gender"), Gender.valueOf(gender));
    }

    public static Specification<Resume> lastNameContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("lastName"), contains(expression));
    }

    private static String contains(String expression) {
            return MessageFormat.format("%{0}%", expression);
    }
}
