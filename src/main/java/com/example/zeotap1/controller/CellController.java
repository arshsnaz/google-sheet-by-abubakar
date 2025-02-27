package com.example.zeotap1.controller;

import com.example.zeotap1.model.Cell;
import com.example.zeotap1.service.CellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cells")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend access
public class CellController {

    @Autowired
    private CellService cellService;

    // Save or Update a Cell
    @PostMapping
    public Cell saveOrUpdateCell(@RequestBody Cell cell) {
        if (cell.getContent().startsWith("=")) {
            cell.setContent(cellService.evaluateFormula(cell.getContent())); // Evaluate formula
        }
        return cellService.saveOrUpdateCell(cell);
    }

    // Get all cells in a sheet
    @GetMapping("/{sheetName}")
    public List<Cell> getCellsBySheetName(@PathVariable String sheetName) {
        return cellService.getCellsBySheetName(sheetName);
    }

    // Get a specific cell by ID
    @GetMapping("/id/{id}")
    public Optional<Cell> getCellById(@PathVariable Long id) {
        return cellService.getCellById(id);
    }

    // Delete a cell
    @DeleteMapping("/{id}")
    public String deleteCell(@PathVariable Long id) {
        cellService.deleteCell(id);
        return "Cell deleted successfully!";
    }
}
