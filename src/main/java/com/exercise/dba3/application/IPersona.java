package com.exercise.dba3.application;

import com.exercise.dba3.infrastructure.PersonaInputDTO;
import com.exercise.dba3.infrastructure.PersonaListaOutputDTO;
import com.exercise.dba3.infrastructure.PersonaOutputDTO;

public interface IPersona {
    PersonaOutputDTO save(PersonaInputDTO inputDTO);
    PersonaListaOutputDTO findAll();
    PersonaOutputDTO findById(String id);
    PersonaOutputDTO update(String id, PersonaInputDTO inputDTO);
    PersonaOutputDTO deleteById(String id);
}
