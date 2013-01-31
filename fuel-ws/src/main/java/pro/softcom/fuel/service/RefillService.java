package pro.softcom.fuel.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pro.softcom.fuel.domain.Refill;


/**
 * Refill Service responsible for saving and getting refills.
 *
 * @author  Patrick Retornaz
 */
@Stateless
public class RefillService {

    private static final Logger log = LoggerFactory.getLogger(RefillService.class);

    @PersistenceContext(unitName = "fuel-persistence-unit")
    private EntityManager em;

    /**
     * Saves a refill into DB
     *
     * @param   tankerId   string representing the tanker truck
     * @param   machineId  string representing the target machine
     * @param   liters     number of liters
     * @param   date       the date when the refill happend
     */
    public void saveRefill(String tankerId, String machineId, long liters, Date date) {
        Refill r = new Refill();
        r.setTankerId(tankerId);
        r.setMachineId(machineId);
        r.setLiters(liters);
        r.setDate(date);

        if (log.isDebugEnabled()) {
            log.debug("About to persist " + r);
        }

        em.persist(r);

        if (log.isDebugEnabled()) {
            log.debug(r + " persisted.");
        }
    }

    /**
     * Returns all the refills persisted.
     *
     * @return  a {@link List} of {@link Refill} objects.
     */
    public List<Refill> getAllRefill() {
        Query q = em.createQuery("from Refill");
	List<Refill> refills = q.getResultList();

        if (refills == null) {
            refills = Collections.emptyList();
        }

        return refills;
    }
}
