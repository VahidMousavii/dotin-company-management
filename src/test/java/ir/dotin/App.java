package ir.dotin;

import ir.dotin.da.CategoryDA;
import ir.dotin.da.EmailDA;
import ir.dotin.da.OffRequestDA;
import ir.dotin.da.PersonDA;
import ir.dotin.entity.Email;
import ir.dotin.entity.OffRequest;
import ir.dotin.entity.Person;
import ir.dotin.entity.SubCategory;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        PersonDA personDA = new PersonDA();
        Person person = new Person();
        person.setPersonName("Vahid");

        //Email
        /*Email email = new Email();
        email.setEmailContent("salam ....");
        email.setSenderPerson(person);
        email.setReceiverPersons(Arrays.asList(person));
        person.setReceivedPersonEmails(Arrays.asList(email));
        person.setSentEmails(Arrays.asList(email));
        EmailDA emailDA = new EmailDA();
        emailDA.addEmail(email);*/

        //Category
        /*CategoryDA categoryDA = new CategoryDA();
        SubCategory gottenRole = categoryDA.findByName("Developer");
        SubCategory gottenType = categoryDA.findByName("Hourly");

        person.setRoleSubCategory(gottenRole);*/
        personDA.save(person);

        //OffRequest
     /*   OffRequest offRequest = new OffRequest();
        OffRequestDA offRequestDA = new OffRequestDA();
        offRequest.setTypeOfRequest(gottenType);
        offRequest.setRequesterPerson(person);*/
//        offRequestDA.addOffRequest(offRequest);
    }
}
