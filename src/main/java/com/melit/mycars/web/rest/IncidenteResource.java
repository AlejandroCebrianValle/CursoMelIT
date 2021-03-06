package com.melit.mycars.web.rest;

import com.melit.mycars.domain.Incidente;
import com.melit.mycars.repository.IncidenteRepository;
import com.melit.mycars.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional; 
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.melit.mycars.domain.Incidente}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class IncidenteResource {

    private final Logger log = LoggerFactory.getLogger(IncidenteResource.class);

    private static final String ENTITY_NAME = "incidente";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final IncidenteRepository incidenteRepository;

    public IncidenteResource(IncidenteRepository incidenteRepository) {
        this.incidenteRepository = incidenteRepository;
    }

    /**
     * {@code POST  /incidentes} : Create a new incidente.
     *
     * @param incidente the incidente to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new incidente, or with status {@code 400 (Bad Request)} if the incidente has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/incidentes")
    public ResponseEntity<Incidente> createIncidente(@RequestBody Incidente incidente) throws URISyntaxException {
        log.debug("REST request to save Incidente : {}", incidente);
        if (incidente.getId() != null) {
            throw new BadRequestAlertException("A new incidente cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Incidente result = incidenteRepository.save(incidente);
        return ResponseEntity.created(new URI("/api/incidentes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /incidentes} : Updates an existing incidente.
     *
     * @param incidente the incidente to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated incidente,
     * or with status {@code 400 (Bad Request)} if the incidente is not valid,
     * or with status {@code 500 (Internal Server Error)} if the incidente couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/incidentes")
    public ResponseEntity<Incidente> updateIncidente(@RequestBody Incidente incidente) throws URISyntaxException {
        log.debug("REST request to update Incidente : {}", incidente);
        if (incidente.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Incidente result = incidenteRepository.save(incidente);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, incidente.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /incidentes} : get all the incidentes.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of incidentes in body.
     */
    @GetMapping("/incidentes")
    public List<Incidente> getAllIncidentes() {
        log.debug("REST request to get all Incidentes");
        return incidenteRepository.findAll();
    }

    /**
     * {@code GET  /incidentes/:id} : get the "id" incidente.
     *
     * @param id the id of the incidente to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the incidente, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/incidentes/{id}")
    public ResponseEntity<Incidente> getIncidente(@PathVariable Long id) {
        log.debug("REST request to get Incidente : {}", id);
        Optional<Incidente> incidente = incidenteRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(incidente);
    }

    /**
     * {@code DELETE  /incidentes/:id} : delete the "id" incidente.
     *
     * @param id the id of the incidente to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/incidentes/{id}")
    public ResponseEntity<Void> deleteIncidente(@PathVariable Long id) {
        log.debug("REST request to delete Incidente : {}", id);
        incidenteRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
