package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.springapp.model.Leads;
import com.example.springapp.service.LeadServiceInterface;

@RestController
public class LeadController {

    @Autowired
    private LeadServiceInterface leadServiceInterface;

    // Leads - GET,PUT,POST,DELETE operations

    //POST-Adding new lead
    @PostMapping("/leads")
    public Leads createLead(@RequestBody Leads leads){
        return this.leadServiceInterface.addLead(leads);
    }
    //GET-Displaying leads
    @GetMapping("/leads")
    public List<Leads> retrieveLeads(){
        return this.leadServiceInterface.getLeads();
    }
    //GET-one customer based on ID
    @GetMapping("/leads/{id}")
    public Leads getLeadById(@PathVariable("id") long id){
        return this.leadServiceInterface.getLeadById(id);
    }
    //PUT-updating lead details
    @PutMapping("/leads/{id}")
    public Leads updateLead(@PathVariable long id, @RequestBody Leads leads){
        return this.leadServiceInterface.updateLead(id,leads);
    }
    //DELETE - removes specific lead
    @DeleteMapping("/leads/{id}")
    public void deleteLead(@PathVariable long id){
        this.leadServiceInterface.deleteLead(id);
    }
}
