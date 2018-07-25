package com.bridgelabz.note.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.bridgelabz.note.exceptions.NoteException;
import com.bridgelabz.note.models.NoteCreateDTO;

@PropertySource("classpath:error.properties")
public class NoteHelper {

	@Autowired
    private Environment environment;
	
	public void noteValidations(NoteCreateDTO noteDTO) throws NoteException {
		
		String title = noteDTO.getTitle();
		String description = noteDTO.getDescription();
			
		if(title==null && description==null) {

			throw new NoteException(environment.getProperty("titlenullerrormsg"));
		}
		
		if(title.equals("") && description.equals("")) {
			
			throw new NoteException(environment.getProperty("titleemptyerrormsg"));
		}
	}
}