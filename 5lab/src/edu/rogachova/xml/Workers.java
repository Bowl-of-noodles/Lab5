package edu.rogachova.xml;


import edu.rogachova.commands.Command;
import edu.rogachova.model.Worker;

import javax.xml.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;


/**
     * Root object of XML file. Contains collection of StudyGroup objects
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Workers {

        private HashMap<Long, Worker> workers = null;

        public Workers() {
        }

        /**
         * возвращает коллекцию объектов workers
         */
        public HashMap<Long, Worker> getWorkers() {
            return workers;
        }

        public void setWorkers(HashMap<Long, Worker> workers) {
            this.workers = workers;
        }
}

