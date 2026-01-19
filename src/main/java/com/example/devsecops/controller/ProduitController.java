package com.example.devsecops.controller;

import com.example.devsecops.model.Produit;
import com.example.devsecops.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    // ATTENTION : Faille intentionnelle pour démonstration GitLeaks
    private static final String AZURE_API_SECRET = "AIzaSyB_RE_AZURE_DB_KEY_9876543210_SECRET";

    @GetMapping
    public List<Produit> getAll() {
        return produitService.getAllProduits();
    }

    @PostMapping
    public Produit create(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }

    @DeleteMapping("/{id}")
    public void delete(@pathVariable Long id) {
        produitService.deleteProduit(id);
    }
}
