# dynamicQueryExample
Dynamic queries with Spring Data JPA

This application demonstrates creation dynamic queries using Specification.
The specification API is an abstraction on top of the JPA Criteria API, which means we can do anything you could do with these criteria as well.

For example,this is method for creation specification to check if first name field is equal
public static Specification<Resume> firstNameEquals(String firstName) {
        return (root, query, builder) -> builder.equal(root.get("firstName"), firstName);
    }
This interface method passes three arguments which you can use:

The first parameter (root) allows you to select the field you want to filter on. This can be done by using root.get("firstName") or if you need joining, you can use root.join("myField").get("name").
The second parameter (query) isn’t used that often, but contains information about the type of query that’s being executed.
The last parameter is the CriteriaBuilder, that allows you to define exactly what type of query you want to construct (LIKE, IS NULL, CONTAINS, AND, OR, =, …). 
