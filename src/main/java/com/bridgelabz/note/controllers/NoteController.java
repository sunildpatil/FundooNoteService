package com.bridgelabz.note.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.note.models.NoteCreateDTO;
import com.bridgelabz.note.models.NoteResponseDTO;
import com.bridgelabz.note.models.NoteUpdateDTO;
import com.bridgelabz.note.models.Response;
import com.bridgelabz.note.services.NoteService;
import com.bridgelabz.note.utility.NoteHelper;
import com.bridgelabz.note.utility.ResponseHelper;

@RestController
@PropertySource("classpath:error.properties")
@RequestMapping(value="/notes")
public class NoteController {

	@Autowired
	private NoteService noteService;
	
	@Autowired
	private ResponseHelper responseHelper;
	
	@Autowired
    private Environment environment;
	
	@Autowired
    private NoteHelper noteHelper;
			
	@RequestMapping(value="/createnote", method=RequestMethod.POST)
	public ResponseEntity<Response> createNote(HttpServletRequest request, @RequestBody NoteCreateDTO noteDTO) throws Exception {
		
		int userId = Integer.parseInt(request.getAttribute("userID").toString());
		noteHelper.noteValidations(noteDTO);
		noteService.createNote(noteDTO, userId);
		
		Response response = responseHelper.responseStatus(Integer.parseInt(environment.getProperty("statussuccesscode")), environment.getProperty("notesuccessmsg"));
			 				
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="/updatenote", method=RequestMethod.PUT)
	public ResponseEntity<Response> updateNote(HttpServletRequest request, @RequestBody NoteUpdateDTO noteUpdateDTO) throws Exception {
		
		int userId = Integer.parseInt(request.getAttribute("userID").toString());
		noteService.updateNote(noteUpdateDTO, userId);
		
		Response response = responseHelper.responseStatus(Integer.parseInt(environment.getProperty("statussuccesscode")), environment.getProperty("noteupdatemsg"));
			 				
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="/deletenote/{noteId}", method=RequestMethod.DELETE)
	public ResponseEntity<Response> updateNote(HttpServletRequest request,@PathVariable int noteId) throws Exception {
		
		int userId = Integer.parseInt(request.getAttribute("userID").toString());
		noteService.deleteNote(noteId, userId);
		
		Response response = responseHelper.responseStatus(Integer.parseInt(environment.getProperty("statussuccesscode")), environment.getProperty("notedeletemsg"));
			 				
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="/displaynote", method=RequestMethod.GET)
	public List<NoteResponseDTO> displayNotes(HttpServletRequest request) throws Exception {
				
		int userId = Integer.parseInt(request.getAttribute("userID").toString());
		List<NoteResponseDTO> noteList = noteService.displayNotes(userId);

		return noteList;
	}
}