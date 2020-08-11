package ir.dotin;

import ir.dotin.repository.PersonDA;
import ir.dotin.entity.Person;

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
