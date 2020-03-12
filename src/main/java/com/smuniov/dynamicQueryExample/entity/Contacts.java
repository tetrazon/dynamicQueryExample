package com.smuniov.dynamicQueryExample.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Contacts {
    private String phone;
    private String email;
    private String github;
    private String linkedin;

    @Override
    public String toString() {
        StringBuffer contacts = new StringBuffer("phone: " + phone + ", ");
        if(email!= null){
            contacts.append("email: " + email + ", ");
        }
        if(github!= null){
            contacts.append("github: " + github + ", ");
        }
        if(linkedin!= null){
            contacts.append("linkedin: " + linkedin + ", ");
        }
        contacts.delete(contacts.length()-2, contacts.length());
        return contacts.toString();
    }
}
