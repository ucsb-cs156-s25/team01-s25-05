package edu.ucsb.cs156.example.controllers;

import edu.ucsb.cs156.example.entities.UCSBOrganizations;
import edu.ucsb.cs156.example.repositories.UCSBOrganizationsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/ucsborganizations")
@Tag(name = "UCSBOrganizations")
public class UCSBOrganizationsController extends ApiController {

    @Autowired
    UCSBOrganizationsRepository ucsbOrganizationsRepository;

    @Operation(summary = "List all UCSB organizations")
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/all")
    public Iterable<UCSBOrganizations> allOrganizations() {
        return ucsbOrganizationsRepository.findAll();
    }

    @Operation(summary = "Create a new UCSB organization")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/post")
    public UCSBOrganizations createOrganization(
            @RequestParam String orgCode,
            @RequestParam String orgTranslationShort,
            @RequestParam String orgTranslation,
            @RequestParam boolean inactive
    ) {
        UCSBOrganizations org = UCSBOrganizations.builder()
                .orgCode(orgCode)
                .orgTranslationShort(orgTranslationShort)
                .orgTranslation(orgTranslation)
                .inactive(inactive)
                .build();
        return ucsbOrganizationsRepository.save(org);
    }
}
