package edu.drexel.ws.data;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.drexel.ws.model.Publication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Collection;
import java.util.List;



/**
 * Created with IntelliJ IDEA.
 * User: bsmitc
 * Date: 11/3/13
 * Time: 7:12 AM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class DBMock {

    private HashMap<Integer, Publication> pubCache = null;

    public HashMap<Integer, Publication> getFullPubList() {
        return queryPubs();
    }

    public Publication getPubById(int id) {
        HashMap<Integer, Publication> pubDB = queryPubs();
        Integer index = new Integer(id);
        return pubDB.get(index);
    }

    public Collection<Publication> getAllPubs() {
        HashMap<Integer, Publication> pubDB = queryPubs();
        return pubDB.values();
    }

    private HashMap<Integer, Publication> queryPubs() {
        if (pubCache != null) return pubCache;

        ObjectMapper mapper = new ObjectMapper();
        HashMap<Integer, Publication> pubDB = new HashMap<Integer, Publication>();

        try {
            File jsonDB = new ClassPathResource("pubs.json").getFile();

            List<Publication> pubList = mapper.readValue(jsonDB, new TypeReference<List<Publication>>() {
            });

            for (Publication p : pubList) {
                Integer idx = new Integer(p.getId());
                pubDB.put(idx, p);
            }
            pubCache = pubDB;
            return pubDB;
        } catch (Exception e) {
            e.printStackTrace();
            pubCache = null;
            return null;
        }
    }
}

