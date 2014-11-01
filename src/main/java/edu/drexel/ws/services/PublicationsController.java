package edu.drexel.ws.services;

import java.util.concurrent.atomic.AtomicLong;


import edu.drexel.ws.model.Publication;
import edu.drexel.ws.model.Publications;
import edu.drexel.ws.model.RequestError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import edu.drexel.ws.data.*;

@RestController
public class PublicationsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    DBMock dbService;

    @RequestMapping(value="/publications", method = RequestMethod.GET)
    public @ResponseBody
    Publications getAllPubs() {

        Publications pList = new Publications();
        Collection<Publication> pubList = dbService.getAllPubs(); //dbService.getAllPubs();
        if(pubList != null) {
            pList.setPublications(pubList);
        }
        else{
            RequestError requestError = new RequestError(400,
                    "Please check server logs, an unexpected error has happened");
            pList.setError(requestError);
        }

        return pList;
    }


    @RequestMapping(value="/publications/{id}", method=RequestMethod.GET)
    public @ResponseBody Publication getDataInJSON(@PathVariable int id)
    {
        Publication thePub = dbService.getPubById(id);

        if(thePub == null){
            RequestError requestError = new RequestError(400,
                    "The requested index "+id+" is invalid or not in range");
            thePub = new Publication();
            thePub.setError(requestError);
        }

        return thePub;
    }

}