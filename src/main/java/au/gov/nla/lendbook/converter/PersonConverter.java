package au.gov.nla.lendbook.converter;

import org.springframework.stereotype.Component;

import au.gov.nla.lendbook.dto.PersonDto;
import au.gov.nla.lendbook.model.Person;

/**
 * Converts Person entity to DTO
 * @author Mingtao Sun
 */
@Component
public class PersonConverter {
	
	/**
	 * Convert the Person entity to Person DTO
	 * @param entity
	 * @return
	 */
	public PersonDto convertFromEntity(Person entity){
		PersonDto dto = new PersonDto(entity.getId()); 
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		return dto;
	}
	
}
