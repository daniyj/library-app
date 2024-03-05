package com.group.libraryapp.temp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;

    public PersonService(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }
    @Transactional
    public void savePerson(){
        Person person = personRepository.save(new Person());
        Address address = addressRepository.save(new Address());
        person.setAddress(address); // 연관관계의 주인의 setter가 사용되어야만 테이블이 연결된다.
//        address.setPerson(person); Address가 주인이 아니므로 address가 setter를 해도 연결되지 않는다.
        address.getPerson();
    }
}
