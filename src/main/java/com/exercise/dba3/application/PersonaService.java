package com.exercise.dba3.application;

import com.exercise.dba3.infrastructure.PersonaInputDTO;
import com.exercise.dba3.infrastructure.PersonaListaOutputDTO;
import com.exercise.dba3.infrastructure.PersonaOutputDTO;
import com.exercise.dba3.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class PersonaService implements IPersona {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public PersonaOutputDTO save(PersonaInputDTO inputDTO) {
        Persona p = PersonaInputDTO.toPersona(inputDTO);
        p.setCreated_date(new Date());
        Persona p2 = mongoTemplate.save(p);
        return this.toOutputDTO(p2);
    }

    @Override
    public PersonaListaOutputDTO findAll() {
        List<Persona> listaPersona = mongoTemplate.findAll(Persona.class);
        List<PersonaOutputDTO> listaDTO = listaPersona.stream().map(this::toOutputDTO).toList();
        return new PersonaListaOutputDTO(listaDTO.size(),listaDTO);
    }

    @Override
    public PersonaOutputDTO findById(String id) {
        Persona p = mongoTemplate.findById(id,Persona.class);
        assert p != null;
        return this.toOutputDTO(p);
    }

    @Override
    public PersonaOutputDTO update(String id, PersonaInputDTO inputDTO) {
        Persona p = mongoTemplate.findById(id, Persona.class);
        assert p != null;
        p.setUser(inputDTO.user());
        p.setName(inputDTO.name());
        p.setSurname(inputDTO.surname());
        p.setCompany_email(inputDTO.company_email());
        p.setPersonal_email(inputDTO.personal_email());
        p.setCity(inputDTO.city());
        p.setActive(inputDTO.active());
        p.setImage_url(inputDTO.imagen_url());
        p.setTermination_date(inputDTO.termination_date());
        mongoTemplate.save(p);
        return this.toOutputDTO(p);
    }

    @Override
    public PersonaOutputDTO deleteById(String id) {
        Persona p = mongoTemplate.findById(id, Persona.class);
        assert p != null;
        PersonaOutputDTO outputDTO = this.toOutputDTO(p);
        mongoTemplate.remove(p);
        return outputDTO;
    }

    private PersonaOutputDTO toOutputDTO(Persona persona){
        return new PersonaOutputDTO(
                persona.getId_persona(),
                persona.getUser(),
                persona.getName(),
                persona.getSurname(),
                persona.getCompany_email(),
                persona.getPersonal_email(),
                persona.getCity(),
                persona.getActive(),
                persona.getCreated_date(),
                persona.getImage_url(),
                persona.getTermination_date()
        );
    }
}
