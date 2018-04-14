package org.sid.web;

import org.sid.dao.ContactRepository;
import org.sid.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jocopernicus on 3/28/2018.
 */
@RestController
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class ContactRestService {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value="/contacts", method= RequestMethod.GET)
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    @RequestMapping(value="/contacts/{id}", method= RequestMethod.GET)
    public Contact getContact(@PathVariable Long id){
        return contactRepository.getOne(id);
    }

    @RequestMapping(value="/contacts", method= RequestMethod.POST)
    public Contact save(@RequestBody Contact c){
        return contactRepository.save(c);
    }

    @RequestMapping(value="/contacts/{id}", method= RequestMethod.PUT)
    public Contact update(@PathVariable Long id, @RequestBody Contact c){
        c.setId(id);
        return contactRepository.save(c);
    }

    @RequestMapping(value="/contacts/{id}", method= RequestMethod.DELETE)
    public boolean delete(@PathVariable Long id){
         Contact c = contactRepository.getOne(id);
         contactRepository.delete(c);
        return true;
    }

    @RequestMapping(value="/searchContacts", method= RequestMethod.GET)
    public Page<Contact> search(
            @RequestParam(name="mc",defaultValue = "") String mc,
            @RequestParam(name="page",defaultValue = "0") int page,
            @RequestParam(name="size",defaultValue = "5") int size
    ){
        return contactRepository.search("%"+mc+"%", new PageRequest(page,size));
    }


}
